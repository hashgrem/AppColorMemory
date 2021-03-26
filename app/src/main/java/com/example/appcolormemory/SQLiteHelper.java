package com.example.appcolormemory;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteHelper extends SQLiteOpenHelper{


    public  static String BDD_NAME="Color_Memory_BDD", TABLE_NAME="JOUEURS", ID="id";
    public  static String NAME ="name" ,LOGIN="login", PASSWORD="password", SCORE="Score";

    public SQLiteHelper(@Nullable Context context) {
        super(context, BDD_NAME, null, 1);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        NAME + " TEXT," +
                        LOGIN + " TEXT," +
                        PASSWORD + " TEXT," +
                        SCORE + " INTEGER)";

        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql= "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);

    }

    boolean addJoueur(String name, String login, String password, int score){

        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues data=new ContentValues();
        data.put(NAME, name);
        data.put(LOGIN, login);
        data.put(PASSWORD, password);
        data.put(SCORE, score);


        long result=db.insert(TABLE_NAME, null, data);
        if(result!=-1){
            return true;
        }

        else
            return false;
        }

        boolean connection(String login, String password){

        SQLiteDatabase db =this.getReadableDatabase();
        String sql ="SELECT * FROM JOUEURS WHERE login='" +login+"' AND  password='" +password+"'";
            Cursor cursor=db.rawQuery(sql, null);

            if (cursor.moveToFirst()){
                return true;
            }


            else
                return false;

        }


}
