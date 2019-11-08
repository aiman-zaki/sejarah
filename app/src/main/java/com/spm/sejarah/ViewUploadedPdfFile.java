package com.spm.sejarah;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class ViewUploadedPdfFile extends AppCompatActivity {

    ListView pdflistview;
    DatabaseReference databaseReference;

   List<Upload> uploadPDFS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_uploaded_pdf_file);

        pdflistview = (ListView) findViewById(R.id.pdflistview);
        
        
        viewAllFile();


        pdflistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Upload Upload =uploadPDFS.get(position);

                Intent intent = new Intent();
                intent.setType(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(Upload.getFileUrl()));
                startActivity(intent);
            }
        });
    }

    private void viewAllFile() {

        databaseReference = FirebaseDatabase.getInstance().getReference("extraNotes");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Upload Upload = postSnapshot.getValue(com.spm.sejarah.Upload.class);
                    uploadPDFS.add(Upload);
                }

                String[] uploads = new String[uploadPDFS.size()];

                for (int i = 0; i < uploads.length; i++) {
                    uploads[i] = uploadPDFS.get(i).getFileName();
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, uploads)

               @Override
                public View getView(int position,View convertView, ViewGroup parent);
                {
                    View view = super.getView(position,convertView,parent);

                    TextView myText =(TextView) view.findViewById(android.R.id.text1);
                    myText.setTextColor(Color.BLACK);

                    //return super.getView(position,convertView,parent);

                    return view;

                };
                pdflistview.setAdapter(adapter);

                }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {

            };


        }


}
