package com.actosoftcommunity.listofitemswithsqliteandcheckboxes;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by martinmelo on 4/24/17.
 */

public class DataBaseManager {

    private DatabaseHelper helper;
    private SQLiteDatabase db;

    public DataBaseManager(Context context, String type){
        helper = new DatabaseHelper(context);
        switch (type)
        {
            case "write":
               db = helper.getWritableDatabase();
                break;
            case "read":
               db =  helper.getReadableDatabase();
        }
    }

    public void close(){
        helper.close();
    }

    //Variables and methods from Users
    public static final String TABLE_USERS_NAME = "users";
    public static final String USERS_ID = "_id";
    public static final String USERS_USER = "user";
    public static final String USERS_PASSWORD = "password";

    public static final String CREATE_TABLE_USERS = "CREATE TABLE "+TABLE_USERS_NAME+
            "("+USERS_ID+" integer primary key autoincrement," +
            USERS_USER+" text not null unique," +
            USERS_PASSWORD+" text not null);";

    public Cursor getAllUsers(){
        String[] columns = new String[]{USERS_ID, USERS_USER, USERS_PASSWORD};
        Cursor users_in_db = db.query(TABLE_USERS_NAME, columns, null, null, null, null, null);
        return users_in_db;
    }

    //Variables and methods from Books;
    public static final String TABLE_BOOKS_NAME = "books";
    public static final String BOOKS_ID = "_id";
    public static final String BOOKS_TITLE = "title";
    public static final String BOOKS_AUTHOR = "author";
    public static final String BOOKS_PRICE = "price";

    public static final String CREATE_TABLE_BOOKS = "CREATE TABLE "+TABLE_BOOKS_NAME+
            "("+BOOKS_ID+" integer primary key autoincrement," +
            BOOKS_TITLE+" text not null," +
            BOOKS_AUTHOR+" text not null," +
            BOOKS_PRICE+" real not null);";

    //Variables and methods from BookUser;
    public static final String TABLE_BOOKUSER_NAME = "book_user";
    public static final String BU_ID = "_id";
    public static final String BU_USER_ID = "user_id";
    public static final String BU_BOOK_ID = "book_id";

    public static final String CREATE_TABLE_BOOKUSER = "CREATE TABLE "+TABLE_BOOKUSER_NAME+
            "("+BU_ID+" integer primary key autoincrement," +
            BU_USER_ID+" integer," +
            "FOREIGN KEY ("+BU_USER_ID+") REFERENCES "+TABLE_USERS_NAME+"("+USERS_ID+")," +
            BU_BOOK_ID+" integer," +
            "FOREIGN KEY ("+BU_BOOK_ID+") REFERENCES "+TABLE_BOOKS_NAME+"("+BOOKS_ID+"));";

    //Variables and methods from BuyOder;
    public static final String TABLE_BUYORDER_NAME = "buyorders";
    public static final String BUYORDER_ID = "_id";
    public static final String BUYORDER_USER_ID = "user_id";
    public static final String BUYORDER_NUMBERBOOKS = "number_books";
    public static final String BUYORDER_TOTAL = "total";

    public static final String CREATE_TABLE_BUYORDER = "CREATE TABLE "+TABLE_BUYORDER_NAME+
            "("+BUYORDER_ID+" integer primary key autoincrement," +
            BUYORDER_USER_ID+" integer," +
            "FOREIGN KEY ("+BUYORDER_USER_ID+") REFERENCES "+TABLE_USERS_NAME+"("+USERS_ID+")," +
            BUYORDER_NUMBERBOOKS+" integer," +
            BUYORDER_TOTAL+" real);";
}
