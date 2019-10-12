package com.spm.sejarah;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {

    private Button a,b,c;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


      /*  a= (Button) findViewById(R.id.lbtnAdmin);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,login_admin.class);
                startActivity(i); }
        }); */


        b= (Button) findViewById(R.id.lbtnTeacher);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,login_teacher.class);
                startActivity(i); }
        });


        c= (Button) findViewById(R.id.lbtnStudent);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,login_student.class);
                startActivity(i); }
        });


}}
