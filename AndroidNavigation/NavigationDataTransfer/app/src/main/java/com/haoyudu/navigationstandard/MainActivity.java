package com.haoyudu.navigationstandard;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.Navigator;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NavController navController =Navigation.findNavController(this,R.id.fragment);
        NavigationUI.setupActionBarWithNavController(this,navController);
    }

    /**该重写方法用以将页面label自定义动作实现返回上一页*/
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController=Navigation.findNavController(this,R.id.fragment);
        return navController.navigateUp();
//        return super.onSupportNavigateUp();
    }

    /**如何在跳转页面同时传递数据?
     * 在navigation文件中的fragment布局中有argument参数,填写后,可以通过重写跳转后页面的onActivityCreated()方法接收
     * 但这样传递的数据是静态数据,在xml文件中预先规定的,如何动态传递数据?
     * --->重写时填入navigate()中的第二个参数,
     * */
}