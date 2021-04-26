package com.example.weatherapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class db {

    // (view)
    public Cursor ViewEmployees() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor dax = db.rawQuery("SELECT * FROM " + UserData, null);
        return dax;

    }


    //(delete)
    public Integer DeleteEmployees(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(UserData, "ID = ?", new String[]{id});

    }

    private SQLiteDatabase getWritableDatabase() {
    }


    /* Every time the dB is updated (or upgraded) */

    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {

    }
}
