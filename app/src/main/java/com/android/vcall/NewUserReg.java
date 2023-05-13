package com.android.vcall;

import androidx.appcompat.app.AppCompatActivity;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.OnCompleteListener;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewUserReg extends AppCompatActivity {


    EditText email,name,phone,otpfield,passwdfld;
    Button otpsendbtn,signupbtn;

    private FirebaseAuth mauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user_reg);


        email = findViewById(R.id.usrEmail);
        passwdfld = findViewById(R.id.usrNewpasswd);
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        otpfield = findViewById(R.id.otpfield);

        otpsendbtn = findViewById(R.id.sendotpbtn);
        signupbtn = findViewById(R.id.signupbtn);

        mauth = FirebaseAuth.getInstance();  


        otpsendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }


}