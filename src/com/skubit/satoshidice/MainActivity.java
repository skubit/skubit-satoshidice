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

import android.app.Activity;
import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.skubit.satoshidice.accounts.AccountSettings;
import com.skubit.satoshidice.accounts.CreateAccountActivity;
import com.skubit.satoshidice.blockchain.BlockChainFragment;
import com.skubit.satoshidice.mybets.MyBetsFragment;
import com.skubit.satoshidice.placebet.PlaceBetFragment;
import com.skubit.satoshidice.settings.SettingsFragment;

public class MainActivity extends Activity {

	private BroadcastReceiver mNickChange = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			mAccountView.setAccountName();
		}
	};

	@Override
	public void onStop() {
		super.onStop();
		LocalBroadcastManager mng = LocalBroadcastManager.getInstance(this);
		mng.unregisterReceiver(mNickChange);
	}

	@Override
	public void onStart() {
		super.onStart();
		LocalBroadcastManager mng = LocalBroadcastManager.getInstance(this);
		mng.registerReceiver(mNickChange, new IntentFilter("nick_change"));
	}

	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			selectItem(position);
		}
	}

	private AccountSettings mAccountSettings;
	private DiceAccountView mAccountView;
	private int mCurrentPosition;
	private com.skubit.satoshidice.DrawerAdapter mDrawerAdapter;
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private LinearLayout mDrawerListFrame;
	private ActionBarDrawerToggle mDrawerToggle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
		ViewGroup mActionBarLayout = (ViewGroup) getLayoutInflater().inflate(
				R.layout.action_bar, null);
		TextView mTitle = (TextView) mActionBarLayout
				.findViewById(R.id.displayName);
		mTitle.setTypeface(FontManager.LITE);

		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setDisplayShowCustomEnabled(true);
		// getActionBar().setDisplayShowTitleEnabled(false);
		setColorResource(R.color.action_bar_coin_color);

		mAccountSettings = AccountSettings.get(this);
		String secret = mAccountSettings.retrieveSecret();
		if (TextUtils.isEmpty(secret)) {
			Intent intent = new Intent();
			intent.setClass(this, CreateAccountActivity.class);
			startActivity(intent);
		}

		mAccountView = (DiceAccountView) findViewById(R.id.google_accounts);

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {
			@Override
			public void onDrawerClosed(View view) {
				super.onDrawerClosed(view);
				invalidateOptionsMenu();
			}

			@Override
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
				invalidateOptionsMenu();
			}
		};

		mDrawerList = (ListView) findViewById(R.id.left_drawer);
		mDrawerListFrame = (LinearLayout) this
				.findViewById(R.id.left_drawer_frame);

		mDrawerAdapter = new DrawerAdapter(this, R.array.drawer_items);

		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
		mDrawerLayout.setDrawerListener(mDrawerToggle);

		mDrawerList.setAdapter(mDrawerAdapter);

		mCurrentPosition = AccountSettings.get(getBaseContext())
				.getCurrentIndex();

		mDrawerAdapter.setBoldPosition(mCurrentPosition);
		selectItem(mCurrentPosition);

		mAccountView.initialize(this, mDrawerLayout);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int order = item.getOrder();
		if (order == 0) {
			if (mDrawerToggle.onOptionsItemSelected(item)) {
				return true;
			}
		} else if (order == 1) {
			Intent intent = new Intent();
			intent.setClass(this, CreateAccountActivity.class);
			startActivity(intent);
		} else if (order == 2) {
			Intent i = new Intent();
			i.setClass(this, CashoutActivity.class);
			startActivity(i);
		} else if (order == 3) {
			Intent i = new Intent();
			i.setClass(this, DepositActivity.class);
			startActivity(i);
		} else if (order == 4) {
			Intent i = new Intent();
			i.setClass(this, DisplayLicensesActivity.class);
			startActivity(i);

		}
		return super.onOptionsItemSelected(item);
	}

	private Fragment replaceFragmentFor(String tag, Fragment frag) {
		Fragment fragment = getFragmentManager().findFragmentByTag(tag);
		if (fragment == null) {
			fragment = frag;
		}
		getFragmentManager().beginTransaction()
				.replace(R.id.main_container, fragment, tag).commit();
		return fragment;
	}

	private void selectItem(int position) {
		AccountSettings.get(getBaseContext()).setCurrentIndex(position);
		if (position < 4) {
			this.mCurrentPosition = position;
		}

		if (position == 0) {
			replaceFragmentFor("your_bets", new MyBetsFragment());
		} else if (position == 1) {
			replaceFragmentFor("place_bet", new PlaceBetFragment());
		} else if (position == 2) {
			replaceFragmentFor("blockchain", new BlockChainFragment());
		} else if (position == 3) {
			replaceFragmentFor("settings", new SettingsFragment());
		}
		mDrawerAdapter.setBoldPosition(position);
		mDrawerLayout.closeDrawer(mDrawerListFrame);
	}

	protected void setColorResource(int color) {
		String hex = getResources().getString(color);
		getActionBar().setBackgroundDrawable(
				new ColorDrawable(Color.parseColor(hex)));
	}
}
