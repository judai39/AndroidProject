package com.haoyudu.gallerytest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //设置导航返回事件为返回上一页面
        NavigationUI.setupActionBarWithNavController(this,findNavController(R.id.fragment))
    }

    /**重写导航返回事件*/
    override fun onSupportNavigateUp(): Boolean {
        return super.onSupportNavigateUp()||findNavController(R.id.fragment).navigateUp()
    }
}