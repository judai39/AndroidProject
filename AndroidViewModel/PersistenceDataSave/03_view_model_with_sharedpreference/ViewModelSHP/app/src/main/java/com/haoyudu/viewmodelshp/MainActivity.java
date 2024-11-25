package com.haoyudu.viewmodelshp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import com.haoyudu.viewmodelshp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    MyScoreModel viewModel;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = new ViewModelProvider(this, new SavedStateViewModelFactory(getApplication(), this)).get(MyScoreModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setScoreModel(viewModel);
        binding.setLifecycleOwner(this);
    }
}