package fr.pevere.trackmyfoodtwo.controller;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    // Table Name
    public static final String TABLE_NAME = "MEALS";

    // Table columns
    public static final String _ID = "_id";
    public static final String WHAT = "what";
    public static final String TIMEMEAL = "timemeal";
    public static final String HOWMUCH = "howmuch";

    // Database Information
    static final String DB_NAME = "JOURNALDEV_MEALS.DB";

    // database version
    static final int DB_VERSION = 1;

    // Creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + _ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + WHAT + " TEXT NOT NULL, " + HOWMUCH + " TEXT NOT NULL, " + TIMEMEAL + " TEXT);";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
