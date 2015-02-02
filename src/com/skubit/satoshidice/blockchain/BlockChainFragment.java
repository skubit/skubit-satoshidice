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
package com.skubit.satoshidice.blockchain;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.skubit.satoshidice.R;
import com.skubit.satoshidice.responses.BlockChainAddressesResponse;
import com.skubit.satoshidice.responses.Game;
import com.skubit.satoshidice.rest.GlobalStatsRestService;
import com.skubit.satoshidice.services.GlobalStatsService;

public class BlockChainFragment extends Fragment {

	private GlobalStatsRestService mGlobalStatsRestService;
	
	private BlockChainAdapter mAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
		mGlobalStatsRestService = new GlobalStatsService(this.getActivity()).getRestService();
		mAdapter = new BlockChainAdapter(getActivity());
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.blockchain_fragment, null);  
		View progressView = view.findViewById(R.id.emptyList);
		
        ListView list = (ListView) view.findViewById(R.id.list);
        list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
      
        list.setEmptyView(progressView);
        list.setAdapter(mAdapter);
        
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
					Game game = mAdapter.getItem(position);
							
					GameData data = new GameData();
					data.setAddress(game.getAddress());
					data.setBetName(game.getBetName());
					data.setMaxBet(Long.valueOf(game.getMaxBet()));
					data.setMinBet(Long.valueOf(game.getMinBet()));
					data.setPrizeFactor(Double.parseDouble(game.getPrizeFactor()));
					data.setWinRate(Double.parseDouble(game.getWinRate()));
					
					Intent intent = BlockDetailsActivity.newIntent(data);
					startActivity(intent);
			}
		});
        
		return view;
	}

	@Override
	public void onResume() {
		super.onResume();
		mGlobalStatsRestService.getAddresses(new Callback<BlockChainAddressesResponse>() {

			@Override
			public void failure(RetrofitError error) {
				error.printStackTrace();
				
			}

			@Override
			public void success(BlockChainAddressesResponse arg0, Response arg1) {
				mAdapter.clear();
				mAdapter.addGames(arg0.getGames());
				mAdapter.notifyDataSetChanged();				
			}
			
		});
	}
	
	
}
