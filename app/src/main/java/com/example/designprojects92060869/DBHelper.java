package com.example.designprojects92060869;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "Login.db";

    public DBHelper(Context context) {
        super(context, DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        // Create the table with columns
        MyDB.execSQL("CREATE TABLE IF NOT EXISTS profile (Name TEXT, Address TEXT, PhoneNumber TEXT)");
        MyDB.execSQL("CREATE TABLE IF NOT EXISTS users (signupName TEXT, signupUsername TEXT PRIMARY KEY, " + "signupPassword TEXT, signupRePassword TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        // Drop the existing users table
        MyDB.execSQL("DROP TABLE IF EXISTS users");
        MyDB.execSQL("DROP TABLE IF EXISTS profile");
        onCreate(MyDB);
    }

    public boolean insertData(String signupName, String signupUsername, String signupPassword, String signupRePassword) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("signupName", signupName);
        contentValues.put("signupUsername", signupUsername);
        contentValues.put("signupPassword", signupPassword);
        contentValues.put("signupRePassword", signupRePassword);

        // Insert the user data into the users table
        long result = MyDB.insert("users", null, contentValues);
        return result != -1;
    }

    public boolean updateProfile(String Name, String Address, String PhoneNumber) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", Name);
        contentValues.put("Address", Address);
        contentValues.put("PhoneNumber", PhoneNumber);

        // Update the profile data in the profile table
        long result = MyDB.insert("profile", null, contentValues);
        return result != -1;
    }

    //delete
    public Integer deleteProfile(String Name, String Address, String PhoneNumber){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("profile", "Name = ? AND Address = ? AND PhoneNumber = ?", new String[]{Name, Address, PhoneNumber});
    }

    public boolean checkUsernameExists(String signupUsername) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("SELECT * FROM users WHERE signupUsername = ?",
                new String[]{signupUsername});
        // Check if a user with the given username exists in the users table
        return cursor.getCount() > 0;
    }

    public boolean checkNameAndUsernameExists(String signupName, String signupUsername) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("SELECT * FROM users WHERE signupName = ? AND signupUsername = ?",
                new String[]{signupName, signupUsername});
        // Check if a user with the given name and username exists in the users table
        return cursor.getCount() > 0;
    }

    public boolean checkUserExists(String signupUsername, String signupPassword) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("SELECT * FROM users WHERE signupUsername = ? AND signupPassword = ?",
                new String[]{signupUsername, signupPassword});
        // Check if a user with the given username and password exists in the users table
        return cursor.getCount() > 0;
    }

    public String getUserName(String signupUsername) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("SELECT signupName FROM users WHERE signupUsername = ?",
                new String[]{signupUsername});
        if (cursor.moveToFirst()) {
            // Retrieve the username from the cursor
            return cursor.getString(0);
        } else {
            return "";
        }
    }
}
