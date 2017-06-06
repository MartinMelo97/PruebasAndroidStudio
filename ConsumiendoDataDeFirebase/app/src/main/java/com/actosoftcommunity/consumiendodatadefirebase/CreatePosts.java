package com.actosoftcommunity.consumiendodatadefirebase;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;

public class CreatePosts extends AppCompatActivity {

    private EditText ETTitulo, ETCuerpo;
    private ImageButton btnSelectImage;
    private Button BtnUpload;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private static final int GALLERY_REQUEST = 1;
    private Uri mImageUri = null;
    private String email, Uid, titulo, cuerpo;
    private StorageReference mStorageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_posts);

        mAuth = FirebaseAuth.getInstance();
        mStorageRef = FirebaseStorage.getInstance().getReference();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null)
                {
                    email = user.getEmail();
                    Uid = user.getUid();
                }
                else
                {
                    Intent intento = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intento);
                }
            }
        };
        btnSelectImage = (ImageButton) findViewById(R.id.BtnImagen);
        ETTitulo = (EditText) findViewById(R.id.ETtitulo);
        ETCuerpo = (EditText) findViewById(R.id.ETCuerpo);
        BtnUpload = (Button) findViewById(R.id.BtnUpload);

        btnSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent, GALLERY_REQUEST);

            }
        });

        BtnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadtoFirebase();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == GALLERY_REQUEST && resultCode == RESULT_OK)
        {
            mImageUri = data.getData();
            btnSelectImage.setImageURI(mImageUri);
        }
    }

    private void uploadtoFirebase()
    {
        Toast.makeText(this, ""+email, Toast.LENGTH_SHORT).show();
        titulo = ETTitulo.getText().toString().trim();
        cuerpo = ETCuerpo.getText().toString().trim();
        email = email.toString().trim();

        Uri file = Uri.fromFile(new File(mImageUri.getLastPathSegment()));
        StorageReference Storageref = mStorageRef.child("posts/images").child(mImageUri.getLastPathSegment());
        Storageref.putFile(mImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {

            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Uri downloadUrl = taskSnapshot.getDownloadUrl();
                String urlImage = downloadUrl.toString().trim();
                DatabaseReference myRef = FirebaseDatabase.getInstance().getReference().child("Posts");
                String id = myRef.push().getKey();
                Toast.makeText(getApplicationContext(), ""+id, Toast.LENGTH_SHORT).show();
                Post post = new Post(titulo, cuerpo, email, urlImage, false);
                myRef.child(id).setValue(post);
                Toast.makeText(getApplicationContext(), "Tu post se ha agregado con exito", Toast.LENGTH_SHORT).show();
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
