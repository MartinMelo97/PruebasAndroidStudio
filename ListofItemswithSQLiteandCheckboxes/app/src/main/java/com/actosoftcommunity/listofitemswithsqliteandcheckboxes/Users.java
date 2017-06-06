package com.actosoftcommunity.listofitemswithsqliteandcheckboxes;

/**
 * Created by martinmelo on 4/24/17.
 */

public class Users {
    private int _ID;
    private String User;
    private String Pass;

    public Users(int ID, String user, String pass) {
        this._ID = ID;
        User = user;
        Pass = pass;
    }

    public int getID() {
        return _ID;
    }

    public void setID(int ID) {
        this._ID = ID;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }
}
