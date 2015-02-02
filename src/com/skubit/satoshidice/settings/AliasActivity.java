package com.skubit.satoshidice.settings;

import java.util.Date;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.Window;

import com.skubit.satoshidice.BaseLoadingActivity;
import com.skubit.satoshidice.R;
import com.skubit.satoshidice.accounts.AccountSettings;
import com.skubit.satoshidice.provider.accounts.AccountsColumns;
import com.skubit.satoshidice.provider.accounts.AccountsContentValues;
import com.skubit.satoshidice.provider.accounts.AccountsCursor;
import com.skubit.satoshidice.responses.UpdateAliasResponse;
import com.skubit.satoshidice.rest.UserApiRestService;
import com.skubit.satoshidice.services.UserApiService;

public class AliasActivity extends BaseLoadingActivity {

	public static Intent newInstance(String alias) {
		Intent intent = new Intent(alias);
		intent.putExtra("AliasActivity.alias", alias);
		intent.setClassName("com.skubit.satoshidice",
				AliasActivity.class.getName());

		return intent;
	}

	private UserApiRestService mApiRestService;
	private AccountSettings mSettings;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.setContentView(R.layout.alias_activity_frame);
		super.onCreate(savedInstanceState);
		mSettings = AccountSettings.get(this);

		final String alias = getIntent().getStringExtra("AliasActivity.alias");
		final String secret = mSettings.retrieveSecret();

		mApiRestService = new UserApiService(this).getRestService();

		showLoading();

		mApiRestService.updateUser(secret, alias,
				new Callback<UpdateAliasResponse>() {

					@Override
					public void failure(RetrofitError error) {
						error.printStackTrace();
						showMessage(error.getMessage());
					}

					@Override
					public void success(UpdateAliasResponse updateAlias,
							Response response) {
						showMessage(updateAlias.getMessage());
						if ("success".equals(updateAlias.getResult())) {
							mSettings.saveNickName(alias);
							String selection = AccountsColumns.SECRET + " = ?";
							String[] selectionArgs = new String[] { secret };

							final Cursor c = getContentResolver().query(
									AccountsColumns.CONTENT_URI, null,
									selection, selectionArgs, null);
							final AccountsCursor ac = new AccountsCursor(c);
							ac.moveToFirst();

							AccountsContentValues kcv = new AccountsContentValues();
							kcv.putNickname(alias);
							kcv.putSecret(ac.getSecret());
							kcv.putDepositaddress(ac.getDepositaddress());
							kcv.putDate(new Date().getTime());
							ac.close();
							c.close();

							getContentResolver().update(
									AccountsColumns.CONTENT_URI, kcv.values(),
									selection, selectionArgs);
							getContentResolver().notifyChange(
									AccountsColumns.CONTENT_URI, null);

							Intent intent = new Intent("nick_change");
							LocalBroadcastManager.getInstance(getBaseContext())
									.sendBroadcast(intent);

						}

					}

				});
	}

}
