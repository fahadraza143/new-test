package com.example.eventdiary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class home1 extends AppCompatActivity {

    private String[] name = { "Holy Occassions","Holidays","Wedding","Anniversary","Educational","Birthday"};
    private  int [] pic={R.drawable.holy ,R.drawable.holidays ,R.drawable.wedding ,R.drawable.ani ,R.drawable.edu ,R.drawable.birth};
    private List<events> eventsList=new ArrayList<>();
    private RecyclerView recyclerView;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth=FirebaseAuth.getInstance();
        setContentView(R.layout.activity_home1);
        recyclerView=findViewById(R.id.r);

        prepairethelist();
        recyclerAdapter adapter =new recyclerAdapter(eventsList);

        GridLayoutManager layoutManager = new GridLayoutManager(home1.this,2);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);



    }
  private void prepairethelist(){
        int count = 0;
        for(String name : name){
            events event =new events(name,pic[count]);
            eventsList.add(event);
            count++;
        }

    }

    public void signout(View view) {
        auth.signOut();
        Intent intent = new Intent(home1.this,signIn.class);
        startActivity(intent);


    }
}
