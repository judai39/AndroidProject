package com.haoyudu.serializable;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.io.*;

/**序列化的目的:在第二次处理相同的代码时,想要获取第一次处理代码时的某个对象,这时就需要对第一次处理的代码进行
 * 序列化,将我们想要的目标对象处理为文件以便于我们第二次读取*/

public class MainActivity extends AppCompatActivity {

    //为什么需要版本号(当我们在改变类的结构后,改变结构前生成的文件就会读取不了,因为每一次修改就意味着
    // 重新生成一个默认的新的版本号(一个随机的long值,这是由系统生成的))
    //但如果我们人为指定一个版本号,系统将不会随机生成,会一直使用这个版本号,


    EditText editText1,editText2,editText3,editText4;
    Button save_btn,load_btn;
    TextView score_text;
    String FILE_NAME="student_object";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();



        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=editText1.getText().toString();
                int age=Integer.parseInt(editText2.getText().toString());
                int chinese=Integer.parseInt(editText3.getText().toString());
                int math=Integer.parseInt(editText4.getText().toString());
                Score score=new Score(chinese,math);
                score_text.setText(score.getGrade());
                /**待存取的对象student*/
                Student student=new Student(name,age,score);
                try {
                    ObjectOutputStream objectOutputStream=new ObjectOutputStream(openFileOutput(FILE_NAME,MODE_PRIVATE));
                    objectOutputStream.writeObject(student);
                    objectOutputStream.flush();
                    objectOutputStream.close();
                    Toast.makeText(MainActivity.this, "Data Save Complete!", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Log.e("my_tag","save_onClick",e);
                }
            }
        });
        load_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    ObjectInputStream objectInputStream = new ObjectInputStream(openFileInput(FILE_NAME));
                    Student student=(Student)objectInputStream.readObject();
                    editText1.setText(student.getName());
                    editText2.setText(String.valueOf(student.getAge()));
                    editText3.setText(String.valueOf(student.getScore().getChinese()));
                    editText4.setText(String.valueOf(student.getScore().getMath()));
                    score_text.setText(student.getScore().getGrade());
                } catch (IOException | ClassNotFoundException e) {
                    Log.e("my_log","load_onClick",e);
                }
            }
        });
    }

    void init(){
        editText1=findViewById(R.id.editTextPersonName1);
        editText2=findViewById(R.id.editTextTextPersonName2);
        editText3=findViewById(R.id.editTextTextPersonName3);
        editText4=findViewById(R.id.editTextTextPersonName4);
        load_btn=findViewById(R.id.btn_load);
        save_btn=findViewById(R.id.btn_save);
        score_text=findViewById(R.id.grade);
    }
}

