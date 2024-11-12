package com.haoyudu.roomdatabaseupgrade;

import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn_add, btn_clear, btn_delete, btn_upgrade;
    TextView textView;
    WordViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        viewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(WordViewModel.class);

        viewModel.getAllWordsLive().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                StringBuilder text = new StringBuilder();
                for (int i = 0; i < words.size(); i++) {
                    Word word = words.get(i);
                    text.append(word.getId()).append(":").append(word.getName()).append("=").append(word.getMeaning());
                }
                textView.setText(text);
            }
        });
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word1 = new Word("Hello", "你好");
                Word word2 = new Word("World", "世界");
                viewModel.insertWord(word1, word2);
            }
        });
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word = new Word("", "");
                word.setId(40);
                viewModel.deleteWord(word);
            }
        });
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.clearWord();
            }
        });
        btn_upgrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word = new Word("rewrite", "重写");
                word.setId(10);
                viewModel.upgradeWord(word);
            }
        });
    }

    void init() {
        btn_add = findViewById(R.id.btn_add);
        btn_clear = findViewById(R.id.btn_clear);
        btn_delete = findViewById(R.id.btn_delete);
        btn_upgrade = findViewById(R.id.btn_update);
        textView = findViewById(R.id.data_text);
    }


}


