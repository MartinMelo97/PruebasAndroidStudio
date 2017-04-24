package com.example.actosoft.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

/**
 * Created by tecmartinmelo on 4/23/17.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME="lbreria.sqlite";
    private static final int DB_SCHEME_VERSION = 1;

    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null, DB_SCHEME_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DataBaseManager.CREATE_TABLE_USER);
        sqLiteDatabase.execSQL(DataBaseManager.CREATE_TABLE_BOOKS);
        sqLiteDatabase.insert(DataBaseManager.TABLE_NAME, null, generarContentValuesUsers("MartinMelo", "123456"));
        sqLiteDatabase.insert(DataBaseManager.TABLE_NAME, null, generarContentValuesUsers("Admin", "123456"));
        sqLiteDatabase.insert(DataBaseManager.TABLE_NAME_BOOKS, null, generarContentValuesBooks("Apps HTML 5 para Móviles","De Lucio", 399));
        sqLiteDatabase.insert(DataBaseManager.TABLE_NAME_BOOKS, null, generarContentValuesBooks("El gran Libro de Android","Tomás", 597));
        sqLiteDatabase.insert(DataBaseManager.TABLE_NAME_BOOKS, null, generarContentValuesBooks("13 Reasons Why","Selena Gómez", 1432));
        sqLiteDatabase.insert(DataBaseManager.TABLE_NAME_BOOKS, null, generarContentValuesBooks("Quijote de la Mancha","Miguel de Saavedra", 239));
        sqLiteDatabase.insert(DataBaseManager.TABLE_NAME_BOOKS, null, generarContentValuesBooks("Ética para Amador","El Robert", 199));

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //sqLiteDatabase.execSQL("DROP TABLE users");
        //sqLiteDatabase.execSQL("DROP TABLE books");
       // sqLiteDatabase.execSQL(DataBaseManager.CREATE_TABLE_USER);
        //sqLiteDatabase.execSQL(DataBaseManager.CREATE_TABLE_BOOKS);
    }
    public ContentValues generarContentValuesUsers(String nombre, String password){
        ContentValues values = new ContentValues();
        values.put(DataBaseManager.US_USER, nombre);
        values.put(DataBaseManager.US_PASS, password);
        return values;
    }

    public ContentValues generarContentValuesBooks(String title, String author, float price){
        ContentValues values = new ContentValues();
        values.put(DataBaseManager.BK_TITLE, title);
        values.put(DataBaseManager.BK_AUTOR, author);
        values.put(DataBaseManager.BK_PRICE, price);
        return values;
    }

}
