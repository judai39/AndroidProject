package com.haoyudu.roomcrud.dao

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import com.haoyudu.contentresolvertest.entity.Student

class StudentDao(context: Context) {

    private val CONTENT_URL="content://com.haoyudu.roomcrud/student"
    private var context: Context? = context

    fun insert(student:Student){
        val uri= Uri.parse(CONTENT_URL)
        val values=ContentValues()
        values.put("name",student.name)
        values.put("classmate",student.classmate)
        values.put("age",student.age)
        context?.contentResolver?.insert(uri, values)
    }

    fun update(student: Student){
        val uri=Uri.parse("$CONTENT_URL/${student.id}")
        val values=ContentValues()
        values.put("name",student.name)
        values.put("classmate",student.classmate)
        values.put("age",student.age)
        context?.contentResolver?.update(uri,values,null,null)
    }

    //删除数据
    fun delete(id:Int){
        val uri=Uri.parse("$CONTENT_URL/${id}")
        context?.contentResolver?.delete(uri,null,null)
    }

    //查询所有数据
    fun queryAll():List<Student>{
        val students= mutableListOf<Student>()
        val uri=Uri.parse(CONTENT_URL)
        val cursor= context?.contentResolver?.query(uri,null,null,null,null)
        if (cursor != null) {
            while (cursor.moveToNext()){
                val student=Student(cursor.getString(1),cursor.getString(2),cursor.getString(3).toInt())
                student.id=cursor.getString(0).toInt()
                students.add(student)
            }
        }
        cursor?.close()
        return students
    }
}