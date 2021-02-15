package com.example.appcolormemory;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DatabaseOpenHelper extends SQLiteAssetHelper {

    private static final String db = "phpmyadminappcolormemory.sql";

    public DatabaseOpenHelper(Context context) {
        super(context, db, null, 1);
    }
}
