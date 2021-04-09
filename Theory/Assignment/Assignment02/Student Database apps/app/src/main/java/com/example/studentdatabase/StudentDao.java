package com.example.studentdatabase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
interface StudentDAO {

    @Insert
    default Long insertTask(Student student) {
        return null;
    }


    @Query("select * from student order by studentid asc")
    List<Student>getAll();
}
