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

import android.content.Context;
import android.graphics.Typeface;

public final class FontManager {

	public static Typeface BOLD;

	public static Typeface CONDENSED_REGULAR;

	public static Typeface LITE;

	public static Typeface REGULAR;

	public FontManager(Context ctx) {
		LITE = Typeface.createFromAsset(ctx.getAssets(),
				"fonts/Roboto-Light.ttf");
		BOLD = Typeface.createFromAsset(ctx.getAssets(),
				"fonts/Roboto-Bold.ttf");
		REGULAR = Typeface.createFromAsset(ctx.getAssets(),
				"fonts/Roboto-Regular.ttf");
		CONDENSED_REGULAR = Typeface.createFromAsset(ctx.getAssets(),
				"fonts/RobotoCondensed-Regular.ttf");
		ctx = null;
	}
}
