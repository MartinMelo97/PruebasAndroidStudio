package com.example.actosoft.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

public class DataBaseManager {

    public static final String TABLE_NAME = "usuarios";
    public static final String US_ID = "_id";
    public static final String US_USER = "user";
    public static final String US_PASS = "password";

    public static final String CREATE_TABLE_USER = "CREATE TABLE "+TABLE_NAME+
            "("+US_ID+" integer primary key autoincrement,"
            +US_USER+" text not null,"
            +US_PASS+" text not null);";

    public static final String TABLE_NAME_BOOKS = "books";
    public static final String BK_ID = "_id";
    public static final String BK_TITLE = "title";
    public static final String BK_AUTOR = "author";
    public static final String BK_PRICE = "price";

    public static final String CREATE_TABLE_BOOKS = "CREATE TABLE "+TABLE_NAME_BOOKS+
            "("+BK_ID+" integer primary key autoincrement," +
            BK_TITLE+" text not null," +
            BK_AUTOR+" text not null,"+
            BK_PRICE+" integer not null)";


    private DataBaseHelper helper;
    private SQLiteDatabase db;


    public DataBaseManager(Context context, String type)
    {
        helper = new DataBaseHelper(context);
        switch (type)
        {
            case "write":
                db = helper.getWritableDatabase();
                break;
            case "read":
                db = helper.getReadableDatabase();
                break;
        }

    }

    public Cursor lookingForUser()
    {
        Log.d("MainActivity", "Si entrouta madr");
        String[] columns = new String[]{
                US_ID, US_USER, US_PASS
        };

        //query(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBY)
        Cursor registers = db.query(TABLE_NAME, columns, null, null, null, null, null);
        if(registers == null)
        {
            Log.d("MainActivity", "Esta vacio");
        }
        else
        {
            Log.d("MainActivity", "No esta vacio" + registers.getCount());
        }
        return registers;
    }

    public Cursor lookingForLoggedUser(int id)
    {
        String[] columns = new String[]{
                US_USER
        };

        String where = "_id=?";
        String whereArgs[] = new String[]{Integer.toString(id)};

        Cursor userLogged = db.query(TABLE_NAME, columns, where, whereArgs, null, null, null);
        return userLogged;
    }

    public Cursor lookingForAllBooks(){
        String[] columns_books = new String[]{
                BK_ID, BK_TITLE,BK_AUTOR, BK_PRICE
        };

        Cursor allBooks = db.query(TABLE_NAME_BOOKS, columns_books, null, null, null, null, null);
        return allBooks;
    }

}
