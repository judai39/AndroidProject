package com.haoyudu.myapplication.dao;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.haoyudu.myapplication.student.Student;

import java.util.List;

@Dao
public interface StudentDao {

    @Insert
    void insertStudent(Student...students);

    @Query("DELETE FROM STUDENT_TBL")
    void deleteAllStudents();

//    @Query("SELECT * FROM STUDENT_TBL ORDER BY id")
//    LiveData<List<Student>> queryAllStudents();

    @Query("SELECT * FROM STUDENT_TBL ORDER BY id")
    DataSource.Factory<Integer,Student> queryAllStudents();


}
