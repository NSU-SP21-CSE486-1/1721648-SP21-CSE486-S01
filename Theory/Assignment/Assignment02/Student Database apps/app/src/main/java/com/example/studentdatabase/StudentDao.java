package com.example.studentdatabase;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
interface StudentDAO {

    @Insert
    default Long insertTask(Student student) {
        return null;
    }
}
