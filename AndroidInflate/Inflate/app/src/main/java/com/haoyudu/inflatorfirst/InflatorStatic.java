package com.haoyudu.inflatorfirst;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import android.os.Bundle;

/** 三种加载inflater的方式
 *  LayoutInflater inflater1 = LayoutInflater.from(this);
    LayoutInflater inflater2 = getLayoutInflater();
    LayoutInflater inflater3 = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
 * */

public class InflatorStatic extends Activity {

    /**父容器未主动指定(没有setContent()),需要设置LayoutInflater指定父类容器信息*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button btnOne = new Button(this);
        btnOne.setText("我是动态添加的按钮");

        RelativeLayout.LayoutParams layout_parameter = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layout_parameter.addRule(RelativeLayout.CENTER_IN_PARENT);
        LayoutInflater inflater = LayoutInflater.from(this);
        LinearLayout layout = inflater.inflate(
                //指定父类容器信息
                R.layout.static_activity_main, null)
                .findViewById(R.id.linear_layout_id);
        layout.addView(btnOne,layout_parameter);
        setContentView(layout);
    }


    /**父容器主动指定,无需LayoutInflater*/
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        //这里提前声明号父类容器
//        setContentView(R.layout.static_activity_main);
//        Button btn=new Button(this);
//        btn.setText("我是动态添加的按钮");
//        //子类视图
//        RelativeLayout.LayoutParams layout_parameter=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        layout_parameter.addRule(RelativeLayout.CENTER_IN_PARENT);
//        //因为已经声明,可以通过id查找预先加载好的布局文件activity_main
//        LinearLayout layout=findViewById(R.id.linear_layout_id);
//        layout.addView(btn,layout_parameter);
//    }
}