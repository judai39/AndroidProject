package com.haoyudu.kotlindatabase

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_adapter.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.btn_add
import kotlinx.android.synthetic.main.activity_main.btn_clear
import kotlinx.android.synthetic.main.activity_main.mean_edit
import kotlinx.android.synthetic.main.activity_main.word_edit

class MainActivity : AppCompatActivity() {
    lateinit var wordDatabase: WordDatabase
    lateinit var dao: WordDao
    lateinit var viewModel: MyViewModel
    lateinit var myAdapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adapter)

        viewModel.getAllWords().observe(this, Observer {
            myAdapter.setWordsAll(it)
            myAdapter.notifyDataSetChanged()
        })

        btn_add.setOnClickListener {
            if (mean_edit == null && word_edit == null) {
                if (mean_edit) Toast.makeText(this, "请输入单词", Toast.LENGTH_SHORT).show()
                if (word_edit) Toast.makeText(this, "请输入注解", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.insert(Word(mean_edit.text.toString(), word_edit.text.toString()))
            }

        }
        btn_clear.setOnClickListener {
            viewModel.clearAllWords()
        }

        //初始化对象数据
        fun init(){
            wordDatabase= Room.databaseBuilder(applicationContext,WordDatabase::class.java,"word_database").build()
            dao=wordDatabase.getDao()
            //由于kotlin可以传递函数类型,因此ViewModelProvider传入参数时不必在传入owner(直接调用实例化的ViewModelProvider成员)
            viewModel=ViewModelProvider.AndroidViewModelFactory(this.application).create(MyViewModel::class.java)
            myAdapter= MyAdapter(this.applicationContext)
            recycle_view.layoutManager = LinearLayoutManager(this)
            recycle_view.adapter=myAdapter
        }
    }
}