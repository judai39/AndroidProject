package com.haoyudu.myapplication.student_database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.haoyudu.myapplication.dao.StudentDao;
import com.haoyudu.myapplication.student.Student;

@Database(entities = Student.class,version = 1,exportSchema = false)
public abstract class StudentDatabase extends RoomDatabase {
    private static StudentDatabase databaseInstance;

    public static synchronized StudentDatabase getInstance(Context context){
        if (databaseInstance==null){
            databaseInstance= Room.databaseBuilder(context.getApplicationContext(),StudentDatabase.class,"student_database").build();
        }
        return databaseInstance;
    }

    public abstract StudentDao getStudentDao();
}
