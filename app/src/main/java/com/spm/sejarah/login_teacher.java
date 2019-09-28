package com.spm.sejarah;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class login_teacher extends AppCompatActivity
{

    EditText pwteacher,icteacher;
    Button loginteacher;
    DatabaseReference table_teacher;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_teacher);

        icteacher = (EditText) findViewById(R.id.usernameTeacher);
        pwteacher = (EditText) findViewById(R.id.pwTeacher);
        loginteacher = findViewById(R.id.btnLoginT);


        teacher teach = new teacher();

        //init firebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        table_teacher = database.getReference("teacher");



        loginteacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }

        });


    }

    void loginUser(){
        table_teacher.addValueEventListener (new ValueEventListener()
        {

            public void onDataChange (@NonNull DataSnapshot dataSnapshot)
            {
                System.out.println(dataSnapshot);
                System.out.println(icteacher.getText().toString());
                //check if customer not exist in database
                if (dataSnapshot.child(icteacher.getText().toString()).exists())
                {
                    //get user information

                    //mDialog.dismiss();
                    teacher teach = dataSnapshot.child (icteacher.getText().toString()).getValue(teacher.class);
                    if (teach.getTeachPw().equals(pwteacher.getText().toString()))
                    {
                        Toast.makeText(login_teacher.this, "Login succesfuly", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent (login_teacher.this,menupage.class);
                        startActivity(i);
                    }
                    else
                    {
                        //mDialog.dismiss();
                        Toast.makeText(login_teacher.this, "Login failed.", Toast.LENGTH_SHORT).show();
                    }


                } else
                {
                    Toast.makeText(login_teacher.this, "Account does not exist.", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
