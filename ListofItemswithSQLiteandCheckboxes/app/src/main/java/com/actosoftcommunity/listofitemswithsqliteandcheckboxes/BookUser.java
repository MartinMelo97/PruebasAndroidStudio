package com.actosoftcommunity.listofitemswithsqliteandcheckboxes;

/**
 * Created by martinmelo on 4/24/17.
 */

public class BookUser {
    public int _ID;
    public int User_ID;
    public int Book_ID;

    public BookUser(int _ID, int user_ID, int book_ID) {
        this._ID = _ID;
        User_ID = user_ID;
        Book_ID = book_ID;
    }

    public int get_ID() {
        return _ID;
    }

    public void set_ID(int _ID) {
        this._ID = _ID;
    }

    public int getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(int user_ID) {
        User_ID = user_ID;
    }

    public int getBook_ID() {
        return Book_ID;
    }

    public void setBook_ID(int book_ID) {
        Book_ID = book_ID;
    }
}
