package com.haoyudu.navigationdefaultbottom.ui.home;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.haoyudu.navigationdefaultbottom.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private ImageView imageView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        imageView=root.findViewById(R.id.imageview1_id);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        /**provider参数传入requireActivity()后，页面切换后也依然会保存当前的viewModel存储数据*/
        homeViewModel = new ViewModelProvider(requireActivity()).get(HomeViewModel.class);
        homeViewModel.getRotationPosition().observe(getViewLifecycleOwner(), new Observer<Float>() {
            @Override
            public void onChanged(@Nullable Float f) {
                imageView.setRotation(homeViewModel.getRotationPosition().getValue());
            }
        });
        ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(imageView,"rotation",0,0);
        objectAnimator.setDuration(500);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!objectAnimator.isRunning()){
                    objectAnimator.setFloatValues(imageView.getRotation(),imageView.getRotation()+100);
                    //旋转100度
                    homeViewModel.addPosition(100);
                    objectAnimator.start();
                }
            }
        });
    }
}