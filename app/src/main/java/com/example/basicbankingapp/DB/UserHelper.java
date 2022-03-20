package com.example.basicbankingapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.basicbankingapp.DB.UserContract.UserEntry;
import com.example.basicbankingapp.Data.User;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    private static final String DATABASE_NAME = "User.db";

    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        db.execSQL(SQL_CREATE_USER_TABLE);

        db.execSQL("insert into " + TABLE_NAME + " values(5660,'Sahil Bohra', 'sahilbohra@ebanking.com','7954','7875621238', 600)");
        db.execSQL("insert into " + TABLE_NAME + " values(5856,'Dipankar Ghosh', 'dghosh@ebanking.com','1958','89956787562', 200)");
        db.execSQL("insert into " + TABLE_NAME + " values(9595,'Aryan Kumar', 'aryankumar@ebanking.com','9596','6778756896', 544)");
        db.execSQL("insert into " + TABLE_NAME + " values(1958,'Rashi Panchal', 'rashipanchal@ebanking.com','6552','6978756238', 600)");
        db.execSQL("insert into " + TABLE_NAME + " values(9510,'Ved Rathore', 'vedrathore@ebanking.com','2369','8875628962', 800)");
        db.execSQL("insert into " + TABLE_NAME + " values(8595,'Dipali Chauhan', 'Dipalichauhan@ebanking.com','95785','8787562238', 800)");
        db.execSQL("insert into " + TABLE_NAME + " values(9598,'Pravin Agarwal', 'pravinagrawal@ebanking.com','9507','5878756215', 900)");
        db.execSQL("insert into " + TABLE_NAME + " values(7895,'Riya Jain', 'riyajainv','4522','6775621539', 780)");
        db.execSQL("insert into " + TABLE_NAME + " values(9562,'Riyanchal Sharma', 'rsharma@ebanking.com','6952','6975625238', 1500)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}