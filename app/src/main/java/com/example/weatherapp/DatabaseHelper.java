package com.example.weatherapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
import androidx.annotation.Nullable;


    public class DatabaseHelper extends SQLiteOpenHelper {

        private static final String DATABASE_NAME="Users.db";
        public static  final String TABLE_NAME="User";
        public static final String COLUMN_FIRSTNAME="fName";
        public static final String COLUMN_LASTNAME="LName";
        public static final String COLUMN_PHONE="PHONE";
        public static final String COLUMN_EMAIL="EMAIL";
        public static final String COLUMN_UID="UID";

        private SQLiteDatabase database;
        public DatabaseHelper(@Nullable Context context ) {
            super(context, DATABASE_NAME, null, 1);
            database=getWritableDatabase();
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(
                    "CREATE TABLE IF NOT EXISTS " + TABLE_NAME
                            + "(" + COLUMN_FIRSTNAME + " TEXT NOT NULL,"
                            + COLUMN_LASTNAME + " TEXT NOT NULL,"
                            + COLUMN_PHONE + " TEXT NOT NULL,"
                            + COLUMN_EMAIL + " TEXT NOT NULL,"
                            + COLUMN_UID +" INTEGER PRIMARY KEY)");
        }

        public int insert(String fname,String lname,String phone,String email,int uid){
            ContentValues values = new ContentValues();

            values.put(COLUMN_FIRSTNAME, fname);
            values.put(COLUMN_LASTNAME, lname);
            values.put(COLUMN_PHONE, phone);
            values.put(COLUMN_EMAIL, email);
            values.put(COLUMN_UID,uid);

            return (int) database.insert(TABLE_NAME, null, values);

        }
        public int insert(UserData user){
            return insert(user.getfirstn(),user.getlastn(),user.getphoneNum(),user.getEmail(),user.getId());
        }



        public Cursor selectAll(){
            Cursor cursor= database.rawQuery("SELECT * FROM "+ TABLE_NAME, null);

            if (cursor.moveToFirst()){
                return cursor;
            }else{
                return null;
            }
        }

        public Cursor selectByUID(int uid){
            String [] args={uid+""};
            Cursor cursor=database.rawQuery("SELECT * FROM "+ TABLE_NAME+" WHERE "+COLUMN_UID+"=?",args);
            if (cursor != null)
                cursor.moveToFirst();
            if (!cursor.moveToFirst()){
                return null;
            }
            return cursor;
        }


        public int  deleteByUID(int uid){
            String [] args={uid+""};
            return database.delete(TABLE_NAME, COLUMN_UID+" = ?", args);
        }

        /* Every time the Database is updated (or upgraded) */
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }



        public int updateUser(String fname,String lname,String phone,String email,int uid){
            ContentValues values = new ContentValues();

            values.put(COLUMN_FIRSTNAME, fname);
            values.put(COLUMN_LASTNAME, lname);
            values.put(COLUMN_PHONE, phone);
            values.put(COLUMN_EMAIL, email);
            values.put(COLUMN_UID,uid);
            String [] args={uid+""};
            return database.update(TABLE_NAME,values,COLUMN_UID+"=?",args);

        }

    }
}
