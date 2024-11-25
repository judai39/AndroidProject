package com.haoyudu.viewmodeldatabinding;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import com.haoyudu.viewmodeldatabinding.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    ViewModelNum viewModelNum;
//    TextView textView;
//    Button btn;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModelNum=ViewModelProviders.of(this).get(ViewModelNum.class);
        binding.setData(viewModelNum);
        binding.setLifecycleOwner(this);
    }
}
