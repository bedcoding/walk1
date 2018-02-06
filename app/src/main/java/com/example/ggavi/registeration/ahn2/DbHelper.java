package com.example.ggavi.registeration.ahn2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "mosquitoEntry.db";
    private static DbHelper sInstance;

    public static final String TABLE_NAME_ENTRIES = "mosquitoEntry";
    // Keys for table
    public static final String KEY_ROWID = "_id";
    public static final String KEY_GRADE = "grade";
    public static final String KEY_DEFENCE_ACTIVITY = "defence_activity";
    public static final String KEY_AGGRESSIVE_ACTIVITY = "aggressive_activity";
    public static final String KEY_ORGANIZATION_ACTIVITY = "organization_activity";


    //Database creation SQL statement
    public static final String CREATE_TABLE_ENTRIES = "CREATE TABLE IF NOT EXISTS "
            + TABLE_NAME_ENTRIES + "("
            + KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + KEY_GRADE + " TEXT, "
            + KEY_DEFENCE_ACTIVITY + " TEXT, "
            + KEY_AGGRESSIVE_ACTIVITY + " TEXT, "
            + KEY_ORGANIZATION_ACTIVITY + " TEXT " + ");";

    private DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static DbHelper getsInstance(Context context) {

        if (sInstance == null) {
            sInstance = new DbHelper(context.getApplicationContext());
        }
        return sInstance;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ENTRIES);
        fillData(db);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DbHelper.class.getName(),
                "Upgrading database from version " + oldVersion + "to"
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME_ENTRIES);
        onCreate(db);
    }
    public void fillData(SQLiteDatabase database) {

        for (int i = 0; i < Data.grade.length; i++) {
            ContentValues values = new ContentValues();
            values.put(KEY_GRADE, Data.grade[i]);
            values.put(KEY_DEFENCE_ACTIVITY, Data.defence_activity[i]);
            values.put(KEY_AGGRESSIVE_ACTIVITY, Data.aggressive_activity[i]);
            values.put(KEY_ORGANIZATION_ACTIVITY, Data.organization_activity[i]);
            database.insert(TABLE_NAME_ENTRIES, null, values);
        }
    }

    synchronized mosquitoEntry fetchEntryByIndex(long rowIndex) {
        mosquitoEntry exerciseMosquitoEntry = new mosquitoEntry();
        Cursor cursor;
        SQLiteDatabase database = getReadableDatabase();

        cursor = database.query(TABLE_NAME_ENTRIES, null,
                KEY_ROWID + " = " + rowIndex, null, null, null, null);
        cursor.moveToFirst();
        exerciseMosquitoEntry.setmId(cursor.getLong(0));
        exerciseMosquitoEntry.setmGrade(cursor.getString(1));
        exerciseMosquitoEntry.setDefence_activity(cursor.getString(2));
        exerciseMosquitoEntry.setAggressive_activity(cursor.getString(3));
        exerciseMosquitoEntry.setOrganization_activity(cursor.getString(4));

        cursor.close();
        return exerciseMosquitoEntry;
    }
}

