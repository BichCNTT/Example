package com.example.ominext.mediaplayerapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ominext on 7/25/2017.
 */

public class MySQLiteHelper extends SQLiteOpenHelper {
    //Tên database, tên bảng, version, các cột
    private static final String DATABASE_NAME = "ListMediaPlayer.db";
    private static final String TABLE_NAME = "DetailMediaPlayer";
    private static final int VERSION = 1;
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_TIME = "time";
    private static final String COLUMN_URL = "url";
    private static final String TABLE_CREATE = "create table " + TABLE_NAME + "(" + COLUMN_ID + " primary key autoincrement, " +
            COLUMN_NAME + " nvarchar, " + COLUMN_TIME + " nvarchar, " + COLUMN_URL + " nvarchar)";
    SQLiteDatabase database;

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        database.execSQL(DATABASE_NAME);
        this.database = sqLiteDatabase;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "drop table if  exists " + TABLE_NAME;
        database.execSQL(query);
        this.database = sqLiteDatabase;
    }

    public int getCount() {
        String query = "select * from " + TABLE_NAME;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        cursor.close();
        return cursor.getCount();
    }

    public List<MyData> getAllSong() {
        List<MyData> myDataList = new ArrayList<>();
        String query = "select * from " + TABLE_NAME;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                MyData myData = new MyData();
                myData.setName(cursor.getString(1));
                myData.setTime(cursor.getString(2));
                myData.setUrl(cursor.getString(3));
                myDataList.add(myData);
            } while (cursor.moveToNext());
        }
        cursor.close();
        sqLiteDatabase.close();
        return myDataList;
    }
}
