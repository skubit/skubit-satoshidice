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

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.skubit.satoshidice.FontManager;
import com.skubit.satoshidice.R;
import com.skubit.satoshidice.responses.Game;

public class BlockChainAdapter extends BaseAdapter {

	private Context mContext;

	private LayoutInflater mInflater;

	ArrayList<Game> games = new ArrayList<Game>();

	private DecimalFormat mFormat;

	public BlockChainAdapter(Context context) {
		mContext = context;
		mInflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		NumberFormat nf = NumberFormat.getNumberInstance(Locale.getDefault());
		mFormat = (DecimalFormat) nf;
		mFormat.setDecimalSeparatorAlwaysShown(true);
		mFormat.setMaximumFractionDigits(3);
		mFormat.setMinimumFractionDigits(3);
	}

	public void clear() {
		games.clear();
	}
	public void addGames(List<Game> bet) {
		games.addAll(bet);
	}

	@Override
	public int getCount() {
		return games.size();
	}

	@Override
	public Game getItem(int position) {
		return games.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = mInflater.inflate(R.layout.blockchain_item, null);
		TextView amount = (TextView) view.findViewById(R.id.blockchain_address);
		
		amount.setTypeface(FontManager.LITE);

		Game game = games.get(position);
		
		String message = MessageFormat.format("{0}%   x{1}", 
				mFormat.format(Double.parseDouble(game.getWinRate()) * 100), 
				mFormat.format(Double.parseDouble(game.getPrizeFactor())));
		
		amount.setText(message);
		
		return view;
	}
}
