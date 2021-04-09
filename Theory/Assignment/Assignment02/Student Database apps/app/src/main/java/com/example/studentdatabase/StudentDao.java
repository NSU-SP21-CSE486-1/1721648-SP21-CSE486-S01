package com.example.studentdatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
interface StudentDAO {

    @Insert
    Long insertTask(Student student);

    @Update
    void updateTask(Student student);

    @Delete
    void deleteTask(Student student);






    @Query("select * from student order by studentid asc")
    List<Student>getAll();
}
