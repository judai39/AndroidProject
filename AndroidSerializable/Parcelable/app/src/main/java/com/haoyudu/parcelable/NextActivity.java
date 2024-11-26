package com.haoyudu.parcelable;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import com.haoyudu.parcelable.databinding.ActivityMainBinding;
import com.haoyudu.parcelable.databinding.ActivityNextBinding;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityNextBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_next);
        Intent intent = getIntent();

        /**重写Application后进行数据传递
         * MyApplication myApplication=(MyApplication) getApplication();
         * Student student=myApplication.student;
         * binding.textName.setText(student.getName());
         *binding.textAge.setText(String.valueOf(student.getAge()));
         *binding.textGrade.setText(student.getScore().getGrade());
         *binding.textChinese.setText(String.valueOf(student.getScore().getChinese()));
         *binding.textMath.setText(String.valueOf(student.getScore().getMath()));
         * */

        Bundle bundle = intent.getBundleExtra("student_bundle");
        Student student = bundle.getParcelable("student_object");
        binding.textName.setText(student.getName());
        binding.textAge.setText(String.valueOf(student.getAge()));
        binding.textGrade.setText(student.getScore().getGrade());
        binding.textChinese.setText(String.valueOf(student.getScore().getChinese()));
        binding.textMath.setText(String.valueOf(student.getScore().getMath()));
    }
}