package com.haoyudu.inflatorfirst;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

public class InflatorWithRoot extends Activity {
    private ConstraintLayout son,parent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.root_activity_one);

        LayoutInflater inflater=getLayoutInflater();
        /**inflate传递仅传递布局类(Layout),不传递有父类容器的静态控件,因为无法在不实例化子类容器的情况下
         * 访问到它的属性(但是动态控件可以访问到,例如Button btn=new Button();因为这些控件本质上是
         * 在本例中创建的对象)*/
//        son=inflater.inflate(R.layout.root_activity_two,null,false)
//                .findViewById(R.id.root_activity_two_text);       访问text成员,不行

        /**对下面的root false轮流更换数据测试*/
//        son=inflater.inflate(R.layout.root_activity_two,null,false)
//                .findViewById(R.id.root_activity_two_id);       //访问root_activity_two本身,可以

        /**子布局按照父布局的格式,仅将第一个元素添加给父布局*/
//        son=inflater.inflate(R.layout.root_activity_two,findViewById(R.id.root_activity_one_id),false)
//                .findViewById(R.id.root_activity_two_id);

        /**发现子布局按照子布局的格式,将所有元素添加给父布局*/
//        son=inflater.inflate(R.layout.root_activity_two,findViewById(R.id.root_activity_one_id),true)
//                .findViewById(R.id.root_activity_two_id);

        /**发现子布局按照null的格式,将所有元素添加给父布局*/
//        son=inflater.inflate(R.layout.root_activity_two,null,true)
//                .findViewById(R.id.root_activity_two_id);

        /**root参数表示将当前布局文件加入哪个目标root的布局作为子布局，attachToRoot表示是否需要直接this.addView()*/

        parent=findViewById(R.id.root_activity_one_id);
        ConstraintLayout.LayoutParams params=new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        parent.addView(son,params);
    }
}
