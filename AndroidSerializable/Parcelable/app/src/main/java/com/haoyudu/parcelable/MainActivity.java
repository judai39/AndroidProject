package com.haoyudu.parcelable;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import com.haoyudu.parcelable.databinding.ActivityMainBinding;

import java.util.ArrayList;

/**不同于Serializable将文件序列化到本地,其他进程对本地请求资源从而实现对象共享,
 * Parcelable接口的主要作用是将文件序列化后,直接传递给其他进程(这是通过Intent实现的)*/

/**go to manifest ,<activity NextActivity />标签添加了android:process=":process2"
 * 这样操作之后,activity_main携带着intent进行跳转到activity_next时,系统会自动开辟一个新的进程,当然,由于Parcelable
 * 的实现,这样的跳转是可以的,这样,进程间跳转的功能就被验证了
 * 对了,如果想要查看进程详情,可以前往ALT+4区域,点击logcat查看
 * */

public class MainActivity extends AppCompatActivity {

    private Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Score score=new Score(Integer.parseInt(binding.editChineseGrade.getText().toString()),Integer.parseInt(binding.editMathGrade.getText().toString()));
                binding.grade.setText(score.getGrade());
                student=new Student(binding.editName.getText().toString(),Integer.parseInt(binding.editAge.getText().toString()),score);
            }
        });

        /**重写MyApplication进行数据共享
         * Intent intent = new Intent(MainActivity.this, NextActivity.class);
         * MyApplication.student=student;
         * startActivity(intent);
         * */

        binding.gotoNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NextActivity.class);
//                intent.putParcelableArrayListExtra("student_object",new ArrayList<Student>()); Parcelable还可以putArrayList(),可以直接传入所有对象类型,不需要一个个手动put
                Bundle bundle=new Bundle();
                bundle.putParcelable("student_object",student);
                intent.putExtra("student_bundle",bundle);
                startActivity(intent);//前往NextActivity
            }
        });

    }
}