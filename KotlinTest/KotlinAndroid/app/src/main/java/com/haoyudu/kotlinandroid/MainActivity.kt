package com.haoyudu.kotlinandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel=ViewModelProvider.AndroidViewModelFactory(this.application).create(MyViewModel::class.java)
        viewModel.number.observe(this, Observer { num_text.text=it.toString() })
        btn_add.setOnClickListener{
            viewModel.modifyNumber(1)
        }
        btn_subtract.setOnClickListener{
            viewModel.modifyNumber(-1)
        }
    }
}