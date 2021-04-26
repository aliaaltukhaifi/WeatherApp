package com.example.weatherapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class SQLite extends SQLiteOpenHelper {
    private static final String dbname="project";
    private static  final int version = 1;


    public SQLite(Context myContext)
    {
        super(myContext,dbname,null,1);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "Create table users(userid int primary key,firstname varchar(30),lastname varchar(30),email varchar(30),phonenumber varchar(30))";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void insert(SQLiteDatabase db,UserData u)
    {
        String url = "Insert into users values("+u.getId()+","+u.getfirstn()+","+u.getlastn()+","+u.getEmail()+","+u.getphoneNum()+")";
        db.execSQL(url);
    }
    public void updateData(SQLiteDatabase db,String first_name,String updated_name,int id)
    {
        String url = "update from users set firstname = "+updated_name+"";
        db.execSQL(url);
    }
    public void remove(SQLiteDatabase db, int id)
    {
        String url = "update from users where users.userid="+id;
        db.execSQL(url);

    }
}
