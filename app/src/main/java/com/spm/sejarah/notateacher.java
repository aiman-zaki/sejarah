package com.spm.sejarah;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class notateacher extends AppCompatActivity
{

        Button btnSelectFile,btnUpload;
        TextView notification;
        Uri pdfUri; //URLS that are meant for local storage


        FirebaseStorage storage;
        FirebaseDatabase database;
        ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notateacher);

        storage = FirebaseStorage.getInstance(); //return and object of firebase storage
        database = FirebaseDatabase.getInstance(); // return an object of firebase database

        btnSelectFile = (Button) findViewById(R.id.btnSelectFile);
        btnUpload = (Button) findViewById(R.id.btnUpload);
        notification = (TextView) findViewById(R.id.notification);

        btnSelectFile.setOnClickListener(new View.OnClickListener()
       {

            @Override
            public void onClick(View view)
            {

                if (ContextCompat.checkSelfPermission(notateacher.this,Manifest.permission.READ_EXTERNAL_STORAGE)) == PackageManager.PERMISSION_GRANTED)
                {
                    selectPdf();

                }
                else
                {
                   ActivityCompat.requestPermissions(notateacher.this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE},int requestCode 9);
                }
            }
       });

        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (pdfUri!=null) //user has selected the file
                uploadFile(pdfUri);
                else
                    Toast.makeText(notateacher.this, "Select a file",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void uploadFile(Uri pdfUri) {

        progressDialog=new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("Uploading File");
        progressDialog.setProgress(0);
        progressDialog.show();


        final String fileName=System.currentTimeMillis()+"";
        StorageReference reference = storage.getReference(); //return root path

        StorageReference.child("Uploads").child(fileName).putFile(pdfUri)
            .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                    String url = taskSnapshot.getDownloadUrl().toString(); // return the url of your uploaded file
                    //store url in realtime database

                    DatabaseReference reference =database.getReference(); //return the path to root

                    reference.child(fileName).setValue(url).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if (task.isSuccessful())
                                Toast.makeText(notateacher.this,"File suscessfully uploaded",Toast.LENGTH_SHORT).show();
                            else
                                Toast.makeText(notateacher.this,"File not suscessfully uploaded",Toast.LENGTH_SHORT).show();

                        }
                    });

                }
            }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Toast.makeText(notateacher.this,"File not suscessfully uploaded",Toast.LENGTH_SHORT).show();

            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {

                //track the progress of our upload
                int currentProgress = (int) (100*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                progressDialog.setProgress(currentProgress);

            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode==9 && grantResults[0] ==PackageManager.PERMISSION_GRANTED)
        {
         selectPdf();
        }
        else
            Toast.makeText(notateacher.this, "Please provide permission", Toast.LENGTH_SHORT).show();
    }

    private void selectPdf()
        {
            //to offer user to select a file using file manager (intent)

            Intent intent = new Intent();
            Intent.setType("application/pdf");
            Intent.setAction(Intent.ACTION_GET_CONTENT); //to fetch files
            int requestCode;
            startActivityForResult(intent, requestCode 86);

        }

 //TO CHECK SUCCESSFULLY SELECT A FILE
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        
        super.onActivityResult(requestCode, resultCode, data);

        //CHECK WHETHER USER HAS SELECTED A FILE OR NOT

        if ( requestCode==86 && resultCode == RESULT_OK && data!=null )
        {
            pdfUri=data.getData(); // return uri of selected file
            notification.setText("A file is selected:" + data.getData().getLastPathSegment());
        }
        else
        {
            Toast.makeText(notateacher.this, "Please select a file",Toast.LENGTH_SHORT).show();
        }

    }
}

