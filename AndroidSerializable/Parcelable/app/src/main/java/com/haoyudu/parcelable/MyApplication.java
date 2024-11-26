package com.haoyudu.parcelable;

import android.app.Application;

/**进程间通信的实现,除了通过intent相互传递还能怎样实现?
 *  --从创建实例对象开始就存在有相同的成员-->重写Application(添加成员,这样继承了Application就等于共享了成员)
 * */
public class MyApplication extends Application {
    Student student;
    /**前往manifest中为<application/>添加android:name=".MyApplication"属性
     * 同时将android:process:process2注销
     * */
}
