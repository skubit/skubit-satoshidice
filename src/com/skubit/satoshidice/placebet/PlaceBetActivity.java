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

import java.text.MessageFormat;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import android.view.Window;

import com.skubit.satoshidice.BaseLoadingActivity;
import com.skubit.satoshidice.R;
import com.skubit.satoshidice.accounts.AccountSettings;
import com.skubit.satoshidice.currencies.Bitcoin;
import com.skubit.satoshidice.currencies.Satoshi;
import com.skubit.satoshidice.responses.PlaceBetResponse;
import com.skubit.satoshidice.responses.StartRoundResponse;
import com.skubit.satoshidice.rest.UserApiRestService;
import com.skubit.satoshidice.services.UserApiService;

public class PlaceBetActivity extends BaseLoadingActivity {

	public static Intent newIntent(PlaceBetData data) {
		Intent intent = new Intent(String.valueOf(System.currentTimeMillis()));

		Parcel parcel = Parcel.obtain();
		data.writeToParcel(parcel, 0);
		parcel.setDataPosition(0);

		intent.putExtra("PlaceBetActivity.placeBetData", parcel.marshall());
		intent.setClassName("com.skubit.satoshidice",
				PlaceBetActivity.class.getName());
		return intent;
	}

	private UserApiRestService mApiRestService;
	private PlaceBetData mPlaceBetData;
	private String mSecret;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.setContentView(R.layout.place_bet_activity_frame);
		super.onCreate(savedInstanceState);

		byte[] byteArrayExtra = getIntent().getByteArrayExtra(
				"PlaceBetActivity.placeBetData");
		Parcel parcel = Parcel.obtain();
		parcel.unmarshall(byteArrayExtra, 0, byteArrayExtra.length);
		parcel.setDataPosition(0);
		mPlaceBetData = PlaceBetData.CREATOR.createFromParcel(parcel);
		mApiRestService = new UserApiService(this).getRestService();
		showLoading();

		mSecret = AccountSettings.get(this).retrieveSecret();

		mApiRestService.startRound(mSecret, new Callback<StartRoundResponse>() {

			@Override
			public void failure(RetrofitError error) {
				error.printStackTrace();
				showMessage("There was a problem generating a new round. Try again: "
						+ error.getMessage());
			}

			@Override
			public void success(StartRoundResponse roundResponse,
					Response response) {
				long maxProfit = roundResponse.getMaxProfitInSatoshis();
				if (mPlaceBetData.getProfit() > maxProfit) {
					String message = MessageFormat
							.format("The profit from a win would be higher than max allowed ({0}). Try a new bet",
									new Bitcoin(new Satoshi(maxProfit)).getDisplay());
					showMessage(message);

				} else {
					placeBet(roundResponse);
				}
			}
		});
	}

	private void placeBet(final StartRoundResponse roundResponse) {
		String clientRoll = String.valueOf(System.currentTimeMillis());
		clientRoll = clientRoll.substring(
				Math.max(0, clientRoll.length() - 10), clientRoll.length());

		mApiRestService.placeBet(mSecret, mPlaceBetData.getBetInSatoshis(),
				String.valueOf(roundResponse.getId()), roundResponse.getHash(),
				clientRoll, mPlaceBetData.getRoll(),
				new Callback<PlaceBetResponse>() {

					@Override
					public void failure(RetrofitError error) {
						error.printStackTrace();
						showMessage(error.getMessage());

					}

					@Override
					public void success(PlaceBetResponse placeBet,
							Response response) {
						if ("success".equals(placeBet.getStatus())) {
							showMessage(placeBet.getMessage());
						} else {
							if (!TextUtils.isEmpty(placeBet.getMessage())) {
								showMessage(placeBet.getMessage());
							} else {
								showMessage(placeBet.getVerbose());
							}

						}
					}

				});
	}

}
