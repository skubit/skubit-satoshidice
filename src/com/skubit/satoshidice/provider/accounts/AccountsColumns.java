package com.skubit.satoshidice.provider.accounts;

import android.net.Uri;
import android.provider.BaseColumns;

import com.skubit.satoshidice.provider.KeyProvider;
import com.skubit.satoshidice.provider.accounts.AccountsColumns;

/**
 * Columns for the {@code accounts} table.
 */
public class AccountsColumns implements BaseColumns {
    public static final String TABLE_NAME = "accounts";
    public static final Uri CONTENT_URI = Uri.parse(KeyProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = new String(BaseColumns._ID);

    public static final String NICKNAME = "nickname";

    public static final String SECRET = "secret";

    public static final String DATE = "date";

    public static final String DEPOSITADDRESS = "depositaddress";

    public static final String WITHDRAWADDRESS = "withdrawaddress";

    public static final String ICON = "icon";

    public static final String HASH = "hash";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            NICKNAME,
            SECRET,
            DATE,
            DEPOSITADDRESS,
            WITHDRAWADDRESS,
            ICON,
            HASH
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c == NICKNAME || c.contains("." + NICKNAME)) return true;
            if (c == SECRET || c.contains("." + SECRET)) return true;
            if (c == DATE || c.contains("." + DATE)) return true;
            if (c == DEPOSITADDRESS || c.contains("." + DEPOSITADDRESS)) return true;
            if (c == WITHDRAWADDRESS || c.contains("." + WITHDRAWADDRESS)) return true;
            if (c == ICON || c.contains("." + ICON)) return true;
            if (c == HASH || c.contains("." + HASH)) return true;
        }
        return false;
    }

}
