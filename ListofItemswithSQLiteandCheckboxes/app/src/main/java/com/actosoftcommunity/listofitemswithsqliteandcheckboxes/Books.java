package com.actosoftcommunity.listofitemswithsqliteandcheckboxes;

/**
 * Created by martinmelo on 4/24/17.
 */

public class Books {
    private int _ID;
    private String Title;
    private String Author;
    private double Price;
    private boolean isChecked;

    public Books(int _ID, String title, String author, double price, boolean isChecked) {
        this._ID = _ID;
        Title = title;
        Author = author;
        Price = price;
        this.isChecked = isChecked;
    }

    public int get_ID() {
        return _ID;
    }

    public void set_ID(int _ID) {
        this._ID = _ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
