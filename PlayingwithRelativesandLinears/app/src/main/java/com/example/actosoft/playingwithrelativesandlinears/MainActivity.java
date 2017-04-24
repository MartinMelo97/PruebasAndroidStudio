package com.example.actosoft.playingwithrelativesandlinears;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    private ListView lvProduct;
    private ProductListAdaper adapter;
    private ArrayList<Product> mProductList;
    private CheckBox CHBox;
    private List<Integer> bookslvcompa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvProduct = (ListView) findViewById(R.id.Lview);
        CHBox = (CheckBox) findViewById(R.id.CBWant);
        mProductList = new ArrayList<Product>();
        Button Send;
        //Add sample data for list
        //We can get data from DB, Website, etc
        mProductList.add(new Product(1, "Libro1", 100,"Lupe"));
        mProductList.add(new Product(2, "CId", 400, "Juan"));
        mProductList.add(new Product(3, "Hambre",1000,"Mon"));
        mProductList.add(new Product(4, "Carencia",123,"Suptm"));
        mProductList.add(new Product(5, "Balas",1,"Miro"));

        adapter = new ProductListAdaper(getApplicationContext(),R.layout.item_products_books, mProductList);
        lvProduct.setAdapter(adapter);

        Send = (Button) findViewById(R.id.BtnSend);

        Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BooksSelected b = new BooksSelected();
                bookslvcompa = b.bookSelectedList;
                if(bookslvcompa.size() > 0)
                {
                    for (int i = 0; i < bookslvcompa.size(); i++)
                    {
                        Toast.makeText(MainActivity.this, ""+bookslvcompa.get(i), Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
