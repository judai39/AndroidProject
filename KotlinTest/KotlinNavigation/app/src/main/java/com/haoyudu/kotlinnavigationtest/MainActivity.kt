package com.haoyudu.kotlinnavigationtest

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.icon_fragment_first.*
import kotlinx.android.synthetic.main.icon_fragment_second.*
import kotlinx.android.synthetic.main.icon_fragment_third.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //kotlin
        var navController: NavController =
            supportFragmentManager.findFragmentById(R.id.fragment)?.findNavController() as NavController
//        NavigationUI.setupActionBarWithNavController(this,navController)


        first_icon.setOnClickListener {
            navController.navigate(R.id.first_fragment)
        }
        second_icon.setOnClickListener {
            navController.navigate(R.id.second_fragment)
        }
        third_icon.setOnClickListener {
            navController.navigate(R.id.third_fragment)
        }

    }
}