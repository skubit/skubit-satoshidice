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
package com.skubit.satoshidice.accounts;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.Window;

import com.skubit.satoshidice.BaseLoadingActivity;
import com.skubit.satoshidice.R;
import com.skubit.satoshidice.provider.accounts.AccountsColumns;
import com.skubit.satoshidice.provider.accounts.AccountsContentValues;
import com.skubit.satoshidice.responses.UserAddressResponse;
import com.skubit.satoshidice.rest.UserApiRestService;
import com.skubit.satoshidice.services.UserApiService;

public class CreateAccountActivity extends BaseLoadingActivity {

	private UserApiRestService mApiRestService;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.setContentView(R.layout.create_account_activity_frame);
		super.onCreate(savedInstanceState);

		mApiRestService = new UserApiService(this).getRestService();
		showLoading();

		mApiRestService.addUser(new Callback<Response>() {

			@Override
			public void failure(RetrofitError error) {
				error.printStackTrace();
				hideLoading();
				showMessage(error.getMessage());

			}

			@Override
			public void success(Response address, Response arg1) {
				final String secret = getSecret(address);
				if (secret == null) {
					return;
				}
				mApiRestService.getUserAddress(secret,
						new Callback<UserAddressResponse>() {

							@Override
							public void failure(RetrofitError e) {
								hideLoading();
								showMessage(e.getMessage());
							}

							@Override
							public void success(
									UserAddressResponse userAddress,
									Response arg1) {
								hideLoading();
								updateAccount(secret, userAddress.getNick(),
										userAddress.getDepositaddress());
								showMessage("Welcome,  "
										+ userAddress.getNick() + "!");
								Intent intent = new Intent("nick_change");
								LocalBroadcastManager.getInstance(getBaseContext())
										.sendBroadcast(intent);
							}

						});
			}

		});
	}

	private String getSecret(Response response) {
		String secret;
		try {
			secret = new Scanner(response.getBody().in(), "UTF-8")
					.useDelimiter("\\A").next();
		} catch (IOException e) {
			e.printStackTrace();
			showMessage(e.getMessage());
			return null;
		}
		return secret;
	}

	private void updateAccount(String secret, String nickname,
			String bitcoinAddress) {
		AccountsContentValues kcv = new AccountsContentValues();
		kcv.putNickname(nickname);
		kcv.putSecret(secret);
		kcv.putDepositaddress(bitcoinAddress);
		kcv.putDate(new Date().getTime());

		getContentResolver().insert(AccountsColumns.CONTENT_URI, kcv.values());

		AccountSettings.get(this).saveNickName(nickname);
		AccountSettings.get(this).saveSecret(secret);
		AccountSettings.get(this).saveDepositAddress(bitcoinAddress);
	}

}
