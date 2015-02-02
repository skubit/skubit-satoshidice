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

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.EditText;

public class BetEditText extends EditText {

	private Intent mEventIntent;
	
	public BetEditText(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public BetEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public BetEditText(Context context) {
		super(context);
	}

	public void setEventIntent(Intent intent) {
		mEventIntent = intent;
	}
	
	@Override
	public boolean onKeyPreIme(int keyCode, KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
			if(mEventIntent != null) {
				LocalBroadcastManager.getInstance(this.getContext()).sendBroadcast(mEventIntent);
			}		
			return true;
		}
		return super.onKeyPreIme(keyCode, event);
	}

}
