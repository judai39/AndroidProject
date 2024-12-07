package com.haoyudu.viewpagerfirst

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //实例化ViewPager
        view_page_id.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int {
                return 3
            }

            override fun createFragment(position: Int) =
                when (position) {
                    0 -> RotateFragment()
                    1 -> ScaleFragment()
                    else -> TranslateFragment()
                }
        }
        //初始化值
        TabLayoutMediator(table_layout_id,view_page_id){
                tab,position->
            when(position){
                0->tab.text="旋转"
                1->tab.text="缩放"
                else->tab.text="移动"
            }
        }.attach()
    }
}