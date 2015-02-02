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
package com.skubit.satoshidice.settings;

import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.skubit.satoshidice.R;
import com.skubit.satoshidice.rest.UserApiRestService;
import com.skubit.satoshidice.services.UserApiService;

public class SettingsFragment extends Fragment {

	private BroadcastReceiver mAccountChange = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			refreshView();
		}
	};
	private Button mSecretBtn;
	private Button mAliasBtn;
	private UserApiRestService mApiRestService;
	private EditText mNewAlias;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.settings_fragment, null);
		mSecretBtn = (Button) view.findViewById(R.id.secretBtn);
		mAliasBtn = (Button) view.findViewById(R.id.aliasBtn);
		mNewAlias = (EditText) view.findViewById(R.id.newAlias);

		mSecretBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent();
				i.setClass(getActivity(), SecretActivity.class);
				startActivity(i);

			}
		});

		mAliasBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivity(AliasActivity.newInstance(mNewAlias.getText()
						.toString()));
			}
		});
		return view;
	}

	@Override
	public void onPause() {
		super.onPause();
		LocalBroadcastManager mng = LocalBroadcastManager
				.getInstance(getActivity());
		mng.unregisterReceiver(mAccountChange);
	}

	@Override
	public void onResume() {
		super.onResume();
		LocalBroadcastManager mng = LocalBroadcastManager
				.getInstance(getActivity());
		mng.registerReceiver(mAccountChange, new IntentFilter("account_change"));
		refreshView();
	}

	private void refreshView() {

	}

}
