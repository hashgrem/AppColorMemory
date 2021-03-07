package com.example.appcolormemory;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;

public class DatabaseAccess {

    private DatabaseOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c = null;

    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    public static DatabaseAccess getInstance(Context context){
        if(instance==null){
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    public void open(){
        this.db=openHelper.getWritableDatabase();
    }

    public void close(){
        if(db!=null){
            this.db.close();
        }
    }



    //requetes ici.

    public String addFirstName(String firstNameUser){

        c = db.rawQuery("INSERT INTO users (firstName) values(?)", new String[]{firstNameUser});
        c.moveToFirst();
        return c.getString(0);
    }
}

