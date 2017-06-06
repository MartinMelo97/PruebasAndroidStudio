package com.actosoftcommunity.listofitemswithsqliteandcheckboxes;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by martinmelo on 4/24/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "library.sqlite";

    private static final int DB_SCHEME_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_SCHEME_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DataBaseManager.CREATE_TABLE_USERS);
        sqLiteDatabase.execSQL(DataBaseManager.CREATE_TABLE_BOOKS);
        sqLiteDatabase.execSQL(DataBaseManager.CREATE_TABLE_BOOKUSER);
        sqLiteDatabase.execSQL(DataBaseManager.CREATE_TABLE_BUYORDER);
        GeneratingUserData(sqLiteDatabase);
        GeneratingBookData(sqLiteDatabase);
        GeneratingBookUserData(sqLiteDatabase);
        GeneratingBuyOrderData(sqLiteDatabase);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

   public ContentValues staticUserData(String username, String password)
   {
       ContentValues user_data = new ContentValues();
       user_data.put(DataBaseManager.USERS_USER, username);
       user_data.put(DataBaseManager.USERS_PASSWORD, password);
       return user_data;
   }

   public ContentValues staticBookData(String title, String author, double price)
   {
       ContentValues book_data = new ContentValues();
       book_data.put(DataBaseManager.BOOKS_TITLE, title);
       book_data.put(DataBaseManager.BOOKS_AUTHOR, author);
       book_data.put(DataBaseManager.BOOKS_PRICE, price);
       return book_data;
   }

   public ContentValues staticUserBookData(int user_id, int book_id)
   {
       ContentValues book_user = new ContentValues();
       book_user.put(DataBaseManager.BU_USER_ID, user_id);
       book_user.put(DataBaseManager.BU_BOOK_ID, book_id);
       return book_user;
   }

   public ContentValues staticBuyOrderData(int user_id, int count, double total)
   {
       ContentValues book_user = new ContentValues();
       book_user.put(DataBaseManager.BUYORDER_USER_ID, user_id);
       book_user.put(DataBaseManager.BUYORDER_NUMBERBOOKS, count);
       book_user.put(DataBaseManager.BUYORDER_TOTAL, total);
       return book_user;

   }

   private void GeneratingUserData(SQLiteDatabase db)
   {
       db.insert(DataBaseManager.TABLE_USERS_NAME, null, staticUserData("MartinMelo", "cbtis2014$"));
       db.insert(DataBaseManager.TABLE_USERS_NAME, null, staticUserData("DavidZavala", "frepo"));
       db.insert(DataBaseManager.TABLE_USERS_NAME, null, staticUserData("SaulSandoval", "Unity$"));
       db.insert(DataBaseManager.TABLE_USERS_NAME, null, staticUserData("KevinJames", "endlezzgaming"));
       db.insert(DataBaseManager.TABLE_USERS_NAME, null, staticUserData("HectorBliss", "poderoso77"));
   }

    private void GeneratingBookData(SQLiteDatabase db)
    {
        db.insert(DataBaseManager.TABLE_BOOKS_NAME, null, staticBookData("HTMl5", "Juan de la Barrera", 540));
        db.insert(DataBaseManager.TABLE_BOOKS_NAME, null, staticBookData("El Mio Cid", "Anonimo", 323.12));
        db.insert(DataBaseManager.TABLE_BOOKS_NAME, null, staticBookData("Django By Example", "Hector F. Campos", 1340));
        db.insert(DataBaseManager.TABLE_BOOKS_NAME, null, staticBookData("WWE Stories", "John Cena", 1234.56));
        db.insert(DataBaseManager.TABLE_BOOKS_NAME, null, staticBookData("Despacito", "Luis Fonsi", 240));
    }

    private void GeneratingBookUserData(SQLiteDatabase db)
    {
        db.insert(DataBaseManager.CREATE_TABLE_BOOKUSER, null, staticUserBookData(1, 1));
        db.insert(DataBaseManager.CREATE_TABLE_BOOKUSER, null, staticUserBookData(1, 3));
        db.insert(DataBaseManager.CREATE_TABLE_BOOKUSER, null, staticUserBookData(1, 4));
    }

    private void GeneratingBuyOrderData(SQLiteDatabase db)
    {
        db.insert(DataBaseManager.TABLE_BUYORDER_NAME, null, staticBuyOrderData(1, 3, 3114.56));
    }

}
