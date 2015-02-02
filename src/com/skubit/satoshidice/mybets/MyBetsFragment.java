/* Copyright 2015 Skubit
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.skubit.satoshidice.mybets;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.skubit.satoshidice.FontManager;
import com.skubit.satoshidice.R;
import com.skubit.satoshidice.accounts.AccountSettings;
import com.skubit.satoshidice.currencies.Bitcoin;
import com.skubit.satoshidice.currencies.Satoshi;
import com.skubit.satoshidice.responses.RecentRollsResponse;
import com.skubit.satoshidice.responses.UserBalanceResponse;
import com.skubit.satoshidice.rest.GlobalStatsRestService;
import com.skubit.satoshidice.rest.UserApiRestService;
import com.skubit.satoshidice.services.GlobalStatsService;
import com.skubit.satoshidice.services.UserApiService;

public class MyBetsFragment extends Fragment {

	private BroadcastReceiver mAccountChange = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			refreshView();
		}
	};

	private BetsAdapter mAdapter;

	private UserApiRestService mApiRestService;

	private TextView mBalance;

	private GlobalStatsRestService mGlobalStatsRestService;

	private String mSecret;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
		mApiRestService = new UserApiService(this.getActivity())
				.getRestService();
		mGlobalStatsRestService = new GlobalStatsService(this.getActivity())
				.getRestService();
		mAdapter = new BetsAdapter(getActivity());
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.bet_transactions_fragment, null);
		TextView balanceLabel = (TextView) view
				.findViewById(R.id.wallet_balance_label);
		balanceLabel.setTypeface(FontManager.CONDENSED_REGULAR);
		mSecret = AccountSettings.get(getActivity()).retrieveSecret();

		mBalance = (TextView) view.findViewById(R.id.wallet_balance);

		ListView list = (ListView) view.findViewById(R.id.list);
		list.setAdapter(mAdapter);

		return view;
	}
	
	@Override
	public void onResume() {
		super.onResume();
		LocalBroadcastManager mng = LocalBroadcastManager
				.getInstance(getActivity());
		mng.registerReceiver(mAccountChange, new IntentFilter(
				"account_change"));
		refreshView();
	}
	
	@Override
	public void onPause() {
		super.onPause();
		LocalBroadcastManager mng = LocalBroadcastManager
				.getInstance(getActivity());
		mng.unregisterReceiver(mAccountChange);
	}

	private void refreshView() {
		mSecret = AccountSettings.get(getActivity()).retrieveSecret();
		
		if(!TextUtils.isEmpty(mSecret)) {
			mGlobalStatsRestService
			.getRecentRolls(mSecret, new Callback<RecentRollsResponse>() {

				@Override
				public void failure(RetrofitError arg0) {
					arg0.printStackTrace();
				}

				@Override
				public void success(RecentRollsResponse recentRolls,
						Response arg1) {
					mAdapter.clear();
					if(recentRolls.getBets() != null) {
						mAdapter.addBets(recentRolls.getBets());
						mAdapter.notifyDataSetChanged();							
					}
				}

			});			
		}

		mApiRestService.getBalance(mSecret,
				new Callback<UserBalanceResponse>() {

					@Override
					public void failure(RetrofitError arg0) {
						arg0.printStackTrace();

					}

					@Override
					public void success(UserBalanceResponse balance,
							Response arg1) {
						Bitcoin bitcoin = new Bitcoin(new Satoshi(balance
								.getBalanceInSatoshis()));
						mBalance.setText(bitcoin.getDisplay());
					}

				});
	}

}
