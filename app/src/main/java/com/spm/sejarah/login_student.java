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


public class login_student extends AppCompatActivity
{
    EditText pwstudent,icstudent;
    Button loginstudent;

    @Override
   protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_student);

        icstudent= (EditText) findViewById(R.id.usernameStudent);
        pwstudent = (EditText) findViewById(R.id.pwStudent);
        loginstudent = (Button) findViewById(R.id.btnlogin);

            //init firebase
            final FirebaseDatabase database = FirebaseDatabase.getInstance();
            final DatabaseReference table_student = database.getReference("student");

            loginstudent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    table_student.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.child(icstudent.getText().toString()).exists()){
                                student stud = dataSnapshot.child(icstudent.getText().toString()).getValue(student.class);
                                if(stud.getStudPw().equals(pwstudent.getText().toString())){
                                    Toast.makeText(login_student.this, "Login success", Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(login_student.this, menupage.class);
                                    startActivity(i);
                                }
                                else
                                {
                                    Toast.makeText(login_student.this, "Login failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else
                            {
                                Toast.makeText(login_student.this, "user not exist", Toast.LENGTH_SHORT).show();
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

