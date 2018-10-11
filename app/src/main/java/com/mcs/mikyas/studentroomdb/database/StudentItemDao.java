package com.mcs.mikyas.studentroomdb.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.mcs.mikyas.studentroomdb.Model.Student;

import java.util.List;

@Dao

public interface StudentItemDao {

    @Insert
    void insertAll(List<Student> students);
    @Insert
    void insert(Student stud);

     @Query("SELECT * FROM Student ORDER BY firstname")
    List<Student> getAll();

     @Query("SELECT COUNT(*) from student")
     int countitems();

}
