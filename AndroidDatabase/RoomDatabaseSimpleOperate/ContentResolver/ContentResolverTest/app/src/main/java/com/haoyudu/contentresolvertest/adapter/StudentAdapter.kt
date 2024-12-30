package com.haoyudu.contentresolvertest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.haoyudu.contentresolvertest.R
import com.haoyudu.contentresolvertest.entity.Student

import kotlinx.android.synthetic.main.cell_student.view.*

class StudentAdapter: RecyclerView.Adapter<StudentAdapter.MyViewHolder>() {
    private var students = listOf<Student>()

    fun getStudents():List<Student> = students
    fun setStudents(studentList:List<Student>){students=studentList}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cell_student,parent,false))
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val student=students[position]
        holder.itemView.apply {
            student_id.text="${student.id}"
            student_age.text="${student.age}"
            student_classmate.text= student.classmate
            student_name.text=student.name
            setOnClickListener{
                if (myOnItemClickListener!=null){
                    myOnItemClickListener.onItemClickListener(it,position)
                }
            }
            background=resources.getDrawable(R.drawable.item_selector)
        }
    }

    override fun getItemCount(): Int {
        return students.size
    }

    //设置item单击回调接口
    interface OnItemClickListener{fun onItemClickListener(view:View,position: Int)}

    private lateinit var myOnItemClickListener:OnItemClickListener

    /**实例化adapter后重写该方法的逻辑*/
    fun setOnItemClickListener(onItemClickListener: OnItemClickListener){
        myOnItemClickListener=onItemClickListener
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
