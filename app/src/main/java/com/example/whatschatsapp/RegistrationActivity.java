package com.example.whatschatsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.auth.User;

public class RegistrationActivity extends AppCompatActivity {

    FirebaseAuth auth;


    EditText emailbox,passbox,namebox;
    Button loginbtn, signupbtn;

    FirebaseFirestore database;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        dialog = new ProgressDialog(this);
        dialog.setMessage("Please wait...");

        getSupportActionBar().hide();

        database = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();

        emailbox = findViewById(R.id.emailbox);
        passbox = findViewById(R.id.passwordbox);
        loginbtn = findViewById(R.id.loginbtn);
        signupbtn = findViewById(R.id.createbtn);
        namebox = findViewById(R.id.namebox);


        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
                String email,pass,name;
                email = emailbox.getText().toString();
                pass = passbox.getText().toString();
                name = namebox.getText().toString();



                auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            dialog.dismiss();

                            Intent intent = new Intent(getApplicationContext(),ProfileActivity.class);
                            startActivity(intent);
                        }else {
                            dialog.dismiss();
                            Toast.makeText(getApplicationContext(), task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });



            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}