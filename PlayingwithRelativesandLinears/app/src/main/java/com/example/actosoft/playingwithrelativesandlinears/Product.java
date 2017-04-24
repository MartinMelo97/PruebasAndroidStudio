package com.example.actosoft.playingwithrelativesandlinears;

/**
 * Created by tecmartinmelo on 4/23/17.
 */

public class Product {
    private int id;
    private String title;
    private int price;
    private String author;
    boolean selected = false;

    public Product(int id, String title, int price, String author){
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isSelected(){
        return selected;
    }

    public  void  setSelected(boolean selected)
    {
        this.selected = selected;
    }
}
