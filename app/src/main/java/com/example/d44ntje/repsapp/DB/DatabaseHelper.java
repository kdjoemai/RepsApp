package com.example.d44ntje.repsapp.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by KaMaL on 27-2-2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String LOGTAG = "DATABASE";

    private static final String DATABASE_NAME = "Rep.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "reps";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_EXERCISENAME = "name";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_REP = "REP";
    public static final String COLUMN_WEIGHT = "weight";
    public static final String COLUMN_TIME = "time";

    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_EXERCISENAME + " TEXT," +
//                    COLUMN_DATE + " TEXT," +
//                    COLUMN_WEIGHT + " TEXT," +  //todo find out double  in sql
//                    COLUMN_TIME + " TEXT, " +
                    COLUMN_REP + " INTEGER" +
                    ")";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        Log.i(LOGTAG, "table has been created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

}
