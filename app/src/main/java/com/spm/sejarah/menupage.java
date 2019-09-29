package com.spm.sejarah;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class menupage extends AppCompatActivity {
    private TextView f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menupage);

        f= (TextView) findViewById(R.id.btnnota);
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(menupage.this,notaform4.class);
                startActivity(i); }
        });




    }

}
