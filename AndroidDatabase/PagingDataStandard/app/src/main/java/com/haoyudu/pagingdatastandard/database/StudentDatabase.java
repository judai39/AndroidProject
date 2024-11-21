package com.haoyudu.pagingdatastandard.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.haoyudu.pagingdatastandard.dao.StudentDao;
import com.haoyudu.pagingdatastandard.student.Student;

@Database(entities = Student.class,version = 1,exportSchema = false)
public abstract class StudentDatabase extends RoomDatabase {
    static StudentDatabase studentDatabase;

    public static StudentDatabase getInstance(Context context){
        if (studentDatabase==null){
            studentDatabase= Room.databaseBuilder(context,StudentDatabase.class,"student_database")
                    .build();
        }
        return studentDatabase;
    }

    public abstract StudentDao getStudentDao();
}
