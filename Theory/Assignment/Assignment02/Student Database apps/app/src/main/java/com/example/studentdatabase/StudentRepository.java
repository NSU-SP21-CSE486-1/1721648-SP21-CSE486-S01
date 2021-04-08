package com.example.studentdatabase;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.room.Room;

import static android.os.AsyncTask.execute;

public class StudentRepository {

    private String dbName="studentdb";
    private StudentDatabase studentDatabase;
    Context context;
    private Object Void;


    public StudentRepository(Context context) {
        this.context = context;
        studentDatabase= Room.databaseBuilder(context,StudentDatabase.class,dbName).build();

        Toast.makeText(context, "database created", Toast.LENGTH_SHORT).show();
    }

    //Insert student profile
    public void InsertTask (final Student student)
    {
        new AsyncTask< Void,Void ,Void>(){


            @SuppressLint("StaticFieldLeak")
            @Override
            protected java.lang.Void doInBackground(java.lang.Void... voids) {
                studentDatabase.studentDAO().insertTask(student);
                return null;
            }
        }.execute();



    }

}

