package com.spm.sejarah;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class listkelas extends AppCompatActivity {

    private Button z;

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

    }
}
