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

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.skubit.satoshidice.currencies.Bitcoin;
import com.skubit.satoshidice.currencies.Satoshi;
import com.skubit.satoshidice.responses.Bet;

public class BetsAdapter extends BaseAdapter {

	private Context mContext;

	private LayoutInflater mInflater;

	ArrayList<Bet> bets = new ArrayList<Bet>();

	public BetsAdapter(Context context) {
		mContext = context;
		mInflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	public void clear() {
		bets.clear();
	}

	public void addBets(List<Bet> bet) {
		bets.addAll(bet);
	}

	@Override
	public int getCount() {
		return bets.size();
	}

	@Override
	public Bet getItem(int position) {
		return bets.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = mInflater.inflate(R.layout.bet_item, null);
		TextView amount = (TextView) view.findViewById(R.id.bet_amount);
		TextView messageView = (TextView) view.findViewById(R.id.bet_message);
		TextView dateView = (TextView) view.findViewById(R.id.bet_date);
		messageView.setTypeface(FontManager.LITE);

		Bet bet = bets.get(position);
		String message = MessageFormat.format("You {0} with roll {1} ({2}%)",
				"win".equals(bet.getResult()) ? "won" : "lost", bet.getRoll(),
				bet.getRollInPercent());
		messageView.setText(message);
		Bitcoin bitcoin = new Bitcoin(new Satoshi(bet.getProfitInSatoshis()));
		formatBalance(amount, bitcoin.getValue());

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"MMMM dd, yyyy \r\n   'at' hh:mma zzz");
		try {
			Date parsedDate = formatter.parse(bet.getTime());
			dateView.setText(dateFormat.format(parsedDate));
		} catch (ParseException e) {
			e.printStackTrace();
			dateView.setText(null);
		}

		return view;
	}

	private void formatBalance(TextView view, BigDecimal amount) {
		String balanceString = formatCurrencyAmount(amount);
		if (balanceString.startsWith("-")) {
			balanceString = balanceString.substring(1);
		}

		int sign = amount.compareTo(BigDecimal.ZERO);
		int color = sign == -1 ? R.color.transaction_negative
				: (sign == 0 ? R.color.transaction_neutral
						: R.color.transaction_positive);

		view.setText(balanceString + " BTC");
		view.setTextColor(mContext.getResources().getColor(color));
	}

	private static final String formatCurrencyAmount(BigDecimal balanceNumber) {
		NumberFormat numberFormat = NumberFormat.getInstance(Locale
				.getDefault());
		numberFormat.setMaximumFractionDigits(8);
		numberFormat.setMinimumFractionDigits(4);

		if (balanceNumber.compareTo(BigDecimal.ZERO) == -1) {
			balanceNumber = balanceNumber.multiply(new BigDecimal(-1));
		}

		return numberFormat.format(balanceNumber);
	}

}
