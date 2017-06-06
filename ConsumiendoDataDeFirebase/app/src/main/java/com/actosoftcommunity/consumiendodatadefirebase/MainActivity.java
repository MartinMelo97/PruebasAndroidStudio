package com.actosoftcommunity.consumiendodatadefirebase;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private EditText ETCorreo, ETContra;
    private Button BtnLogin;
    String correo, contra;
    private TextView TVCreate;
    private static String TAG = "Frepo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();


        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                    //Toast.makeText(MainActivity.this, "Logueado", Toast.LENGTH_SHORT).show();
                    Intent Postsact = new Intent(getApplicationContext(), PostsActivity.class);
                    startActivity(Postsact);
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };

        ETCorreo = (EditText) findViewById(R.id.ETCorreo);
        ETContra = (EditText) findViewById(R.id.ETPass);
        BtnLogin = (Button) findViewById(R.id.BtnLogin);
        TVCreate = (TextView) findViewById(R.id.TVCreate);

        BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                correo = ETCorreo.getText().toString();
                contra = ETContra.getText().toString();

                if(correo.length() > 0 && contra.length() > 0)
                {
                    checkIfUserExists(correo, contra);
                }
            }
        });

        TVCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(getApplicationContext(), CreateUser.class);
                startActivity(intento);
            }
        });
    }

    public void checkIfUserExists(String correo, String contra)
    {
        mAuth.signInWithEmailAndPassword(correo, contra)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());

                    // If sign in fails, display a message to the user. If sign in succeeds
                    // the auth state listener will be notified and logic to handle the
                    // signed in user can be handled in the listener.
                    if (!task.isSuccessful()) {
                        Log.w(TAG, "signInWithEmail:failed", task.getException());
                        Toast.makeText(getApplicationContext(), "Datos incorrectos", Toast.LENGTH_SHORT).show();
                    }

                    // ...
                }
            });
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}
