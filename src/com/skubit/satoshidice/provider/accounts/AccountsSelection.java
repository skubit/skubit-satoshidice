package com.skubit.satoshidice.provider.accounts;

import java.util.Date;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.skubit.satoshidice.provider.base.AbstractSelection;

/**
 * Selection for the {@code accounts} table.
 */
public class AccountsSelection extends AbstractSelection<AccountsSelection> {
    @Override
    public Uri uri() {
        return AccountsColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @param sortOrder How to order the rows, formatted as an SQL ORDER BY clause (excluding the ORDER BY itself). Passing null will use the default sort
     *            order, which may be unordered.
     * @return A {@code AccountsCursor} object, which is positioned before the first entry, or null.
     */
    public AccountsCursor query(ContentResolver contentResolver, String[] projection, String sortOrder) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), sortOrder);
        if (cursor == null) return null;
        return new AccountsCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, projection, null}.
     */
    public AccountsCursor query(ContentResolver contentResolver, String[] projection) {
        return query(contentResolver, projection, null);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, projection, null, null}.
     */
    public AccountsCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null, null);
    }


    public AccountsSelection id(long... value) {
        addEquals("accounts." + AccountsColumns._ID, toObjectArray(value));
        return this;
    }


    public AccountsSelection nickname(String... value) {
        addEquals(AccountsColumns.NICKNAME, value);
        return this;
    }

    public AccountsSelection nicknameNot(String... value) {
        addNotEquals(AccountsColumns.NICKNAME, value);
        return this;
    }

    public AccountsSelection nicknameLike(String... value) {
        addLike(AccountsColumns.NICKNAME, value);
        return this;
    }

    public AccountsSelection secret(String... value) {
        addEquals(AccountsColumns.SECRET, value);
        return this;
    }

    public AccountsSelection secretNot(String... value) {
        addNotEquals(AccountsColumns.SECRET, value);
        return this;
    }

    public AccountsSelection secretLike(String... value) {
        addLike(AccountsColumns.SECRET, value);
        return this;
    }

    public AccountsSelection date(Long... value) {
        addEquals(AccountsColumns.DATE, value);
        return this;
    }

    public AccountsSelection dateNot(Long... value) {
        addNotEquals(AccountsColumns.DATE, value);
        return this;
    }

    public AccountsSelection dateGt(long value) {
        addGreaterThan(AccountsColumns.DATE, value);
        return this;
    }

    public AccountsSelection dateGtEq(long value) {
        addGreaterThanOrEquals(AccountsColumns.DATE, value);
        return this;
    }

    public AccountsSelection dateLt(long value) {
        addLessThan(AccountsColumns.DATE, value);
        return this;
    }

    public AccountsSelection dateLtEq(long value) {
        addLessThanOrEquals(AccountsColumns.DATE, value);
        return this;
    }

    public AccountsSelection depositaddress(String... value) {
        addEquals(AccountsColumns.DEPOSITADDRESS, value);
        return this;
    }

    public AccountsSelection depositaddressNot(String... value) {
        addNotEquals(AccountsColumns.DEPOSITADDRESS, value);
        return this;
    }

    public AccountsSelection depositaddressLike(String... value) {
        addLike(AccountsColumns.DEPOSITADDRESS, value);
        return this;
    }

    public AccountsSelection withdrawaddress(String... value) {
        addEquals(AccountsColumns.WITHDRAWADDRESS, value);
        return this;
    }

    public AccountsSelection withdrawaddressNot(String... value) {
        addNotEquals(AccountsColumns.WITHDRAWADDRESS, value);
        return this;
    }

    public AccountsSelection withdrawaddressLike(String... value) {
        addLike(AccountsColumns.WITHDRAWADDRESS, value);
        return this;
    }

    public AccountsSelection icon(String... value) {
        addEquals(AccountsColumns.ICON, value);
        return this;
    }

    public AccountsSelection iconNot(String... value) {
        addNotEquals(AccountsColumns.ICON, value);
        return this;
    }

    public AccountsSelection iconLike(String... value) {
        addLike(AccountsColumns.ICON, value);
        return this;
    }

    public AccountsSelection hash(String... value) {
        addEquals(AccountsColumns.HASH, value);
        return this;
    }

    public AccountsSelection hashNot(String... value) {
        addNotEquals(AccountsColumns.HASH, value);
        return this;
    }

    public AccountsSelection hashLike(String... value) {
        addLike(AccountsColumns.HASH, value);
        return this;
    }
}
