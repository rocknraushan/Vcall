package com.android.vcall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.OnCompleteListener;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText emailid,password;
    Button signin,newuserbtn;

    private FirebaseAuth mauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mauth = FirebaseAuth.getInstance();

        signin= findViewById(R.id.sign_in);
        emailid = findViewById(R.id.email);
        password = findViewById(R.id.editTextTextPassword);
        newuserbtn = findViewById(R.id.Register);


        Intent goToNewUser = new Intent(this, NewUserReg.class);
        newuserbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(goToNewUser);
            }
        });



        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailid.getText().toString(),
                        passwordtxt = password.getText().toString();

                login(email,passwordtxt);
            }
        });

    }

    private void login(String email, String password){

        mauth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            FirebaseUser user = mauth.getCurrentUser();
                            updateUi(user);
                        } else {
                            Toast.makeText(Login.this, "Invalid!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

    private void updateUi(FirebaseUser user){

        if (user != null){
            Intent goToUserProfile = new Intent(this, OtpValidate.class);
            startActivity(goToUserProfile);
        } else {
            Toast.makeText(this, "Invalid Email/password", Toast.LENGTH_SHORT).show();
        }

    }
}