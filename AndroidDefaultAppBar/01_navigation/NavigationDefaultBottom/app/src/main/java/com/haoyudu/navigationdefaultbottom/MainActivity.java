package com.haoyudu.navigationdefaultbottom;

import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        //创建一个空的appbar应用组件框架(以MenuView作为参数)
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                navView.getMenu())
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        //创建NavigationUI对象
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

}