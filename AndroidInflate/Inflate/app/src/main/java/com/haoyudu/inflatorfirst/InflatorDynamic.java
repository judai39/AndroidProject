package com.haoyudu.inflatorfirst;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;

public class InflatorDynamic extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dynamic_activity_main);
        final LayoutInflater inflater= LayoutInflater.from(this);
        final RelativeLayout layout_parent=findViewById(R.id.RelativeLayout1);
        Button btn=findViewById(R.id.btnLoad);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout layout_son=inflater.inflate
                        (R.layout.dynamic_activity_inflator,null,false).findViewById(R.id.son_inflate);
                RelativeLayout.LayoutParams parameter_son=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                parameter_son.addRule(RelativeLayout.CENTER_IN_PARENT);
                layout_parent.addView(layout_son,parameter_son);
            }
        });
    }
}
