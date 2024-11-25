package com.haoyudu.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import static java.lang.reflect.Array.getInt;

public class MainActivity extends AppCompatActivity {
    /**如何永久保存信息--->换句话说,如何永久的存放一个对象的实例成员
     *      -->下载到本地
     *
     * */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        //存放数据至根目录
//        //getPreferences()与getSharedPreferences()的区别，可以查看笔记\android,
//        // 简单来说就是前者只有所在的activity实例可以访问，后者可以指定实例访问
//        SharedPreferences sharedPreferences=getPreferences(Context.MODE_PRIVATE);
////        SharedPreferences sharedPreferences=getSharedPreferences("string_data",MODE_PRIVATE);
//        SharedPreferences.Editor editor=sharedPreferences.edit();
//        editor.putInt("NUMBER",100);
//        editor.apply();
//        //打开右侧侧边栏的AndroidEmulator.
//
//       //获取根目录数据
//        int num=sharedPreferences.getInt("NUMBER",/*缺省值*/R.integer.integer_key);//import static java.lang.reflect.Array.getInt;注意看导入的包是java中的反射类
//        String Tag="MyTag";
//        Log.d(Tag,"ONCREATE"+num);

        /**如何把上面一大串的代码塞到另一个工具类中？
         * -->创建PreferencesHelper类
         * */

        //创建完成,尝试调用
        /**new PreferencesHelper(this); 不要这样直接让工具类传入一个activity实例,因为activity实例在项目中
         * 总是会不断的创建,销毁,这样会让工具类随着新的布局文件不断的创建新的实例并指向自身,会导致内存泄露
         * 正确的方式是直接传入最高级别的实例对象*/
        PreferencesHelper helper=new PreferencesHelper(getApplicationContext());
        helper.save("id1",1);
        helper.print("id1");
    }
}