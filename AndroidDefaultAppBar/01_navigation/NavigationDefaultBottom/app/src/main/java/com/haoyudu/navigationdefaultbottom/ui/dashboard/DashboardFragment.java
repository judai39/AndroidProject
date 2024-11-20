package com.haoyudu.navigationdefaultbottom.ui.dashboard;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.haoyudu.navigationdefaultbottom.R;

import java.util.Random;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private ImageView imageView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        imageView=root.findViewById(R.id.imageview3_id);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        dashboardViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);
        dashboardViewModel.getScaleX().observe(getViewLifecycleOwner(), new Observer<Float>() {
            @Override
            public void onChanged(@Nullable Float f) {

            }
        });

        ObjectAnimator animatorX=ObjectAnimator.ofFloat(imageView,"x",0,0);
        ObjectAnimator animatorY=ObjectAnimator.ofFloat(imageView,"y",0,0);
        animatorY.setDuration(500);
        animatorX.setDuration(500);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!animatorX.isRunning()){
                    //生成100,或-100
                    float dx=new Random().nextBoolean()?100:-100;
                    animatorX.setFloatValues(imageView.getX()+dx,imageView.getX()+dx);
                    animatorY.setFloatValues(imageView.getY()+dx,imageView.getY()+dx);
                    dashboardViewModel.addPosition(dx);
                    animatorX.start();
                    animatorY.start();
                }
            }
        });
    }
}