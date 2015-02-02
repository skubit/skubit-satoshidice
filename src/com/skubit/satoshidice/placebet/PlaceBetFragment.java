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
package com.skubit.satoshidice.placebet;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

import com.skubit.satoshidice.R;
import com.skubit.satoshidice.currencies.Bitcoin;
import com.skubit.satoshidice.currencies.Satoshi;
import com.skubit.satoshidice.rest.UserApiRestService;
import com.skubit.satoshidice.services.UserApiService;

public class PlaceBetFragment extends Fragment {
	private UserApiRestService mApiRestService;
	private BetEditText mBetAmountEdit;

	private Button mBetBtn;
	private BetEditText mPayoutEdit;
	private DecimalFormat mPayoutFormat;
	private BetEditText mProfitEdit;

	private BetEditText mRollEdit;
	private SeekBar mSeekbar;

	private BroadcastReceiver mUpdateBetAmountField = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			updateBetAmountField();
		}
	};

	private BroadcastReceiver mUpdatePayoutField = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			updatePayoutField();
		}
	};

	private BroadcastReceiver mUpdateProfitField = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			updateProfitField();
		}
	};

	private BroadcastReceiver mUpdateRollField = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			updateRollField();
		}
	};

	private BroadcastReceiver mUpdateWinField = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			updateWinField();
		}
	};

	private BetEditText mWinEdit;

	private DecimalFormat mWinFormat;
	private BigDecimal getCurrentPayoutAmount(double pm) {
		String amountStr = mBetAmountEdit.getText().toString();
		Bitcoin amount = (TextUtils.isEmpty(amountStr)) ? new Bitcoin("0")
				: new Bitcoin(amountStr);

		BigDecimal payoutMultiple = new BigDecimal(pm);
		return amount.getValue().multiply(payoutMultiple);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);

		mApiRestService = new UserApiService(this.getActivity())
				.getRestService();

		NumberFormat nf = NumberFormat.getNumberInstance(Locale.getDefault());
		mPayoutFormat = (DecimalFormat) nf;
		mPayoutFormat.setDecimalSeparatorAlwaysShown(true);
		mPayoutFormat.setMaximumFractionDigits(5);
		mPayoutFormat.setMinimumFractionDigits(0);

		NumberFormat nf1 = NumberFormat.getNumberInstance(Locale.getDefault());
		mWinFormat = (DecimalFormat) nf1;
		mWinFormat.setDecimalSeparatorAlwaysShown(true);
		mWinFormat.setMaximumFractionDigits(3);
		mWinFormat.setMinimumFractionDigits(3);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.place_bet_fragment, null);

		mBetBtn = (Button) view.findViewById(R.id.betBtn);

		mRollEdit = (BetEditText) view.findViewById(R.id.underEdit);
		mPayoutEdit = (BetEditText) view.findViewById(R.id.payoutEdit);
		mWinEdit = (BetEditText) view.findViewById(R.id.winEdit);
		mProfitEdit = (BetEditText) view.findViewById(R.id.profitEdit);
		mBetAmountEdit = (BetEditText) view.findViewById(R.id.betAmountEdit);

		mRollEdit.setEventIntent(new Intent("updateRollField"));
		mPayoutEdit.setEventIntent(new Intent("updatePayoutField"));
		mWinEdit.setEventIntent(new Intent("updateWinField"));
		mProfitEdit.setEventIntent(new Intent("updateProfitField"));
		mBetAmountEdit.setEventIntent(new Intent("updateBetAmountField"));

		mProfitEdit.setFocusable(false);
		mProfitEdit.setFocusableInTouchMode(false);

		mRollEdit.setOnEditorActionListener(new OnEditorActionListener() {

			@Override
			public boolean onEditorAction(TextView v, int actionId,
					KeyEvent event) {
				if (actionId == EditorInfo.IME_ACTION_DONE
						|| actionId == EditorInfo.IME_ACTION_NEXT) {
					updateRollField();
				}
				return false;

			}
		});

		mPayoutEdit.setOnEditorActionListener(new OnEditorActionListener() {

			@Override
			public boolean onEditorAction(TextView v, int actionId,
					KeyEvent event) {
				if (actionId == EditorInfo.IME_ACTION_DONE
						|| actionId == EditorInfo.IME_ACTION_NEXT) {
					updatePayoutField();
				}
				return false;

			}
		});

		mWinEdit.setOnEditorActionListener(new OnEditorActionListener() {

			@Override
			public boolean onEditorAction(TextView v, int actionId,
					KeyEvent event) {
				if (actionId == EditorInfo.IME_ACTION_DONE
						|| actionId == EditorInfo.IME_ACTION_NEXT) {
					updateWinField();
				}
				return false;

			}
		});

		mBetAmountEdit.setOnEditorActionListener(new OnEditorActionListener() {

			@Override
			public boolean onEditorAction(TextView v, int actionId,
					KeyEvent event) {
				if (actionId == EditorInfo.IME_ACTION_DONE
						|| actionId == EditorInfo.IME_ACTION_NEXT) {
					updateBetAmountField();
				}
				return false;

			}
		});

		mSeekbar = (SeekBar) view.findViewById(R.id.betParameters);
		mSeekbar.setMax(64225);
		mSeekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				if (fromUser) {
					BetParameters bp = BetParameters
							.calculateWithNumberToRollUnder(progress);
					setTextFields(bp);
				}
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				mRollEdit.clearFocus();
				mPayoutEdit.clearFocus();
				mWinEdit.clearFocus();
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {

			}
		});

		mBetBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (TextUtils.isEmpty(mRollEdit.getText().toString())
						|| TextUtils.isEmpty(mBetAmountEdit.getText()
								.toString())
						|| TextUtils.isEmpty(mProfitEdit.getText().toString())) {
					Toast.makeText(getActivity(),
							"Enter in bet parameters first", Toast.LENGTH_SHORT)
							.show();
					return;
				}

				int roll = Integer.valueOf(mRollEdit.getText().toString());

				Satoshi betAmount = new Satoshi(new Bitcoin(mBetAmountEdit
						.getText().toString()));
				long betInSatoshis = betAmount.getValueAsLong();

				Satoshi profitAmount = new Satoshi(new Bitcoin(mProfitEdit
						.getText().toString()));
				long profit = profitAmount.getValueAsLong();

				PlaceBetData data = new PlaceBetData();
				data.setBetInSatoshis(betInSatoshis);
				data.setRoll(roll);
				data.setProfit(profit);

				Intent intent = PlaceBetActivity.newIntent(data);
				getActivity().startActivity(intent);

				// String serverHash = mRoundResponse.getHash();
				// String id = String.valueOf(mRoundResponse.getId());

			}
		});
		return view;
	}

	@Override
	public void onPause() {
		super.onPause();
		LocalBroadcastManager mng = LocalBroadcastManager
				.getInstance(getActivity());
		mng.unregisterReceiver(mUpdatePayoutField);
		mng.unregisterReceiver(mUpdateRollField);
		mng.unregisterReceiver(mUpdateWinField);
		mng.unregisterReceiver(mUpdateProfitField);
		mng.unregisterReceiver(mUpdateBetAmountField);
	}

	@Override
	public void onResume() {
		super.onResume();
		LocalBroadcastManager mng = LocalBroadcastManager
				.getInstance(getActivity());
		mng.registerReceiver(mUpdatePayoutField, new IntentFilter(
				"updatePayoutField"));
		mng.registerReceiver(mUpdateRollField, new IntentFilter(
				"updateRollField"));
		mng.registerReceiver(mUpdateWinField,
				new IntentFilter("updateWinField"));
		mng.registerReceiver(mUpdateProfitField, new IntentFilter(
				"updateProfitField"));
		mng.registerReceiver(mUpdateBetAmountField, new IntentFilter(
				"updateBetAmountField"));
	}

	private void setTextFields(BetParameters bp) {
		mRollEdit.setText(String.valueOf(bp.getNumberToRollUnder()));
		mPayoutEdit.setText(mPayoutFormat.format(bp.getPayoutMultiple()));
		mWinEdit.setText(mWinFormat.format((bp.getWinChance()) * 100));

		String amountStr = mBetAmountEdit.getText().toString();
		String formattedAmount = new Bitcoin(TextUtils.isEmpty(amountStr) ? "0"
				: amountStr).getDisplay();

		mBetAmountEdit.setText(formattedAmount);

		BigDecimal payout = getCurrentPayoutAmount(bp.getPayoutMultiple());
		Bitcoin bitcoin = new Bitcoin(payout);
		mProfitEdit.setText(bitcoin.getDisplay());
	}

	private void updateBetAmountField() {
		updateRollField();
	}

	private void updatePayoutField() {
		String text = mPayoutEdit.getText().toString();
		String payoutStr = text.isEmpty() ? "64290" : text.toString();

		NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
		Number number;
		try {
			number = format.parse(payoutStr);
		} catch (ParseException e) {
			e.printStackTrace();
			return;
		}

		BetParameters bp = BetParameters.calculateWithPayoutMultiple(number
				.doubleValue());
		mSeekbar.setProgress(bp.getNumberToRollUnder());
		setTextFields(bp);
	}

	private void updateProfitField() {

	}

	private void updateRollField() {
		String text = mRollEdit.getText().toString();
		BetParameters bp = BetParameters.calculateWithNumberToRollUnder(text
				.isEmpty() ? 1 : Integer.parseInt(text));
		mSeekbar.setProgress(bp.getNumberToRollUnder());
		setTextFields(bp);
	}

	private void updateWinField() {
		String text = mWinEdit.getText().toString();
		BigDecimal bd = text.isEmpty() ? new BigDecimal(.002) : new BigDecimal(
				text.toString());

		BetParameters bp = BetParameters.calculateWithWinChance(bd
				.movePointLeft(2));
		mSeekbar.setProgress(bp.getNumberToRollUnder());
		setTextFields(bp);
	}
}
