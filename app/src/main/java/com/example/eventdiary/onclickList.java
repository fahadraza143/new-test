package com.example.eventdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class onclickList extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextView;

    TextView tvTimer;
    int t1Hour,t1Minute;
    EditText et;
    DatePickerDialog.OnDateSetListener lisner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_onclick_list);
        autoCompleteTextView= findViewById(R.id.autoCompleteText);

        String [] item= {"Brunch","Lunch","Dinner"};
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.menu_item,item);
        //'''''''''''''''''''to make defult value'''''''//
        autoCompleteTextView.setText(arrayAdapter.getItem(0).toString(),false);
        autoCompleteTextView.setAdapter(arrayAdapter);



        setContentView(R.layout.activity_onclick_list);

        et=findViewById(R.id.edit_text);
        tvTimer=findViewById(R.id.tv_timer);


        Calendar c = Calendar.getInstance();
        final int year=c.get(Calendar.YEAR);
        final int month=c.get(Calendar.MONTH);
        final int day=c.get(Calendar.DAY_OF_MONTH);


        //';;;;;;;;'''''''''''timer''''''''''''';;;;;;;;;;//

        tvTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //''''''''''''Initianlize time piker diolog;;;;;;;;;;;;;//

                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        onclickList.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker , int hourOfDay, int minute) {
                                //'''''''''''''''initializehour and minute'''''''''''''''//
                                t1Hour= hourOfDay;
                                t1Minute=minute;
                                // '''''''''initialize calander'''''''///////

                                Calendar c = Calendar.getInstance();
                                //'''''set hour and minute'''''''//
                                c.set(0, 0, 0,t1Hour,t1Minute);
                                //''''''''''set selected time on text view'''''//
                                tvTimer.setText(DateFormat.format("hh:mm",c));
                            }
                        },12,0,false
                );
                //'''''''''''''''''''''''''Displayed previous selected''''''////////
                timePickerDialog.updateTime(t1Hour, t1Minute);
                //''''''''show dialog'''''''''''//
                timePickerDialog.show();
            }
        });




        //'''''''''''''''''''''for edit text'''''''''''''''''''''//

        et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(onclickList.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        month = month + 1;
                        String date = dayOfMonth +"/"+ month + "/" + year;
                        et.setText(date);

                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

    }
}
