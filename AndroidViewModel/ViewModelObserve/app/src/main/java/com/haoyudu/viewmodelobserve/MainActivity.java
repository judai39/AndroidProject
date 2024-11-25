package com.haoyudu.viewmodelobserve;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity {

    ViewModelWithLiveData viewModelWithLiveData;
    TextView textView;
    ImageButton imageButton1,imageButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        viewModelWithLiveData=ViewModelProviders.of(this).get(ViewModelWithLiveData.class);
        //为getLikedNum(被观察者，观察逻辑)方法添加观察者
        viewModelWithLiveData.getLikedNum().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                textView.setText(String.valueOf(integer));
            }
        });

        //点击按钮时调用model层中的addLikedNum()
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModelWithLiveData.addLikedNum(1);
            }
        });

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModelWithLiveData.addLikedNum(-1);
            }
        });
    }

    void init(){
        textView=findViewById(R.id.textView);
        imageButton1=findViewById(R.id.imageButton1);
        imageButton2=findViewById(R.id.imageButton2);
    }
}