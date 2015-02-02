package com.skubit.satoshidice.provider.accounts;

import java.util.Date;

import android.content.ContentResolver;
import android.net.Uri;

import com.skubit.satoshidice.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code accounts} table.
 */
public class AccountsContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return AccountsColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, AccountsSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public AccountsContentValues putNickname(String value) {
        mContentValues.put(AccountsColumns.NICKNAME, value);
        return this;
    }

    public AccountsContentValues putNicknameNull() {
        mContentValues.putNull(AccountsColumns.NICKNAME);
        return this;
    }


    public AccountsContentValues putSecret(String value) {
        mContentValues.put(AccountsColumns.SECRET, value);
        return this;
    }

    public AccountsContentValues putSecretNull() {
        mContentValues.putNull(AccountsColumns.SECRET);
        return this;
    }


    public AccountsContentValues putDate(Long value) {
        mContentValues.put(AccountsColumns.DATE, value);
        return this;
    }

    public AccountsContentValues putDateNull() {
        mContentValues.putNull(AccountsColumns.DATE);
        return this;
    }


    public AccountsContentValues putDepositaddress(String value) {
        mContentValues.put(AccountsColumns.DEPOSITADDRESS, value);
        return this;
    }

    public AccountsContentValues putDepositaddressNull() {
        mContentValues.putNull(AccountsColumns.DEPOSITADDRESS);
        return this;
    }


    public AccountsContentValues putWithdrawaddress(String value) {
        mContentValues.put(AccountsColumns.WITHDRAWADDRESS, value);
        return this;
    }

    public AccountsContentValues putWithdrawaddressNull() {
        mContentValues.putNull(AccountsColumns.WITHDRAWADDRESS);
        return this;
    }


    public AccountsContentValues putIcon(String value) {
        mContentValues.put(AccountsColumns.ICON, value);
        return this;
    }

    public AccountsContentValues putIconNull() {
        mContentValues.putNull(AccountsColumns.ICON);
        return this;
    }


    public AccountsContentValues putHash(String value) {
        mContentValues.put(AccountsColumns.HASH, value);
        return this;
    }

    public AccountsContentValues putHashNull() {
        mContentValues.putNull(AccountsColumns.HASH);
        return this;
    }

}
