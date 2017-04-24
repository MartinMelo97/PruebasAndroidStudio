package com.example.actosoft.playingwithrelativesandlinears;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tecmartinmelo on 4/24/17.
 */

public class BooksSelected {
    public List<Integer> bookSelectedList = new ArrayList<Integer>();

    public void AddBookSelected(int id, Context context){
        if(id > 0) {
            Toast.makeText(context, "" + id, Toast.LENGTH_SHORT).show();
            bookSelectedList.add(id);
        }
        else
        {
            Toast.makeText(context, "No llega nada", Toast.LENGTH_SHORT).show();
        }
    }

    public void RemoveBookSelected(int id, Context context){
        Toast.makeText(context, "Bye"+id, Toast.LENGTH_SHORT).show();
        bookSelectedList.remove(id);
    }
}
