package com.haoyudu.pagingdatastandard;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.loader.content.AsyncTaskLoader;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.haoyudu.pagingdatastandard.adapter.MyPagedAdapter;
import com.haoyudu.pagingdatastandard.dao.StudentDao;
import com.haoyudu.pagingdatastandard.database.StudentDatabase;
import com.haoyudu.pagingdatastandard.student.Student;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Button btn_add,btn_clear;
    StudentDao studentDao;
    StudentDatabase studentDatabase;
    MyPagedAdapter myPagedAdapter;
    LiveData<PagedList<Student>> pagedListLiveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studentDatabase=StudentDatabase.getInstance(this);
        studentDao=studentDatabase.getStudentDao();
        recyclerView=findViewById(R.id.recyclerView);
        btn_add=findViewById(R.id.btn_add);
        btn_clear=findViewById(R.id.btn_clear);
        myPagedAdapter=new MyPagedAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(myPagedAdapter);
        /**以下泛型的填写我们在adapter的构造器中已经约束过,不需要填写*/
        pagedListLiveData=new LivePagedListBuilder<>(studentDao.queryStudents(),20).build();

        pagedListLiveData.observe(this, new Observer<PagedList<Student>>() {
            @Override
            public void onChanged(PagedList<Student> students) {
                myPagedAdapter.submitList(students);
                //以下代码仅打印信息用以观察paging的变化
                students.addWeakCallback(null, new PagedList.Callback() {
                    @Override
                    public void onChanged(int i, int i1) {
                        Log.d("myLog--","onChanged:--"+students);
                    }

                    @Override
                    public void onInserted(int i, int i1) {

                    }

                    @Override
                    public void onRemoved(int i, int i1) {

                    }
                });
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**在以下区域创建student实例后,系统会自动以实例对象自动实现studentDao抽象类(StudentDatabase.getStudentDao())*/
                Student[] students=new Student[1000];
                for (int i=0;i<students.length;i++){
                    Student student = new Student();
                    student.setStudentNumber(i);
                    students[i]=student;
                }
                new InsertAsyncTask(studentDao).execute(students);
            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DeleteAllAsyncTask(studentDao).execute();
            }
        });
    }


    static class QueryAsyncTask extends AsyncTask<Void,Void,DataSource.Factory<Integer,Student>>{
        StudentDao studentDao;

        public QueryAsyncTask(StudentDao studentDao){
            this.studentDao=studentDao;
        }

        @Override
        protected DataSource.Factory<Integer,Student> doInBackground(Void... voids) {
            DataSource.Factory<Integer,Student> allStudents=studentDao.queryStudents();
            return allStudents;
        }
    }

    static class InsertAsyncTask extends AsyncTask<Student,Void,Void> {
        StudentDao studentDao;

        public InsertAsyncTask(StudentDao studentDao){
            this.studentDao=studentDao;
        }

        @Override
        protected Void doInBackground(Student... students) {
            studentDao.insertStudent(students);
            return null;
        }
    }

    static class DeleteAllAsyncTask extends AsyncTask<Void,Void,Void>{
        StudentDao studentDao;

        public DeleteAllAsyncTask(StudentDao studentDao){
            this.studentDao=studentDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            studentDao.deleteAllStudents();
            return null;
        }
    }
}