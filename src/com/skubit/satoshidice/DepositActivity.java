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

import java.math.BigDecimal;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.WriterException;
import com.skubit.satoshidice.accounts.AccountSettings;

public class DepositActivity extends Activity {

    private AccountSettings mAccountSettings;

    private TextView mAddress;

    private String mAddressValue;

    private ImageButton mCopyButton;

    private View mLoading;

    private View mMain;

    private String mNoteValue;

    private ImageView mQrCode;

    private ImageButton mShareButton;

    private void copyToClipboard(String address) {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(
                Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("Bitcoin Address", address);
        clipboard.setPrimaryClip(clip);
    }

    // bitcoin:<address>[?[amount=<size>][&][label=<label>][&][message=<message>]]

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.deposit_activity_frame);
        mAccountSettings = AccountSettings.get(this);
        mQrCode = (ImageView) findViewById(R.id.qr);
        mAddress = (TextView) this.findViewById(R.id.bitcoin_address);
        
        String depositAddress = mAccountSettings.retrieveDepositAddress();//TODO
        if (TextUtils.isEmpty(depositAddress)) {
            return;
        }
        
        this.mLoading = this.findViewById(R.id.progress_bar);
        this.mMain = this.findViewById(R.id.qrcode_activity);
        mAddress.setText(depositAddress);
        mAddressValue = depositAddress;
        showQrCode();

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
                        Utils.createShareIntent(uri, mNoteValue),
                        "Share Bitcoin address to..."));
            }

        });
        
    }
    
    public void showLoading() {
        mMain.setVisibility(View.INVISIBLE);
        mLoading.setVisibility(View.VISIBLE);
    }
    
    public void showMain() {
        mLoading.setVisibility(View.INVISIBLE);
        mMain.setVisibility(View.VISIBLE);
    }

    
    private void showQrCode() {
        if (!TextUtils.isEmpty(mAddressValue)) {
            mAddress.setText(mAddressValue);
            int dimension = (int) (250 * getResources().getDisplayMetrics().density);
            try {
                final BitcoinUri uri = new BitcoinUri();
                uri.address = mAddressValue;
                uri.message = null;

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
}
