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
package com.skubit.satoshidice;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.coinbase.zxing.client.android.Intents;
import com.skubit.satoshidice.accounts.AccountSettings;
import com.skubit.satoshidice.currencies.Bitcoin;
import com.skubit.satoshidice.responses.WithdrawResponse;
import com.skubit.satoshidice.rest.UserApiRestService;
import com.skubit.satoshidice.services.UserApiService;

public class CashoutActivity extends Activity {

	private AccountSettings mAccountSettings;
	private EditText mAmount;
	private UserApiRestService mApiRestService;
	private ImageButton mCameraBtn;
	private View mLoading;
	private View mMain;
	private TextView mMessageView;
	private LinearLayout mSendMessage;
	private EditText mSendTo;
	private Button mWithdrawBtn;

	public void hideMessage() {
		mSendMessage.setVisibility(View.INVISIBLE);
		mLoading.setVisibility(View.INVISIBLE);
		mMain.setVisibility(View.VISIBLE);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (data == null) {
			return;
		}
		String contents = data.getStringExtra("SCAN_RESULT");
		try {
			BitcoinUri bitcoinUri = BitcoinUri.parse(contents);
			mSendTo.setText(bitcoinUri.getAddress());
			mAmount.setText(new Bitcoin(bitcoinUri.getAmount().toString())
					.getDisplay());
		} catch (Exception e) {
			e.printStackTrace();
			Toast.makeText(this, "Invalid QR Code", Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cashout_activity_frame);

		mApiRestService = new UserApiService(this).getRestService();

		this.mLoading = this.findViewById(R.id.progress_bar);
		this.mMain = this.findViewById(R.id.cashout_activity);
		this.mSendMessage = (LinearLayout) this.findViewById(R.id.send_message);

		mSendMessage.setVisibility(View.INVISIBLE);

		mAccountSettings = AccountSettings.get(this);

		this.mMessageView = (TextView) findViewById(R.id.purchase_text);

		mSendTo = (EditText) this.findViewById(R.id.sendTo);
		mAmount = (EditText) this.findViewById(R.id.amount);

		mCameraBtn = (ImageButton) this.findViewById(R.id.cameraButton);
		mCameraBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				startBarcodeScan();
			}
		});

		if (getIntent().getData() != null
				&& "bitcoin".equals(getIntent().getData().getScheme())) {
			try {
				BitcoinUri bitcoinUri = BitcoinUri.parse(getIntent().getData()
						.toString());
				mSendTo.setText(bitcoinUri.getAddress());
				mAmount.setText(new Bitcoin(bitcoinUri.getAmount().toString())
						.getDisplay());
			} catch (Exception e) {
				e.printStackTrace();
				Toast.makeText(this, "Invalid QR Code", Toast.LENGTH_SHORT)
						.show();
			}
		}

		mWithdrawBtn = (Button) this.findViewById(R.id.withdraw_btn);

		mWithdrawBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (!Utils.isNumeric(mAmount.getText().toString())) {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							Toast.makeText(getBaseContext(),
									"Enter a valid amount", Toast.LENGTH_SHORT)
									.show();
							mAmount.setText("");
							hideMessage();
						}
					});

					return;
				}
				showLoading();
				
				mApiRestService.withdrawl(AccountSettings.get(getBaseContext())
						.retrieveSecret(), mSendTo.getText().toString(),
						mAmount.getText().toString(),
						new Callback<WithdrawResponse>() {

							@Override
							public void failure(RetrofitError error) {
								error.printStackTrace();
								showMessage(error.getMessage());
							}

							@Override
							public void success(WithdrawResponse withdraw,
									Response response) {
								showMessage(withdraw.getMessage());
							}

						});

			}

		});


	        
		Button cancelBtn = (Button) this.findViewById(R.id.cancel_btn);
		cancelBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});

	}

	public void showLoading() {
		mMain.setVisibility(View.INVISIBLE);
		mSendMessage.setVisibility(View.INVISIBLE);
		mLoading.setVisibility(View.VISIBLE);
	}

	public void showMessage(String message) {
		mLoading.setVisibility(View.INVISIBLE);
		mMain.setVisibility(View.INVISIBLE);

		mSendMessage.setVisibility(View.VISIBLE);
		mMessageView.setTypeface(FontManager.LITE);
		mMessageView.setText(message);
	}

	public void startBarcodeScan() {
		Intent intent = new Intent(this,
				com.coinbase.zxing.client.android.CaptureActivity.class);
		intent.setAction(Intents.Scan.ACTION);
		intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
		startActivityForResult(intent, 0);
	}

}
