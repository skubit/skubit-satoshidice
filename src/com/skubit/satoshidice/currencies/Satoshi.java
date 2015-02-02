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

package com.skubit.satoshidice.currencies;

import java.io.Serializable;
import java.math.BigDecimal;

import android.text.TextUtils;

// 100,000,000th of a Bitcoin
public class Satoshi extends BitcoinUnit implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = 4975058710268329552L;

    public Satoshi(Bitcoin b) {
        if (b == null) {
            throw new IllegalArgumentException("Bitcoin is null");
        }
        value = b.getValue().movePointRight(UnitUtils.SATOSHI);
    }

    public Satoshi(long value) {
        this.value = new BigDecimal(value);
    }

    public Satoshi(MilliBitcoin mc) {
        if (mc == null) {
            throw new IllegalArgumentException("MilliBitcoin is null");
        }
        value = mc.getValue().movePointRight(5);
    }

    public Satoshi(String s) {
        if (TextUtils.isEmpty(s)) {
            throw new IllegalArgumentException("String is null");
        }
        value = new BigDecimal(s);// UnitUtils.moveRight(s, UnitUtils.SATOSHI);
    }

    public long getValueAsLong() {
        return value.longValue();
    }

}
