package com.skubit.satoshidice.provider.accounts;

import java.util.Date;

import android.database.Cursor;

import com.skubit.satoshidice.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code accounts} table.
 */
public class AccountsCursor extends AbstractCursor {
    public AccountsCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Get the {@code nickname} value.
     * Can be {@code null}.
     */
    public String getNickname() {
        Integer index = getCachedColumnIndexOrThrow(AccountsColumns.NICKNAME);
        return getString(index);
    }

    /**
     * Get the {@code secret} value.
     * Can be {@code null}.
     */
    public String getSecret() {
        Integer index = getCachedColumnIndexOrThrow(AccountsColumns.SECRET);
        return getString(index);
    }

    /**
     * Get the {@code date} value.
     * Can be {@code null}.
     */
    public Long getDate() {
        return getLongOrNull(AccountsColumns.DATE);
    }

    /**
     * Get the {@code depositaddress} value.
     * Can be {@code null}.
     */
    public String getDepositaddress() {
        Integer index = getCachedColumnIndexOrThrow(AccountsColumns.DEPOSITADDRESS);
        return getString(index);
    }

    /**
     * Get the {@code withdrawaddress} value.
     * Can be {@code null}.
     */
    public String getWithdrawaddress() {
        Integer index = getCachedColumnIndexOrThrow(AccountsColumns.WITHDRAWADDRESS);
        return getString(index);
    }

    /**
     * Get the {@code icon} value.
     * Can be {@code null}.
     */
    public String getIcon() {
        Integer index = getCachedColumnIndexOrThrow(AccountsColumns.ICON);
        return getString(index);
    }

    /**
     * Get the {@code hash} value.
     * Can be {@code null}.
     */
    public String getHash() {
        Integer index = getCachedColumnIndexOrThrow(AccountsColumns.HASH);
        return getString(index);
    }
}
