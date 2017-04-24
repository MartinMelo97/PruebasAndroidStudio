package com.example.actosoft.sqlite;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.constraint.solver.widgets.Snapshot;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ETUser, ETPass;
    String user, pass;
    Button BtnIngresar;
    Cursor users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DataBaseManager manager = new DataBaseManager(this, "write");

        BtnIngresar = (Button) findViewById(R.id.BtnLogin);

        BtnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean exists = true;
                ETUser = (EditText) findViewById(R.id.ETUser);
                ETPass = (EditText) findViewById(R.id.ETPass);
                user = ETUser.getText().toString();
                pass = ETPass.getText().toString();

                if(user.length() > 0 && pass.length() > 0)
                {
                    //Toast.makeText(MainActivity.this, "Entro", Toast.LENGTH_SHORT).show();
                    final DataBaseManager managerRead = new DataBaseManager(MainActivity.this, "read");
                    users = managerRead.lookingForUser();


                    int UserColumnIndex = users.getColumnIndex(managerRead.US_USER);
                    int PassColumnIndex = users.getColumnIndex(managerRead.US_PASS);
                    Log.d("Si",""+UserColumnIndex);
                    Log.d("No",""+PassColumnIndex);
                    while(users.moveToNext())
                    {
                       Log.d("Que onda", "que pez");
                        /*Log.d("ID", ""+users.getString(0));
                        Log.d("User",""+users.getString(1));
                        Log.d("Pass",""+users.getString(2));
                        Log.d("Lo que escribi", user);
                        Log.d("Lo que viene por ahi", users.getString(UserColumnIndex));*/
                        if(users.getString(UserColumnIndex).equals(user))
                        {
                            Log.d("If", "Si hay usuario");

                            if(users.getString(PassColumnIndex).equals(pass))
                            {
                                int id = Integer.parseInt(users.getString(0));
                                //Snackbar.make(view, "Sistas", Snackbar.LENGTH_SHORT).show();
                                Intent intento = new Intent(getApplicationContext(), BooksList.class);
                                intento.putExtra("id", id);
                                startActivity(intento);
                                break;

                            }
                            else
                            {
                                Snackbar.make(view, "Bad pass", Snackbar.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            exists = false;
                        }

                    }

                    if(exists == false)
                    {
                        Snackbar.make(view, "No existe ese usuario", Snackbar.LENGTH_SHORT).show();
                    }

                }
                else
                {
                    Snackbar.make(view, "No se han llenado los campos", Snackbar.LENGTH_SHORT).show();
                }
            }
        });
    }
}
