package com.haoyudu.json;

import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    /**new一个json文件(ctrl+alt+shift+insert)生成一个scratch file
     * (该文件类似于草稿纸,不被项目计入,在项目结构的最末端的Scratches and Consoles中找到)*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**使用Gson库,自定义对象生成json文件*/
        Student student = new Student("david", 20,new Score(80,80));
        Gson gson=new Gson();
        String str = gson.toJson(student);//在此断点,debug后查看debug中的str值,进行复制

        /**使用Gson库,自定义str生成对象实例*/
//        String str="Student{name='david', age=20.0, score=Score{chinese_score=80.0, math_score=80.0}}";
//        Gson gson = new Gson();
//        Student student=gson.fromJson(str,Student.class);
//        Log.e(student.toString(),"student");

        /**尝试对List进行toJson处理*/
//        List<Student> studentList=new ArrayList<>();
//        studentList.add(student);
//        Gson gson = new Gson();
//        String str=gson.toJson(studentList);

        /**尝试对包含List的json([{...}]进行fromJson处理)*/
//        String str="[Student{name='david', age=20.0, score=Score{chinese_score=80.0, math_score=80.0}}]";
//        Gson gson = new Gson();
////        Student student1=gson.fromJson(str,List<Student>);
//        /*报错了,为了使用泛型约束必须传入一个编译类型,但是目标编译类型(List<Student>)的泛型构造依旧向我们所求着实例化,
//            这是无法做到的,只能使用反射去获取一个自定义的编译类型了(这是java中的一个巨大缺陷)
//        * */
//        Type studentListType=new TypeToken<List<Student>>(){}.getType();    //实例化一个包含这List<Student>实例对象的类TypeToken,调用getType()传回List<Student>约束类型
//        Student student1=gson.fromJson(str,studentListType);
    }
}