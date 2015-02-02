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

package com.skubit.satoshidice.blockchain;

import android.os.Parcel;
import android.os.Parcelable;

public class GameData implements Parcelable {

    public static final Parcelable.Creator<GameData> CREATOR = new Parcelable.Creator<GameData>() {
        @Override
        public GameData createFromParcel(Parcel parcel) {
            GameData info = new GameData();
            info.betName = parcel.readString();
            info.address = parcel.readString();
            info.winRate = parcel.readDouble();
            info.prizeFactor = parcel.readDouble();
            info.minBet = parcel.readLong();
            info.maxBet = parcel.readLong();
           
            return info;
        }

        @Override
        public GameData[] newArray(int size) {
            return new GameData[size];
        }
    };
    private String address;
    
    private String betName;
    
    private long maxBet;
    
    private long minBet;
    
    private double prizeFactor;
    
    private double winRate;
    
    @Override
    public int describeContents() {
        return 0;
    }

	public String getAddress() {
		return address;
	}

	public String getBetName() {
		return betName;
	}

	public long getMaxBet() {
		return maxBet;
	}

	public void setMaxBet(long maxBet) {
		this.maxBet = maxBet;
	}

	public long getMinBet() {
		return minBet;
	}

	public void setMinBet(long minBet) {
		this.minBet = minBet;
	}

	public double getPrizeFactor() {
		return prizeFactor;
	}

	public double getWinRate() {
		return winRate;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setBetName(String betName) {
		this.betName = betName;
	}


	public void setPrizeFactor(double prizeFactor) {
		this.prizeFactor = prizeFactor;
	}

	public void setWinRate(double winRate) {
		this.winRate = winRate;
	}
    
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(betName);
        parcel.writeString(address);
        parcel.writeDouble(winRate);
        parcel.writeDouble(prizeFactor);
        parcel.writeLong(minBet);
        parcel.writeLong(maxBet);
    }
}
