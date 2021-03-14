package com.example.eventdiary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class home1 extends AppCompatActivity {

    private String[] name = { "Holy Occassions's","Holydays","Wedding","Anniversary","Educational","Birthday"};
    private  int [] pic={R.drawable.em ,R.drawable.em ,R.drawable.em ,R.drawable.em ,R.drawable.em ,R.drawable.em};
    private List<events> eventsList=new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home1);
        recyclerView=findViewById(R.id.r);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        prepairethelist();
        recyclerAdapter adapter =new recyclerAdapter(eventsList);
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
}
