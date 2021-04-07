package com.example.studentdatabase;

import android.content.Context;
import android.widget.Toast;

import androidx.room.Room;

public class StudentRepository {

    private String dbName="studentdb";
    private StudentDatabase studentDatabase;
    Context context;

    public StudentRepository(Context context) {
        this.context = context;
        studentDatabase= Room.databaseBuilder(context,StudentDatabase.class,dbName).build();

        Toast.makeText(context, "database created", Toast.LENGTH_SHORT).show();
    }
}

