package com.haoyudu.pagingdatastandard.dao;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.haoyudu.pagingdatastandard.student.Student;

@Dao
public interface StudentDao {

    @Insert
    void insertStudent(Student...students);

    @Query("DELETE FROM STUDENT_TBL")
    void deleteAllStudents();

    @Query("SELECT * FROM STUDENT_TBL ORDER BY studentId")
    DataSource.Factory<Integer,Student> queryStudents();
}
