package com.example.eventdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class Forget extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);


    }

    public void logout(View view) {

        Intent intent = new Intent(Forget.this,Home.class);
        startActivity(intent);
    }
}
