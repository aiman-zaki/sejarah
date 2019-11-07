package com.spm.sejarah;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class listkelas extends AppCompatActivity {

    private Button z;
    private Button jlo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listkelas);

        z= (Button) findViewById(R.id.btnkelasA);
        z.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(listkelas.this,menupageteacher.class);
                startActivity(i); }
        });


        jlo= (Button) findViewById(R.id.btnkelasb);
        jlo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(listkelas.this,studentList.class);
                startActivity(i); }
        });
    }
}
