/**
 * Copyright 2014 Skubit
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

import android.content.Context;
import android.content.SharedPreferences;

import com.skubit.satoshidice.Constants;

public class AccountSettings {

	private static final String DEPOSIT_ADDRESS = "depositAddress";

	private static final String INDEX = "index";

	private static final String NICK_NAME = "nickName";

	private static final String SECRET = "secret";

	private static volatile AccountSettings sInstance = null;

	public static AccountSettings get(Context context) {
		if (sInstance == null) {
			synchronized (AccountSettings.class) {
				if (sInstance == null) {
					sInstance = new AccountSettings(context);
				}
			}
		}
		return sInstance;
	}

	private Context context;

	private AccountSettings(Context context) {
		this.context = context;
	}

	public int getCurrentIndex() {
		return retrieveIntPreference(INDEX);
	}

	public String retrieveDepositAddress() {
		return retrieveStringPreference(DEPOSIT_ADDRESS);
	}

	private int retrieveIntPreference(String key) {
		SharedPreferences sharedPreferences = context.getSharedPreferences(
				Constants.SHARED_PREFERENCE, Context.MODE_PRIVATE);
		return sharedPreferences.getInt(key, 0);
	}

	public String retrieveNickName() {
		return retrieveStringPreference(NICK_NAME);
	}

	public String retrieveSecret() {
		return retrieveStringPreference(SECRET);
	}

	private String retrieveStringPreference(String key) {
		SharedPreferences sharedPreferences = context.getSharedPreferences(
				Constants.SHARED_PREFERENCE, Context.MODE_PRIVATE);
		return sharedPreferences.getString(key, null);
	}

	public void saveDepositAddress(String address) {
		saveStringPreference(DEPOSIT_ADDRESS, address);
	}

	private void saveIntPreference(String key, int value) {
		SharedPreferences sharedPreferences = context.getSharedPreferences(
				Constants.SHARED_PREFERENCE, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.putInt(key, value);
		editor.commit();
	}

	public void saveNickName(String nickName) {
		saveStringPreference(NICK_NAME, nickName);
	}

	public void saveSecret(String cookie) {
		saveStringPreference(SECRET, cookie);
	}

	private void saveStringPreference(String key, String value) {
		SharedPreferences sharedPreferences = context.getSharedPreferences(
				Constants.SHARED_PREFERENCE, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.putString(key, value);
		editor.commit();
	}

	public void setCurrentIndex(int index) {
		saveIntPreference(INDEX, index);
	}
}
