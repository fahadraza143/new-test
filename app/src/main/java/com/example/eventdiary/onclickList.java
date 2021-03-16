package com.example.eventdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class onclickList extends AppCompatActivity {

    TextView tv;
    TextView tvTimer;
    int t1Hour,t1Minute;
    EditText et;
    DatePickerDialog.OnDateSetListener lisner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onclick_list);
        tv=findViewById(R.id.text_view);
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


        //'''''''''''''''for text view'''''''''''''''''//
        tv.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View view) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(onclickList.this,android.R.style.Theme_Holo_Dialog_MinWidth,lisner,year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        lisner=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {

                month = month + 1;
                String date = dayOfMonth +"/" + month+"/"+year;
                tv.setText(date);
            }
        };

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
