package com.skubit.satoshidice.provider;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import com.skubit.satoshidice.BuildConfig;
import com.skubit.satoshidice.provider.accounts.AccountsColumns;

public class KeySQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String TAG = KeySQLiteOpenHelper.class.getSimpleName();

    public static final String DATABASE_FILE_NAME = "accounts.db";
    private static final int DATABASE_VERSION = 1;
    private static KeySQLiteOpenHelper sInstance;
    private final Context mContext;
    private final KeySQLiteOpenHelperCallbacks mOpenHelperCallbacks;

    // @formatter:off
    private static final String SQL_CREATE_TABLE_ACCOUNTS = "CREATE TABLE IF NOT EXISTS "
            + AccountsColumns.TABLE_NAME + " ( "
            + AccountsColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + AccountsColumns.NICKNAME + " TEXT, "
            + AccountsColumns.SECRET + " TEXT, "
            + AccountsColumns.DATE + " INTEGER, "
            + AccountsColumns.DEPOSITADDRESS + " TEXT, "
            + AccountsColumns.WITHDRAWADDRESS + " TEXT, "
            + AccountsColumns.ICON + " TEXT, "
            + AccountsColumns.HASH + " TEXT "
            + " );";

    // @formatter:on

    public static KeySQLiteOpenHelper getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = newInstance(context.getApplicationContext());
        }
        return sInstance;
    }

    private static KeySQLiteOpenHelper newInstance(Context context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            return newInstancePreHoneycomb(context);
        }
        return newInstancePostHoneycomb(context);
    }


    /*
     * Pre Honeycomb.
     */

    private static KeySQLiteOpenHelper newInstancePreHoneycomb(Context context) {
        return new KeySQLiteOpenHelper(context, DATABASE_FILE_NAME, null, DATABASE_VERSION);
    }

    private KeySQLiteOpenHelper(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
        mOpenHelperCallbacks = new KeySQLiteOpenHelperCallbacks();
    }


    /*
     * Post Honeycomb.
     */

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private static KeySQLiteOpenHelper newInstancePostHoneycomb(Context context) {
        return new KeySQLiteOpenHelper(context, DATABASE_FILE_NAME, null, DATABASE_VERSION, new DefaultDatabaseErrorHandler());
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private KeySQLiteOpenHelper(Context context, String name, CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
        mContext = context;
        mOpenHelperCallbacks = new KeySQLiteOpenHelperCallbacks();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        if (BuildConfig.DEBUG) Log.d(TAG, "onCreate");
        mOpenHelperCallbacks.onPreCreate(mContext, db);
        db.execSQL(SQL_CREATE_TABLE_ACCOUNTS);
        mOpenHelperCallbacks.onPostCreate(mContext, db);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        mOpenHelperCallbacks.onOpen(mContext, db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        mOpenHelperCallbacks.onUpgrade(mContext, db, oldVersion, newVersion);
    }
}
