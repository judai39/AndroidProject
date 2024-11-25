package com.haoyudu.test1;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import com.haoyudu.viewmodeldatabinding.R;
import com.haoyudu.viewmodeldatabinding.databinding.TestOuterActivityBinding;


public class MainActivity extends AppCompatActivity {
    ViewModelTest viewModelTest;
//    TextView textView;
//    Button btn;
    TestOuterActivityBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=DataBindingUtil.setContentView(this, R.layout.test_outer_activity);
        /**和主文件夹不在同一分级,无法访问到ViewModelTest.class*/
//        viewModelTest=ViewModelProviders.of(this).get(ViewModelTest.class);
        binding.setData(viewModelTest);
        binding.setLifecycleOwner(this);
    }
}
