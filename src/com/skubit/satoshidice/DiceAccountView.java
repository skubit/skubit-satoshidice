/**
 * Copyright 2015 Skubit
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

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.skubit.satoshidice.accounts.AccountSettings;
import com.skubit.satoshidice.provider.accounts.AccountsColumns;
import com.skubit.satoshidice.provider.accounts.AccountsCursor;

public class DiceAccountView extends LinearLayout {

	private static void styleAccountNick(TextView view, String nick) {
		view.setText(nick);
		view.setTypeface(FontManager.REGULAR);
	}

	private Activity mActivity;
	private SimpleCursorAdapter mAdapter;
	private Context mContext;
	private View mDivider;
	protected DrawerLayout mDrawerLayout;
	protected ListView mDropdownList;
	private ImageView mExpanderIcon;

	private View mSpinner;

	public DiceAccountView(Context context) {
		super(context);
		mContext = context;
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.drawer_account_nick, this, true);
	}

	public DiceAccountView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.drawer_account_nick, this, true);
	}

	public DiceAccountView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		mContext = context;
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.drawer_account_nick, this, true);
	}

	public void closeList() {
		mDropdownList.setVisibility(View.GONE);
		mExpanderIcon.setImageResource(R.drawable.ic_action_expand);
		mDivider.setVisibility(View.GONE);
	}

	private String getCurrentAccount() {
		return AccountSettings.get(this.mContext).retrieveNickName();
	}

	public void initialize(final Activity activity, DrawerLayout drawerLayout) {
		mDrawerLayout = drawerLayout;

		mDropdownList = (ListView) findViewById(R.id.account_dropdown);
		final Cursor c = activity.getContentResolver().query(
				AccountsColumns.CONTENT_URI, null, null, null, null);

		mAdapter = new SimpleCursorAdapter(activity,
				R.layout.drawer_account_drop_item, c,
				new String[] { AccountsColumns.NICKNAME },
				new int[] { R.id.account_name },
				CursorAdapter.FLAG_AUTO_REQUERY);

		final AccountsCursor ac = new AccountsCursor(c);

		mSpinner = findViewById(R.id.account_satoshidice);
		mSpinner.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				ImageView expander = (ImageView) mSpinner
						.findViewById(R.id.expander);

				if (!mDropdownList.isShown()) {
					mDropdownList.setVisibility(View.VISIBLE);
					mDivider.setVisibility(View.VISIBLE);
					expander.setImageResource(R.drawable.ic_action_collapse);
					// TODO: close
				} else {
					mDropdownList.setVisibility(View.GONE);
					expander.setImageResource(R.drawable.ic_action_expand);
					mDivider.setVisibility(View.GONE);
				}

			}
		});

		mExpanderIcon = (ImageView) mSpinner.findViewById(R.id.expander);
		mExpanderIcon.setImageResource(R.drawable.ic_action_expand);
		mDivider = findViewById(R.id.account_divider_bottom);
		mDivider.setVisibility(View.GONE);
		mDropdownList.setAdapter(mAdapter);

		mDropdownList
				.setOnItemClickListener(new AdapterView.OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> adapterView,
							View view, int position, long arg3) {
						ac.moveToPosition(position);

						ImageView expander = (ImageView) mSpinner
								.findViewById(R.id.expander);
						expander.setImageResource(R.drawable.ic_action_expand);

						AccountSettings.get(mContext).saveNickName(
								ac.getNickname());
						AccountSettings.get(mContext)
								.saveSecret(ac.getSecret());
						AccountSettings.get(mContext).saveDepositAddress(
								ac.getDepositaddress());
						setAccountName();

						Intent intent = new Intent("account_change");
						LocalBroadcastManager.getInstance(mContext)
								.sendBroadcast(intent);

						mDivider.setVisibility(View.GONE);
						mDropdownList.setVisibility(View.GONE);
						mDrawerLayout.closeDrawers();
					}
				});
		setAccountName();
	}

	public void setAccountName() {
		String name = getCurrentAccount();
		mAdapter.notifyDataSetChanged();

		TextView tv = (TextView) mSpinner.findViewById(R.id.account_name);
		styleAccountNick(tv, name);
	}
}
