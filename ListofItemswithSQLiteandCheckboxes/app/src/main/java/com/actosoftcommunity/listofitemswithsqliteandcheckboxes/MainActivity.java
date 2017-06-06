package com.actosoftcommunity.listofitemswithsqliteandcheckboxes;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText ETUser, ETPass;
    String user, pass;
    Button BtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instanciamos nuestro helper para crear o traer nuestra base de datos
        final DataBaseManager manager = new DataBaseManager(this, "write");
        manager.close();

        BtnLogin = (Button) findViewById(R.id.BtnEntrar);

        BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ETUser = (EditText) findViewById(R.id.ETUser);
                ETPass = (EditText) findViewById(R.id.ETPass);
                user = ETUser.getText().toString();
                pass = ETPass.getText().toString();

                if(user.length() > 0 && pass.length() > 0)
                {
                    Cursor users_in_db;
                    final DataBaseManager managerRead = new DataBaseManager(MainActivity.this, "read");
                    users_in_db = managerRead.getAllUsers();

                }
            }
        });
    }
}
