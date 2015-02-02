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

package com.skubit.satoshidice.placebet;

import android.os.Parcel;
import android.os.Parcelable;

public class PlaceBetData implements Parcelable {

	public static final Parcelable.Creator<PlaceBetData> CREATOR = new Parcelable.Creator<PlaceBetData>() {
		@Override
		public PlaceBetData createFromParcel(Parcel parcel) {
			PlaceBetData info = new PlaceBetData();
			info.betInSatoshis = parcel.readLong();
			info.profit = parcel.readLong();
			info.roll = parcel.readInt();
			return info;
		}

		@Override
		public PlaceBetData[] newArray(int size) {
			return new PlaceBetData[size];
		}
	};

	private long betInSatoshis;
	private int roll;
	private long profit;
	
	public long getProfit() {
		return profit;
	}

	public void setProfit(long profit) {
		this.profit = profit;
	}

	public long getBetInSatoshis() {
		return betInSatoshis;
	}

	public void setBetInSatoshis(long betInSatoshis) {
		this.betInSatoshis = betInSatoshis;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeLong(betInSatoshis);
		parcel.writeLong(profit);
		parcel.writeInt(roll);
	}

	@Override
	public String toString() {
		return "PlaceBetData [betInSatoshis=" + betInSatoshis + ", roll="
				+ roll + ", profit=" + profit + "]";
	}
}
