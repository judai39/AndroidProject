package com.haoyudu.roomcrud.dao

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.os.Build
import androidx.annotation.RequiresApi
import com.haoyudu.roomcrud.entity.Student
import com.haoyudu.roomcrud.util.DBHelper

class StudentDao @RequiresApi(Build.VERSION_CODES.P) constructor(context: Context) {
    var helper:DBHelper = DBHelper(context)
    private val database: SQLiteDatabase =helper.writableDatabase

    //插入数据
    fun insert(name:String,classmate:String,age:Int){
        val values=ContentValues()
        values.put("name",name)
        values.put("classmate",classmate)
        values.put("age",age)
        database.insert("student_tbl",null,values)
        database.close()
    }

    //修改学生名称
    fun updateName(name:String,toUpgrade:String){
        val values=ContentValues()
        values.put("name",toUpgrade)
        database.update("student_tbl",values,"name=?", arrayOf(name))
        database.close()
    }

    //修改学生年龄
    fun updateAge(age:String,toUpgrade:String){
        val values=ContentValues()
        values.put("age",toUpgrade)
        database.update("student_tbl",values,"age=?", arrayOf(age))
        database.close()
    }

    //删除数据
    fun delete(id:Int){
        database.delete("student_tbl","id=?", arrayOf(id.toString()))
        database.close()
    }

    //查询指定用户
    fun queryStudent(id:Int): Student {
        val readableDatabase=helper.readableDatabase
        val cursor=readableDatabase.query("student_tbl",null,"id=?", arrayOf("$id"),null,null,null)
        var student=Student()
        while (cursor.moveToNext()){
            student=Student(cursor.getString(1),cursor.getString(2),cursor.getString(3).toInt())
            student.id=id
        }
        database.close()
        cursor.close()
        return student
    }

    //查询所有数据
    fun queryAll():List<Student>{
        val students= mutableListOf<Student>()
        val readableDatabase=helper.readableDatabase
        val cursor=readableDatabase.query("student_tbl",null,null,null,null,null,null)
        while (cursor.moveToNext()){
            val student=Student(cursor.getString(1),cursor.getString(2),cursor.getString(3).toInt())
            student.id=cursor.getString(0).toInt()
            students.add(student)
        }
        database.close()
        cursor.close()
        return students
    }
}