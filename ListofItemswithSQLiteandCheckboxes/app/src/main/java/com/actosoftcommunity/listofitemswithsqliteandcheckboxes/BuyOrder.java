package com.actosoftcommunity.listofitemswithsqliteandcheckboxes;

/**
 * Created by martinmelo on 4/24/17.
 */

public class BuyOrder {
    private int _ID;
    private int UserID;
    private int NumberOfBooks;
    private double Total;

    public BuyOrder(int _ID, int userID, int numberOfBooks, double total) {
        this._ID = _ID;
        UserID = userID;
        NumberOfBooks = numberOfBooks;
        Total = total;
    }

    public int get_ID() {
        return _ID;
    }

    public void set_ID(int _ID) {
        this._ID = _ID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public int getNumberOfBooks() {
        return NumberOfBooks;
    }

    public void setNumberOfBooks(int numberOfBooks) {
        NumberOfBooks = numberOfBooks;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double total) {
        Total = total;
    }
}
