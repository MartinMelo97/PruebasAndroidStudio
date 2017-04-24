package com.example.actosoft.playingwithrelativesandlinears;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.BoolRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tecmartinmelo on 4/23/17.
 */

public class ProductListAdaper extends ArrayAdapter<Product>{
    TextView TVtitle, TVAuthor, TVPrice;
    CheckBox CB;
    private Context mContext;
    private ArrayList<Product> mProductList;
    Boolean save;

    public ProductListAdaper(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<Product> objects) {
        super(context, resource, objects);
        this.mProductList = objects;
        this.mContext = context;
    }

    //
    class ViewHolder{
        TextView title;
        TextView author;
        TextView price;
        CheckBox name;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;

        if (view == null) {
            view = View.inflate(mContext, R.layout.item_products_books, null);

            holder = new ViewHolder();

            holder.title = (TextView) view.findViewById(R.id.TVTitle);
            holder.author = (TextView) view.findViewById(R.id.TVAuthor);
            holder.price = (TextView) view.findViewById(R.id.TVPrice);
            holder.name = (CheckBox) view.findViewById(R.id.CBWant);
            CB = (CheckBox) view.findViewById(R.id.CBWant);

            view.setTag(holder);

            holder.name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    save = false;
                    CheckBox cb = (CheckBox) view;
                    Product producto = (Product) cb.getTag();
                    BooksSelected booksel = new BooksSelected();
                    if(CB.isChecked()) {
                        save = true;
                    }

                    if(save == true)
                    {
                        booksel.AddBookSelected(producto.getId(), mContext);
                    }
                    else{
                        int id;
                        if(booksel.bookSelectedList.size() > 0)
                        {
                            for(int i = 0; i < booksel.bookSelectedList.size(); i++)
                            {
                                id = booksel.bookSelectedList.get(i);
                                if(producto.getId() == id)
                                {
                                    booksel.RemoveBookSelected(id, mContext);
                                }
                            }
                        }
                    }
                }
            });

        }
        else
        {
            holder = (ViewHolder) view.getTag();
        }
        Product producto = mProductList.get(i);
        holder.title.setText(producto.getTitle());
        holder.author.setText(producto.getAuthor());
        holder.price.setText("$"+producto.getPrice());
        holder.name.setTag(producto);

        return view;

    }
}

