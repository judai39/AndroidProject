package com.haoyudu.myapplication;

import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.haoyudu.myapplication.adapter.MyAdapter;
import com.haoyudu.myapplication.student.Student;
import com.haoyudu.myapplication.view_model.MyViewModel;



public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Button add_btn,clear_btn;
    MyAdapter adapter;

    MyViewModel myViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        myViewModel.getAllStudents().observe(this,new Observer<PagedList<Student>>() {
            @Override
            public void onChanged(PagedList<Student> students) {
                adapter.submitList(students);
            }
        });

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student[] students=new Student[100];
                for(int i=0;i<students.length;i++){
                    students[i]=new Student(i);
                }
                myViewModel.insertStudents(students);
            }
        });

        clear_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.clearStudents();
            }
        });
    }
    void init(){
        add_btn=findViewById(R.id.add_btn);
        clear_btn=findViewById(R.id.clear_btn);
        adapter=new MyAdapter();
        recyclerView=findViewById(R.id.recycle_view);
        /**实例化我们重写后,可以处理提交,修改线程异常的LinearLayoutManager类*/
        recyclerView.setLayoutManager(new WrapContentLinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
        myViewModel=new ViewModelProvider(this,new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(MyViewModel.class);

    }
}