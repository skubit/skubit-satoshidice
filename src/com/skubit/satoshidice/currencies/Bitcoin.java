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

public final class Bitcoin extends BitcoinUnit implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1475391447810889776L;

    public Bitcoin(MilliBitcoin mc) {
        if (mc == null) {
            throw new IllegalArgumentException("MilliBitcoin is null");
        }
        value = mc.getValue().movePointLeft(UnitUtils.MILLI);
    }

    public Bitcoin(Satoshi s) {
        if (s == null) {
            throw new IllegalArgumentException("Satoshi is null");
        }
        value = s.getValue().movePointLeft(UnitUtils.SATOSHI);
    }

    public Bitcoin(String value) {
        if (TextUtils.isEmpty(value)) {
            throw new IllegalArgumentException("value is null");
        }
        this.value = new BigDecimal(value);
    }
    
    public Bitcoin(BigDecimal value) {
        this.value = value;
    }
}
