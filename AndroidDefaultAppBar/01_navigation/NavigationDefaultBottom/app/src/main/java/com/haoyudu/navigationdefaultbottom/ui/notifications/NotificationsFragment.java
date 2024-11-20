package com.haoyudu.navigationdefaultbottom.ui.notifications;

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

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private ImageView imageView;

    /**onCreateView()放置inflate生成的实例对象*/
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        imageView=root.findViewById(R.id.imageview2_id);
        return root;
    }

    /**onActivityCreated放置ViewModel的初始化*/
    @Override
    public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        notificationsViewModel = new ViewModelProvider(requireActivity()).get(NotificationsViewModel.class);
        notificationsViewModel.getScaleX().observe(getViewLifecycleOwner(), new Observer<Float>() {
            @Override
            public void onChanged(@Nullable Float f) {
                imageView.setScaleX(notificationsViewModel.getScaleX().getValue());
                imageView.setScaleY(notificationsViewModel.getScaleY().getValue());
            }
        });
        ObjectAnimator animatorX=ObjectAnimator.ofFloat(imageView,"scaleX",0,0);
        ObjectAnimator animatorY=ObjectAnimator.ofFloat(imageView,"scaleY",0,0);
        animatorX.setDuration(500);
        animatorY.setDuration(500);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!animatorX.isRunning()){
                    animatorX.setFloatValues(imageView.getScaleX()+0.1f);
                    animatorY.setFloatValues(imageView.getScaleY()+0.1f);
                    notificationsViewModel.addPosition(0.1f);
                    animatorX.start();
                    animatorY.start();
                }
            }
        });
    }
}