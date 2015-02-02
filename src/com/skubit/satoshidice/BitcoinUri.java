package com.skubit.satoshidice;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

//From coinbase code (ASL)
public class BitcoinUri {

    public static class InvalidBitcoinUriException extends Exception {
        InvalidBitcoinUriException() {
        }

        InvalidBitcoinUriException(Throwable ex) {
            super(ex);
        }
    }

    public static int BITCOIN_SCALE = 8;

    public static BitcoinUri parse(String uriString) throws InvalidBitcoinUriException {
        BitcoinUri result = new BitcoinUri();

        if (!uriString.startsWith("bitcoin:")) {
            throw new InvalidBitcoinUriException();
        }

        String schemeSpecificPart = uriString.substring("bitcoin:".length());
        String[] addressAndParams = schemeSpecificPart.split("\\?");

        result.setAddress(addressAndParams[0]);

        if(addressAndParams.length > 1) {
            ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
            URLEncodedUtils.parse(params, new Scanner(addressAndParams[1]), "UTF-8");

            for (NameValuePair param : params) {
                if ("label".equals(param.getName())) {
                    result.setLabel(param.getValue());
                } else if ("message".equals(param.getName())) {
                    result.setMessage(param.getValue());
                } else if ("amount".equals(param.getName())) {
                    try {
                        result.setAmount(new BigDecimal(param.getValue()).setScale(BITCOIN_SCALE,
                                RoundingMode.HALF_EVEN));
                    } catch (Exception ex) {
                        throw new InvalidBitcoinUriException(ex);
                    }
                }
            }      	
        }
  

        return result;
    }
    public String address;
    protected BigDecimal amount;

    public String label;

    public String message;

    public BitcoinUri() {
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof BitcoinUri) {
            return toString().equals(other.toString());
        }
        return false;
    }

    public String getAddress() {
        return address;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getLabel() {
        return label;
    }

    public String getMessage() {
        return message;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        StringBuilder uriBuilder = new StringBuilder("bitcoin:");

        uriBuilder.append(address);

       
        ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
        if (this.amount != null) {
            params.add(new BasicNameValuePair("amount", amount.toPlainString()));
        }
        if (this.message != null) {
            params.add(new BasicNameValuePair("message", this.message));
        }
        if (this.label != null) {
            params.add(new BasicNameValuePair("label", this.label));
        }
        if(!params.isEmpty()) {
            uriBuilder.append('?');
            uriBuilder.append(URLEncodedUtils.format(params, "UTF-8"));        	
        }

        return uriBuilder.toString();
    }
}
