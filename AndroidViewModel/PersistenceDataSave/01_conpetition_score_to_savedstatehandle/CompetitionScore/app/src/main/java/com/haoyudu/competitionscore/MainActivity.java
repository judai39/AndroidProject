package com.haoyudu.competitionscore;

import android.os.PersistableBundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import com.haoyudu.competitionscore.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    MyModelView myModelView;
    ActivityMainBinding binding;
    public static final String KEY_NUM_RED="red_kata";
    public static final String KEY_NUM_BLUE="blue_kata";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ViewModelProviders()已经弃用,现已整合到了ViewModelProvider()中
        myModelView = new ViewModelProvider(this,new SavedStateViewModelFactory(getApplication(),this)).get(MyModelView.class);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.setMyModelView(myModelView);
        binding.setLifecycleOwner(this);
    }




}