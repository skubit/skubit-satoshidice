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
package com.skubit.satoshidice;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class DrawerAdapter extends BaseAdapter {

	private int mBoldPosition;
	protected Activity mContext;
	protected LayoutInflater mInflater;
	private ArrayList<String> mList = new ArrayList<String>();

	public DrawerAdapter(Activity ctx) {
		mContext = ctx;

		mInflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public DrawerAdapter(Activity ctx, int arrays) {
		this(ctx);
		String[] items = ctx.getResources().getStringArray(arrays);
		for (String item : items) {
			addItem(item);
		}
	}

	public void addItem(String item) {
		mList.add(item);
	}

	@Override
	public int getCount() {
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		if (convertView == null) {
			if (position < 5) {
				convertView = mInflater
						.inflate(R.layout.drawer_list_item, null);
			} else {
				convertView = mInflater.inflate(
						R.layout.drawer_list_item_low_priority, null);
			}
		}
		TextView itemView = (TextView) convertView;
		itemView.setText(mList.get(position));
		itemView.setTypeface((mBoldPosition == position) ? FontManager.BOLD
				: FontManager.LITE);
		return itemView;
	}

	public void setBoldPosition(int boldPosition) {
		mBoldPosition = boldPosition;
		notifyDataSetChanged();
	}
}
