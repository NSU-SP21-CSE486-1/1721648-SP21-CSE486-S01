package com.example.studentdatabase;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface StudentDao {

    @Insert
    default Long insertTask(Student student) {
        return null;
    }
}
