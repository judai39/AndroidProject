package com.haoyudu.roomcrud

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.haoyudu.roomcrud.adapter.StudentAdapter
import com.haoyudu.roomcrud.dao.StudentDao
import com.haoyudu.roomcrud.entity.Student
import kotlinx.android.synthetic.main.activity_main.*

class
MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}