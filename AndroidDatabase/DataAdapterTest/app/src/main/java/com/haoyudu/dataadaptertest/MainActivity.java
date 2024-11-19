package com.haoyudu.dataadaptertest;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.haoyudu.dataadaptertest.adapter.WordAdapter;
import com.haoyudu.dataadaptertest.model.MyViewModel;
import com.haoyudu.dataadaptertest.word.Word;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Button addButton, clearButton, deleteButton, deleteLatestButton;
    EditText addWordEditText, addMeaningEditText, deleteEditText;
    MyViewModel myViewModel;
    WordAdapter wordAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


        myViewModel.getAllWords().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
//                String text = "";
//                for (int i = 0; i < words.size(); i++) {
//                    Word word = words.get(i);
//                    text += word.getWord() + "\t" + word.getMeaning() + "\n";
//                }
//                textView.setText(text);
                wordAdapter.setAllWords(words);
                wordAdapter.notifyDataSetChanged();
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!addWordEditText.getText().toString().isEmpty() && !addMeaningEditText.getText().toString().isEmpty()) {
                    Word word = new Word(addWordEditText.getText().toString(), addMeaningEditText.getText().toString());
                    myViewModel.insertWords(word);
                } else {
                    if (addWordEditText == null) {
                        Toast.makeText(MainActivity.this, "请输入您要插入的单词", Toast.LENGTH_SHORT).show();
                    }
                    if (addMeaningEditText == null) {
                        Toast.makeText(MainActivity.this, "请输入您插入单词的意思", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.clearWords();
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toDelWord=deleteEditText.getText().toString();
                if (!toDelWord.isEmpty()) {
                    if(myViewModel.wordIsHave(toDelWord)){
                        Word word= myViewModel.queryWord(toDelWord);
                        myViewModel.deleteWord(word);
                    }else{
                        Toast.makeText(MainActivity.this, "没有这个单词", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "请输入要删除的单词", Toast.LENGTH_SHORT).show();
                }
            }
        });

        deleteLatestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!myViewModel.getAllWords().getValue().isEmpty()) {
                    myViewModel.deleteWordLatest();
                }else{
                    Toast.makeText(MainActivity.this, "列表为空", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    void init(){
        myViewModel=new ViewModelProvider(this,new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(MyViewModel.class);
        recyclerView=findViewById(R.id.view_recycler_id);
        addButton = findViewById(R.id.add_word_btn);
        clearButton = findViewById(R.id.clear_word_btn);
        deleteButton = findViewById(R.id.delete_word_btn);
        deleteLatestButton = findViewById(R.id.delete_latest_btn);
        addWordEditText = findViewById(R.id.add_word_edit);
        addMeaningEditText = findViewById(R.id.add_meaning_edit);
        deleteEditText = findViewById(R.id.delete_edit);
        wordAdapter=new WordAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(wordAdapter);
    }

}