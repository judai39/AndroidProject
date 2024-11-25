package com.haoyudu.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class PreferencesHelper {

    //因为MainActivity类是一个实例化后的对象,它可以访问到的成员都是开发者定义好,才能访问到的,我们这个工具类与它没有关系
    //怎么样才能将逻辑转移到这里?
    //参数查询思想-->将实例化的对象的编译类型传入工具类,工具类根据编译类型进行参数的初始化,最后只需要在实例化对象中调用
    //工具类并将编译类型参数传入即可

    private Context context;
    private SharedPreferences sharedPreferences;

    public PreferencesHelper(Context context){
        this.context=context;
    }

    void save(String id,int storeValue){
        sharedPreferences= context.getSharedPreferences("MyData",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //在书写如下代码时,编译器推荐我改成SharedPreferences.Editor editor1 =
        // editor.putString(R.string.string_key, R.string.string_key);  可以看出Editor是一个以String为成员的内部类,用来生成xml文件的

//        editor.putString(R.string.string_key, R.string.string_key)
        editor.putInt(id,storeValue);
        editor.apply();
    }

    void print(String id){
        int print_int=sharedPreferences.getInt(id,R.integer.def_num);
        Log.d("MyLog","oncreate print shared preferences"+print_int);
    }


}
