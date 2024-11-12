package com.haoyudu.roomdatabase;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.room.Room;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    WordDataBase wordDataBase;
    WordDao wordDao;
    Button btn_add,btn_clear,btn_delete,btn_upgrade;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word1=new Word("Hello","你好");
                Word word2=new Word("World","世界");
                wordDao.insertWords(word1,word2);
                upgradeView();
            }
        });
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word=new Word("","");
                word.setId(11);
                wordDao.deleteWords(word);
                upgradeView();
            }
        });
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wordDao.deleteAllWords();
                upgradeView();
            }
        });
        btn_upgrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word=new Word("rewrite","重写");
                word.setId(10);
                wordDao.updateWords(word);
                upgradeView();
            }
        });
    }

    void upgradeView(){
        List<Word> wordList=wordDao.queryWords();
        StringBuilder text= new StringBuilder();
        for (Word word:wordList){
            text.append(word.getId()).append(":").append(word.getName()).append("=").append(word.getMeaning());
        }
        textView.setText(text);
    }
    void init(){
        wordDataBase= Room.databaseBuilder(this,WordDataBase.class,"database").allowMainThreadQueries().build();
        wordDao=wordDataBase.getWordDao();
        btn_add=findViewById(R.id.btn_add);
        btn_clear=findViewById(R.id.btn_clear);
        btn_delete=findViewById(R.id.btn_delete);
        btn_upgrade=findViewById(R.id.btn_update);
        textView=findViewById(R.id.data_text);
    }
}