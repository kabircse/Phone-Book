package com.example.root.phone_book;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by root on 1/1/17.
 */

public class DB extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "phone_book";
    private static final String TABLE_NAME = "contacts";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String CONTACT_NUMBER = "contact_number";
    private static final String CONTACT_TYPE = "contact_type";
    private static final String NOTE = "note";

    DB(Context C){
        super(C, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL = "CREATE TABLE "+TABLE_NAME+" ("+ID+" INTEGER PRIMARY KEY, "+NAME+" TEXT,"+CONTACT_NUMBER+" TEXT,"+CONTACT_TYPE+" TEXT,"+NOTE+" TEXT)";
        db.execSQL(SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        // Creating tables again
        onCreate(db);
    }

    public void insert_data(PBFunctions fn){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(NAME, fn.getName());
        cv.put(CONTACT_NUMBER, fn.getContact_number());
        cv.put(CONTACT_TYPE, fn.getContact_type());
        cv.put(NOTE, fn.getNote());
        db.insert(TABLE_NAME, null, cv);
    }

    String[] select_data(){
        SQLiteDatabase db = this.getReadableDatabase();
        String q = "SELECT * FROM "+TABLE_NAME;
        Cursor c = db.rawQuery(q, null);
        String[]  data = new String[c.getCount()];
        c.moveToFirst();
        if(c.moveToFirst()){
            int i = 0;
            while(c.moveToNext()){
                data[i++] = c.getString(c.getColumnIndex(NAME+" ")) + c.getString(c.getColumnIndex(CONTACT_NUMBER+" ")) + c.getString(c.getColumnIndex(CONTACT_TYPE+" ")) + c.getString(c.getColumnIndex(NOTE));
            }
        }
        return data;
    }


}
