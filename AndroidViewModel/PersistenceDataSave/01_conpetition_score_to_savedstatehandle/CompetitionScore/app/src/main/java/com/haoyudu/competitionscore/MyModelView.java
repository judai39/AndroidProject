package com.haoyudu.competitionscore;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;


public class MyModelView extends ViewModel {

    private SavedStateHandle handle;


    /**如何实现回退功能? --->  如何持久化保存数据?
     * 以原本的理解,在java中,实现持久话保存数据的核心是,在目标类中设置一个与之相同类型的数据,并对其进行维护
     * 但是在android中,可重写的方法,如果想要实现调用要先初始化,以如下两种方法实例化?
     * 第一种会栈溢出,因为实例化对象会一直进行实例化
     * 第二种系统不允许,ModelView不允许自己的实例化,仅能静态调用
     *
     *
     * ----->添加依赖   androidx.lifecycle:lifecycle-viewmodel-savedstate:1.0.0-alpha01
     * 新版本的ModelView多了可以实例化的构造器,并且携带了一个可以传递数据的参数SavedStateHandel,可以以此对数据进行持续化保存
     * */


    public MyModelView(SavedStateHandle handle){
        this.handle=handle;
    }


    public MutableLiveData<Integer> getScore_red(){
        if (!handle.contains(MainActivity.KEY_NUM_RED)){
            handle.set(MainActivity.KEY_NUM_RED,0);
        }
        return handle.getLiveData(MainActivity.KEY_NUM_RED);
    }

    public void addOneRedPoint(){
        getScore_red().setValue(getScore_red().getValue()+1);
    }

    public void addTwoRedPoint(){
        getScore_red().setValue(getScore_red().getValue()+2);
    }

    public void addThreeRedPoint(){
        getScore_red().setValue(getScore_red().getValue()+3);
    }


    public MutableLiveData<Integer> getScore_blue(){

        if (!handle.contains(MainActivity.KEY_NUM_BLUE)){
            handle.set(MainActivity.KEY_NUM_BLUE,0);
        }
        return handle.getLiveData(MainActivity.KEY_NUM_BLUE);
    }

    public void addOneBluePoint(){
        getScore_blue().setValue(getScore_blue().getValue()+1);
    }

    public void addTwoBluePoint(){
        getScore_blue().setValue(getScore_blue().getValue()+2);
    }

    public void addThreeBluePoint(){
        getScore_blue().setValue(getScore_blue().getValue()+3);
    }

    public void refresh(){

    }

    public void backspace(){
    }
}
