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

import java.math.BigDecimal;

public final class BetParameters {

	private double payoutMultiple;

	private double winChance;
	
	private int numberToRollUnder;
	
	private static int normalize(int numberToRollUnder) {
		if(numberToRollUnder < 1) {
			numberToRollUnder = 1;
		}
		if(numberToRollUnder > 64225) {
			numberToRollUnder = 64225;
		}
		return numberToRollUnder;
		
	}
	public static BetParameters calculateWithNumberToRollUnder(int numberToRollUnder) {
		BetParameters bp = new BetParameters();
		bp.numberToRollUnder = normalize(numberToRollUnder);
		bp.payoutMultiple = findPayoutMultiple(bp.numberToRollUnder);
		bp.winChance = (double) bp.numberToRollUnder / 65536;
		return bp;
	}
		
	public static BetParameters calculateWithWinChance(BigDecimal winChance) {
		BetParameters bp = new BetParameters();
		int num = (int) (winChance.doubleValue() * 65536);
		bp.numberToRollUnder = normalize(num);
		bp.payoutMultiple = findPayoutMultiple(bp.numberToRollUnder);
		bp.winChance = (num == bp.numberToRollUnder) ? winChance.doubleValue() 
				: (double) bp.numberToRollUnder / 65536;
		
				/*
		bp.winChance = winChance;
		bp.numberToRollUnder = (int) (winChance * 65536);
		bp.payout = findPayout(bp.numberToRollUnder);
		*/
		return bp;
	}
	
	public static BetParameters calculateWithPayoutMultiple(double payout) {
		BetParameters bp = new BetParameters();
		int num = (int) ((65536 * .981) /payout);
		bp.numberToRollUnder = normalize(num);
		bp.payoutMultiple = findPayoutMultiple(bp.numberToRollUnder);
		bp.winChance = (double) bp.numberToRollUnder / 65536;
		/*
		bp.payout = payoutMultiple;
		bp.numberToRollUnder = (int) ((65536 * .981) /payoutMultiple);
		bp.winChance = bp.numberToRollUnder/ (double) 65536;		
		*/
		return bp;
	}
	
	private static double findPayoutMultiple(int numberToRollUnder) {
		return (65536 / (double) numberToRollUnder ) * .981;
	}
		
	public int getNumberToRollUnder() {
		return numberToRollUnder;
	}
	
	public double getWinChance() {
		return winChance;
	}

	public double getPayoutMultiple() {
		return payoutMultiple;
	}

	@Override
	public String toString() {
		return "BetParameters [payoutMultiple=" + payoutMultiple + ", winChance=" + winChance
				+ ", numberToRollUnder=" + numberToRollUnder + "]";
	}
}
