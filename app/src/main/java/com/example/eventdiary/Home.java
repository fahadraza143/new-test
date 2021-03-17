package com.example.eventdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity {

    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    auth=FirebaseAuth.getInstance();
    }



    public void logout(View view) {
        auth.signOut();
        Intent intent = new Intent(Home.this,signIn.class);
        startActivity(intent);

    }

    public void home(View view) {
        Intent intent = new Intent(Home.this,onclickList.class);
        startActivity(intent);
    }

    public void mainpage(View view) {
        Intent intent = new Intent(Home.this,home1.class);
        startActivity(intent);
    }
}
