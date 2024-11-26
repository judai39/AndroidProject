package com.haoyudu.extendsapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    /**进程间通信的实现,除了通过intent相互传递还能怎样实现?
     *  --从创建实例对象开始就存在有相同的成员-->重写Application(添加成员,这样继承了Applicationi就等于共享了成员)
     * */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}