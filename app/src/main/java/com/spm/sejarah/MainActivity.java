package com.spm.sejarah;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.Button;
import android.view.View;
import android.os.Bundle;
import android.widget.TextView;

import static com.spm.sejarah.R.id.btnlogin;


public class MainActivity extends AppCompatActivity {

    private Button a;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a= (Button) findViewById(btnlogin);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,menupage.class);
                startActivity(i); }
        });



}}
