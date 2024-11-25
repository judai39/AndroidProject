package com.haoyudu.myapplication.view_model;

import android.app.Application;
import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.loader.content.AsyncTaskLoader;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import androidx.paging.PagedListConfigKt;
import androidx.room.Database;
import com.haoyudu.myapplication.dao.StudentDao;
import com.haoyudu.myapplication.student.Student;
import com.haoyudu.myapplication.student_database.StudentDatabase;

import java.util.List;

public class MyViewModel extends AndroidViewModel {
    /**引入page3后已废弃,现使用PagingData进行维护*/
    private LiveData<PagedList<Student>> allStudents;
    private StudentDao studentDao;
    private StudentDatabase studentDatabase;

    public MyViewModel(@NonNull Application application) {
        super(application);
        studentDatabase = StudentDatabase.getInstance(application);
        studentDao = studentDatabase.getStudentDao();
        allStudents = new LivePagedListBuilder<>(studentDao.queryAllStudents(), 2).build();
    }

    public void insertStudents(Student... students) {
        new InsertAsyncTask(studentDao).execute(students);
    }

    public void clearStudents() {
        new ClearAsyncTask(studentDao).execute();
    }

    public LiveData<PagedList<Student>> getAllStudents() {
        return allStudents;
    }

    static class InsertAsyncTask extends AsyncTask<Student, Void, Void> {
        StudentDao studentDao;

        public InsertAsyncTask(@NonNull StudentDao studentDao) {
            this.studentDao = studentDao;
        }

        protected Void doInBackground(Student... students) {
            studentDao.insertStudent(students);
            return null;
        }
    }

    static class ClearAsyncTask extends AsyncTask<Void, Void, Void> {

        StudentDao studentDao;

        public ClearAsyncTask(StudentDao studentDao) {
            this.studentDao = studentDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            studentDao.deleteAllStudents();
            return null;
        }
    }


}
