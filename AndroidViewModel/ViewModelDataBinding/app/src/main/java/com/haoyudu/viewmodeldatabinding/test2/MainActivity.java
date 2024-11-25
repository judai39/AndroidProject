package com.haoyudu.viewmodeldatabinding.test2;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import com.haoyudu.viewmodeldatabinding.R;
import com.haoyudu.viewmodeldatabinding.databinding.TestActivityBinding;


public class MainActivity extends AppCompatActivity {
    MyViewModelNum viewModelNum;
//    TextView textView;
//    Button btn;
//    ActivityMainBinding binding;
    TestActivityBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=DataBindingUtil.setContentView(this, R.layout.test_activity);
        /**在主文件夹下,可以访问到MyViewModelNum.class*/
        viewModelNum=ViewModelProviders.of(this).get(MyViewModelNum.class);

        binding.setData(viewModelNum);
        binding.setLifecycleOwner(this);
    }
}
