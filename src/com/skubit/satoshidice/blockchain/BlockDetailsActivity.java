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
package com.skubit.satoshidice.blockchain;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.WriterException;
import com.skubit.satoshidice.BitcoinUri;
import com.skubit.satoshidice.QRCodeEncoder;
import com.skubit.satoshidice.R;
import com.skubit.satoshidice.Utils;
import com.skubit.satoshidice.accounts.AccountSettings;
import com.skubit.satoshidice.currencies.Bitcoin;
import com.skubit.satoshidice.currencies.Satoshi;

public class BlockDetailsActivity extends Activity {

    public static Intent newIntent(GameData data) {
        Intent intent = new Intent(data.getAddress());

        Parcel parcel = Parcel.obtain();
        data.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);

        intent.putExtra("BlockDetailsActivity.gameData", parcel.marshall());
        intent.setClassName("com.skubit.satoshidice",
        		BlockDetailsActivity.class.getName());
        return intent;
    }

	private GameData mGameData;
	private AccountSettings mAccountSettings;
	private ImageView mQrCode;
	private TextView mAddress;
	private TextView mAmount;
	private String mAddressValue;
	private TextView mBetName;
	private TextView mWinOdds;
	private TextView mPrize;
	private TextView mMinBet;
	private TextView mMaxBet;
	private DecimalFormat mFormat;
	private ImageButton mShareButton;
	private ImageButton mCopyButton;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.block_details_activity);
		NumberFormat nf = NumberFormat.getNumberInstance(Locale.getDefault());
		mFormat = (DecimalFormat) nf;
		mFormat.setDecimalSeparatorAlwaysShown(true);
		mFormat.setMaximumFractionDigits(3);
		mFormat.setMinimumFractionDigits(3);
		
        byte[] byteArrayExtra = getIntent().getByteArrayExtra(
                "BlockDetailsActivity.gameData");
        Parcel parcel = Parcel.obtain();
        parcel.unmarshall(byteArrayExtra, 0, byteArrayExtra.length);
        parcel.setDataPosition(0);
        mGameData = GameData.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        
        mAddressValue = mGameData.getAddress();
        
        mAccountSettings = AccountSettings.get(this);
        mQrCode = (ImageView) findViewById(R.id.qr);
        mAddress = (TextView) this.findViewById(R.id.bitcoin_address);       
        mBetName = (TextView)this.findViewById(R.id.betName);
        
        mWinOdds = (TextView)this.findViewById(R.id.block_win_odds);
        mPrize = (TextView)this.findViewById(R.id.block_prize);
        mMinBet = (TextView)this.findViewById(R.id.block_min_bet);
        mMaxBet = (TextView)this.findViewById(R.id.block_max_bet);
        
        mBetName.setText(mGameData.getBetName());
        mAddress.setText(mGameData.getAddress());
        mWinOdds.setText( (mFormat.format(mGameData.getWinRate() * 100)) + "%");
        mPrize.setText( mFormat.format(mGameData.getPrizeFactor()));
        
        String minBet = new Bitcoin(new Satoshi(mGameData.getMinBet())).getDisplay();
        String maxBet = new Bitcoin(new Satoshi(mGameData.getMaxBet())).getDisplay();
		
        mMinBet.setText(minBet);
        mMaxBet.setText(maxBet);
        

        mCopyButton = (ImageButton) findViewById(R.id.copyButton);
        mCopyButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                copyToClipboard(mAddressValue);
                Toast.makeText(getBaseContext(), "Copied to clipboard",
                        Toast.LENGTH_SHORT).show();
            }

        });
        
        mShareButton = (ImageButton) findViewById(R.id.shareButton);
        mShareButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                BitcoinUri uri = new BitcoinUri();
                uri.address = mAddressValue;
                startActivity(Intent.createChooser(
                        Utils.createShareIntent(uri, ""),
                        "Share Bitcoin address to..."));
            }

        });
        showQrCode();
	}
	
	   private void showQrCode() {
	        if (!TextUtils.isEmpty(mAddressValue)) {
	            mAddress.setText(mAddressValue);
	            int dimension = (int) (250 * getResources().getDisplayMetrics().density);
	            try {
	                final BitcoinUri uri = new BitcoinUri();
	                uri.address = mAddressValue;
	                /*
	                if (!TextUtils.isEmpty(mAmountValue)) {
	                    uri.setAmount(new BigDecimal(mAmountValue));
	                }
*/
	                Bitmap bitmap = QRCodeEncoder.encodeAsBitmap(uri.toString(), dimension);
	                mQrCode.setImageBitmap(bitmap);
	                mQrCode.setOnClickListener(new View.OnClickListener() {
						
						@Override
						public void onClick(View v) {
							Intent i = new Intent();
							i.setData(Uri.parse(uri.toString()));
							startActivity(i);
							
						}
					});
	            } catch (WriterException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    private void copyToClipboard(String address) {
	        ClipboardManager clipboard = (ClipboardManager) getSystemService(
	                Context.CLIPBOARD_SERVICE);
	        ClipData clip = ClipData.newPlainText("Bitcoin Address", address);
	        clipboard.setPrimaryClip(clip);
	    }
	
}
