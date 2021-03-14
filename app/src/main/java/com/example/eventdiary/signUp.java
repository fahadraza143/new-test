package com.example.eventdiary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signUp extends AppCompatActivity {

    EditText fnEt;
    EditText lnEt;
    EditText cnEt;
    EditText emailEt;
    EditText passEt;
    EditText passEt2;
    FirebaseAuth auth;
    FirebaseDatabase database;
    DatabaseReference ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        init();

    }

    private void init() {
        fnEt=findViewById(R.id.fnEt);
        lnEt=findViewById(R.id.lnEt);
        cnEt=findViewById(R.id.cnEt);
        emailEt=findViewById(R.id.email);
        passEt=findViewById(R.id.pass1);
        passEt2=findViewById(R.id.pass2);
        auth=FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();
        ref=database.getReference("Id user");

    }



    public void signUp(View view){
        String fn=fnEt.getText().toString();
        String ln1=lnEt.getText().toString();
        String cn=cnEt.getText().toString();
        String email=emailEt.getText().toString();
        String pas=passEt.getText().toString();
        String pas2=passEt2.getText().toString();

        if(fn.isEmpty()) {
            fnEt.setError("Required First Name");
        } else if(ln1.isEmpty() ){
            lnEt.setError("Required Last Name");
        }
        else if(cn.isEmpty() ){
            cnEt.setError("Required Last Name");
        }else if(email.isEmpty() ){
            emailEt.setError("Required Last Name");
        }else if(pas.isEmpty() ){
            passEt.setError("Required Last Name");
        }else if(pas2.isEmpty() ){
            passEt2.setError("Required Last Name");
        }

        else{
            sinUpuser(fn,ln1,cn,email,pas);

        }
    }

    private void sinUpuser(final String fn, final String ln1, final String cn, final String email, final String pas) {
        auth.createUserWithEmailAndPassword(email,pas).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    String key=auth.getCurrentUser().getUid();
                    userId user=new userId(fn,ln1,cn,email,pas);
                    ref.child(key).setValue(user);

                    Intent intent = new Intent(signUp.this,home1.class);
                    startActivity(intent);
                }else
                    Toast.makeText(signUp.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
