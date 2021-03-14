package com.example.eventdiary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.mbms.MbmsErrors;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signIn extends AppCompatActivity {


    EditText emEt;
    EditText passEt;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        init();
        getInfo();


    }

    public void init() {
        emEt=findViewById(R.id.emEt);
        passEt=findViewById(R.id.passEt);
        auth=FirebaseAuth.getInstance();
    }

    public void getInfo() {
        String email = emEt.getText().toString();
        String pass = passEt.getText().toString();

        if (email.isEmpty()) {
            emEt.setError("Required Email");
        } else if (pass.isEmpty()) {

            passEt.setError("Required password");
        } else {
            loginUser(email, pass);
        }
    }


    private void loginUser(String email, String pass) {
        auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Intent intent1 = new Intent(signIn.this,home1.class);
                    startActivity(intent1);
                } else {
                    Toast.makeText(signIn.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void login(View view) {
        getInfo();
    }

    public void signUp(View view) {
        Intent intent2 = new Intent(signIn.this,signUp.class);
        startActivity(intent2);
    }

    public void forget(View view) {
        Intent intent3 = new Intent(signIn.this,Forget.class);
        startActivity(intent3);

    }
}
