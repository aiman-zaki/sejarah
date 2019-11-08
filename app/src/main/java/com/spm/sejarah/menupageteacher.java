package com.spm.sejarah;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class menupageteacher extends AppCompatActivity {

    private TextView x,y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menupageteacher);


        x= (TextView) findViewById(R.id.btnStudentList);
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(menupageteacher.this,studentList.class);
                startActivity(i); }
        });


        y= (TextView) findViewById(R.id.btnnotat);
        y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(menupageteacher.this,notateacher.class);
                startActivity(i); }
        });


    }
}
