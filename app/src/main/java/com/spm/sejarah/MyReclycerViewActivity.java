package com.spm.sejarah;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MyReclycerViewActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.recylcler_view);

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                //call individual items at the database reference

                String fileName=dataSnapshot.getKey(); //return filename

                String url=dataSnapshot.getValue(String.class); // return url for filename

                ((MyAdapter) recyclerView.getAdapter()).update(fileName,url);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


         recyclerView=findViewById(R.id.recycleView);
        //custom adapters
        //populate the recycler view with items
        recyclerView.setLayoutManager(new LinearLayoutManager(MyReclycerViewActivity.this));
        MyAdapter myAdapter = new MyAdapter(recyclerView,MyReclycerViewActivity.this, new ArrayList<String>(),new  ArrayList<String>());
        recyclerView.setAdapter(myAdapter);
    }

}


