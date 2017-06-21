package com.castrodev.persistencetalk.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import com.castrodev.persistencetalk.model.Book;
import com.castrodev.persistencetalk.model.Loan;
import com.castrodev.persistencetalk.model.User;

/**
 * Created by rodrigocastro on 20/06/17.
 */

public class LoanDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    static final String DATABASE_NAME = "openhelper.db";
    private static final String TAG = "LoanDbHelper";

    private static LoanDbHelper sInstance;

    public static synchronized LoanDbHelper getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new LoanDbHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    private LoanDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        final String SQL_CREATE_BOOK_TABLE = "CREATE TABLE " + BookEntry.TABLE_NAME + " (" +
                BookEntry._ID + " INTEGER PRIMARY KEY," +
                BookEntry.COLUMN_TITLE + " TEXT NOT NULL);";

        final String SQL_CREATE_USER_TABLE = "CREATE TABLE " + UserEntry.TABLE_NAME + " (" +
                UserEntry._ID + " INTEGER PRIMARY KEY, " +
                UserEntry.COLUMN_NAME + " TEXT NOT NULL, " +
                UserEntry.COLUMN_LAST_NAME + " TEXT NOT NULL, " +
                UserEntry.COLUMN_AGE + " INTEGER NOT NULL);";


        final String SQL_CREATE_LOAN_TABLE = "CREATE TABLE " + LoanEntry.TABLE_NAME + " (" +
                LoanEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                LoanEntry.COLUMN_BOOK_KEY + " INTEGER NOT NULL, " +
                LoanEntry.COLUMN_USER_KEY + " INTEGER NOT NULL, " +
                LoanEntry.COLUMN_START_TIME + " INTEGER NOT NULL, " +
                LoanEntry.COLUMN_END_TIME + " INTEGER, " +

                " FOREIGN KEY (" + LoanEntry.COLUMN_BOOK_KEY + ") REFERENCES " +
                BookEntry.TABLE_NAME + " (" + BookEntry._ID + "), " +

                " FOREIGN KEY (" + LoanEntry.COLUMN_BOOK_KEY + ") REFERENCES " +
                BookEntry.TABLE_NAME + " (" + BookEntry._ID + "), " +

                " UNIQUE (" +
                LoanEntry.COLUMN_START_TIME + ", " +
                LoanEntry.COLUMN_BOOK_KEY + ", " +
                LoanEntry.COLUMN_USER_KEY +
                ") ON CONFLICT REPLACE);";

        sqLiteDatabase.execSQL(SQL_CREATE_BOOK_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_USER_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_LOAN_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + BookEntry.TABLE_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + LoanEntry.TABLE_NAME);
            onCreate(db);
        }

    }

    public void addUser(User user) {

        SQLiteDatabase db = getWritableDatabase();

        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put(UserEntry._ID, user.getId());
            values.put(UserEntry.COLUMN_NAME, user.getName());
            values.put(UserEntry.COLUMN_LAST_NAME, user.getLastname());
            values.put(UserEntry.COLUMN_AGE, user.getAge());


            db.insertOrThrow(UserEntry.TABLE_NAME, null, values);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to add user to database");
        } finally {
            db.endTransaction();
        }

    }

    public void addBook(Book book) {
        SQLiteDatabase db = getWritableDatabase();

        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put(BookEntry._ID, book.getId());
            values.put(BookEntry.COLUMN_TITLE, book.getTitle());

            db.insertOrThrow(BookEntry.TABLE_NAME, null, values);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to add book to database");
        } finally {
            db.endTransaction();
        }
    }

    public void addLoan(Loan loan) {
        SQLiteDatabase db = getWritableDatabase();

        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put(LoanEntry._ID, loan.getId());
            values.put(LoanEntry.COLUMN_START_TIME, loan.getStartTime().getTime());
//            values.put(LoanEntry.COLUMN_END_TIME, loan.getEndTime().getTime());
            values.put(LoanEntry.COLUMN_BOOK_KEY, loan.getBookId());
            values.put(LoanEntry.COLUMN_USER_KEY, loan.getUserId());

            db.insertOrThrow(LoanEntry.TABLE_NAME, null, values);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to add loan to database");
        } finally {
            db.endTransaction();
        }
    }

    private class BookEntry implements BaseColumns {
        static final String TABLE_NAME = "book";
        static final String COLUMN_TITLE = "title";
    }

    private class UserEntry implements BaseColumns {
        static final String TABLE_NAME = "user";
        static final String COLUMN_NAME = "name";
        static final String COLUMN_LAST_NAME = "last_name";
        static final String COLUMN_AGE = "age";
    }

    private class LoanEntry implements BaseColumns {
        static final String TABLE_NAME = "loan";
        static final String COLUMN_BOOK_KEY = "book_id";
        static final String COLUMN_USER_KEY = "user_id";
        static final String COLUMN_START_TIME = "start_time";
        static final String COLUMN_END_TIME = "end_time";
    }


}
