package com.haoyudu.viewmodeldatabindinganother;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import com.haoyudu.viewmodeldatabindinganother.databinding.ActivityMainBinding;

/**在ViewModelDataBinding中我们是在xml文件中以属性绑定事件(因为在那个项目中我们使用ViewModel存放数据,
 * 是活数据LiveData,不能直接使用死的xml属性进行绑定),但实际上binding是双向绑定,
 * 本例我们尝试在MainActivity中绑定xml中的属性*/

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.textId.setText("dataBinding直接设置属性");
        binding.btnId.setText("dataBinding直接设置属性");
        binding.editId.setText("dataBinding直接设置属性");
        binding.layoutId.setBackgroundColor(getResources().getColor(R.color.teal_700));
    }
}