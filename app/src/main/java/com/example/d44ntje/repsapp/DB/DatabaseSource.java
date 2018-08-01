package com.example.d44ntje.repsapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.d44ntje.repsapp.DB.DatabaseHelper;
import com.example.d44ntje.repsapp.SportItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KaMaL on 27-2-2018.
 */

public class DatabaseSource {

    Context mcontext;
    SQLiteDatabase database;
    DatabaseHelper dbhelper;


    private static final String LOGTAG = "DATABASE SOURCE";

    private static final String[] allColums = {
            DatabaseHelper.COLUMN_ID,
            DatabaseHelper.COLUMN_EXERCISENAME,
//            DatabaseHelper.COLUMN_DATE,
//            DatabaseHelper.COLUM_WEIGHT
//            DatabaseHelper.COLUMN_TIME,
            DatabaseHelper.COLUMN_REP
    };


    public DatabaseSource(Context context) {

        mcontext = context;
        dbhelper = new DatabaseHelper(context);
    }

    public void open() {
        Log.i(LOGTAG, "Database opened");
        database = dbhelper.getWritableDatabase();
    }

    public void close() {
        Log.i(LOGTAG, "Database closed");
        dbhelper.close();
    }

    public SportItem createRep(SportItem sportItem) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_EXERCISENAME, sportItem.getName());
        values.put(dbhelper.COLUMN_REP, sportItem.getRep1());
        Long insertid = database.insert(dbhelper.getDatabaseName(), null, values);
        sportItem.setId(insertid);
        return sportItem;
    }

    public List<SportItem> getallReps() {
        List<SportItem> items = new ArrayList<SportItem>();

        Cursor cursor = database.query(dbhelper.TABLE_NAME, allColums,
                null, null, null, null, null);

        Log.i(LOGTAG, "Returned " + cursor.getCount() + " rows");
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                SportItem sportItem = new SportItem();

                sportItem.setId(cursor.getLong(cursor.getColumnIndex(dbhelper.COLUMN_ID)));
                sportItem.setName(cursor.getString(cursor.getColumnIndex(dbhelper.COLUMN_EXERCISENAME)));
                sportItem.setRep1(cursor.getInt(cursor.getColumnIndex(dbhelper.COLUMN_REP)));
//            sportItem.setImage(cursor.getString(cursor.getColumnIndex(ToursDBOpenHelper.COLUMN_IMAGE)));
//            sportItem.setPrice(cursor.getDouble(cursor.getColumnIndex(ToursDBOpenHelper.COLUMN_PRICE)));
                items.add(sportItem);
            }
        }
        return items;

    }
}
