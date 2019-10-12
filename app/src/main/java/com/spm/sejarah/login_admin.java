package com.spm.sejarah;

import android.content.Intent;
import android.os.Bundle;
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

import static com.spm.sejarah.R.layout.activity_login_admin;

public class login_admin extends AppCompatActivity {

    EditText pwadmin,icadmin;
    Button loginadmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_login_admin);


        icadmin= (EditText) findViewById(R.id.usernameAdmin);
        pwadmin = (EditText) findViewById(R.id.pwAdmin);
        loginadmin = (Button) findViewById(R.id.btnLoginA);

        //init firebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_admin = database.getReference("admin");

        loginadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                table_admin.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(icadmin.getText().toString()).exists()){
                            admin adm = dataSnapshot.child(icadmin.getText().toString()).getValue(admin.class);
                            if(adm.getAdminPw().equals(pwadmin.getText().toString())){
                                Toast.makeText(login_admin.this, "Login success", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(login_admin.this, menupageadmin.class);
                                startActivity(i);
                            }
                            else
                            {
                                Toast.makeText(login_admin.this, "Login failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(login_admin.this, "user not exist", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });



    }
}
