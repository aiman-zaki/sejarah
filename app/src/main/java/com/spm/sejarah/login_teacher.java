package com.spm.sejarah;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class login_teacher extends AppCompatActivity  {

    EditText pwteacher,icteacher;
    Button loginteacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_teacher);

        icteacher = (EditText) findViewById(R.id.pwTeacher);
        pwteacher = (EditText) findViewById(R.id.pwTeacher);
        loginteacher = (Button) findViewById(R.id.btnLoginT);

        teacher teach = new teacher();

        //init firebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_teacher = database.getReference("teacher");
}

    loginteacher.setOnClickListener ((view))
    {

        if(!validateUername() | validatePassword ())
        {
            return;
        }
        final ProgressDialog mDialog = new ProgressDialog (login_teacher.this);
        mDialog.setMessage("Loading...");
        mDialog.show();

        table_teacher.addValueEventListener (new ValueEventListener()
        {

            public void onDataChange (@NonNull DataSnapshot dataSnapshot)
            {

                //check if customer not exist in database
                if (dataSnapshot.child(icteacher.getText().toString().exists())
                {
                    //get user information

                    mDialog.dismiss();
                    teacher teach = dataSnapshot.child (icteacher.getText().toString().getValue(teacher.class));
                    if (teach.getTeachPw().equals(pwteacher.getText().toString()))
                    {
                        Toast.makeText(login_teacher.this, "Login succesfuly", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent (login_teacher.this,menupage.class);
                        startActivity(i);
                    }
                    else
                    {
                        mDialog.dismiss();
                        Toast.makeText(login_teacher.this, "Account does not exist.", Toast.LENGTH_SHORT).show();
                    }


            }

        }


     }
}
}
