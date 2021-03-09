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

    //Requetes insertion des champs entrés par l'utilisateur dans la table users.

    public String addFirstName(String firstNameUser){

        c = db.rawQuery("INSERT INTO users (firstName) values(?)", new String[]{firstNameUser});
        c.moveToFirst();
        return c.getString(1); //colonne dans la bd ?
    }

    public String addLastName(String lastNameUser){
        c = db.rawQuery("INSERT INTO users (lastName) values(?)", new String[]{lastNameUser});
        c.moveToFirst();
        return c.getString(2);
    }

    public String addEmail(String emailUser){
        c = db.rawQuery("INSERT INTO users (email) values(?)", new String[]{emailUser});
        c.moveToFirst();
        return c.getString(5);
    }

    public String addPassword(String passwordUser){
        c = db.rawQuery("INSERT INTO users (password) values (?)", new String[]{passwordUser});
        c.moveToFirst();
        return c.getString(6);
    }

    public String addSexe(String sexeUser){             // --------------------- Radio bouton donc pas un String ------------------------//
        c = db.rawQuery("INSERT INTO users (sexe) values (?)", new String[]{sexeUser});
        c.moveToFirst();
        return c.getString(3);
    }

    public String addBirthDate(String birthDateUser){   //pareil que pour le sexe
        c = db.rawQuery("INSERT INTO users (birthDate) values (?)", new String[]{birthDateUser});
        c.moveToFirst();
        return c.getString(4);
    }
}

