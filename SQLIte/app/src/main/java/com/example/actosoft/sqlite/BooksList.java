package com.example.actosoft.sqlite;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class BooksList extends AppCompatActivity {
    int id;
    TextView TVUser;
    SimpleCursorAdapter adapter_books;
    ListView LVbooks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_list);

        Intent intento = getIntent();
        id = intento.getIntExtra("id",0);

        LVbooks = (ListView) findViewById(R.id.LVBooks);

        if(id > 0)
        {
            DataBaseManager managerRead = new DataBaseManager(this, "read");
            Cursor user = managerRead.lookingForLoggedUser(id);
            TVUser = (TextView) findViewById(R.id.TVWelcomeUser);
            if(user.moveToFirst())
            {
                TVUser.setText("Bienvenido "+user.getString(0));
                //Adapter
                Cursor books = managerRead.lookingForAllBooks();
                String[] from = new String[] {managerRead.BK_TITLE, managerRead.BK_PRICE};
                int[] to = new int[] {android.R.id.text1, android.R.id.text2};

                adapter_books = new SimpleCursorAdapter(this,android.R.layout.two_line_list_item, books,from, to,0);

                LVbooks.setAdapter(adapter_books);

            }
        }
    }
}
