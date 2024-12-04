package com.haoyudu.roomdatabaseupgrade;

import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn_add, btn_clear;
    WordViewModel viewModel;
    MyAdapter myAdapter;
    RecyclerView recyclerView;
    Switch aSwitch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        viewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(WordViewModel.class);

        viewModel.getAllWordsLive().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                /***/
                myAdapter.setWordsAll(words);
                myAdapter.notifyDataSetChanged();/**提醒database,数据已刷新*/
            }
        });
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] english = {"android", "english", "study"};
                String[] chinese = {"安卓", "中文", "学习"};
                for (int i = 0; i < english.length; i++) {
                    Word word = new Word(english[i], chinese[i]);
                    viewModel.insertWord(word);
                }
            }
        });
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.clearWord();
            }
        });

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                myAdapter.setCardMode(isChecked);
                recyclerView.setAdapter(myAdapter);

            }
        });
    }

    void init() {
        btn_add = findViewById(R.id.btn_add);
        btn_clear = findViewById(R.id.btn_clear);
        myAdapter = new MyAdapter();
        myAdapter.setCardMode(false);
        aSwitch = findViewById(R.id.switch_mode);
        recyclerView = findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));//当前适配列表为线性一维,所以实例化参数为Linear,如果是表格类型的,要实例化GridLayoutManager
        recyclerView.setAdapter(myAdapter);
    }


}


