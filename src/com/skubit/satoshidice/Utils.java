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

import android.content.Intent;
import android.text.TextUtils;

public class Utils {

    public static Intent createShareIntent(BitcoinUri uri, String defaultMessage) {
        if (TextUtils.isEmpty(uri.message)) {
            uri.message = defaultMessage;
        }
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, uri.message);
        sendIntent.putExtra(Intent.EXTRA_TEXT, uri.toString());
        sendIntent.setType("text/plain");
        return sendIntent;
    }
    
    public static boolean isNumeric(String value) {
        try {
            Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
