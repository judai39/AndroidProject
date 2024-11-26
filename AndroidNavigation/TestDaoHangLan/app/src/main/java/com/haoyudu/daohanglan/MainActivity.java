package com.haoyudu.daohanglan;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;

public class MainActivity extends AppCompatActivity {

    NavController navController;
    MotionLayout messageMotionLayout, exploreMotionLayout, mineMotionLayout;
    /**命名include时和目标的根布局名称要一样,或者只命名根布局,否则,系统会查找不到根布局所在*/
//    View message_include,explore_include,mine_include;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        messageMotionLayout=findViewById(R.id.messageMotionLayout);
        exploreMotionLayout=findViewById(R.id.findingMotionLayout);
        mineMotionLayout=findViewById(R.id.mineMotionLayout);

        navController = Navigation.findNavController(MainActivity.this, R.id.fragment);



        messageMotionLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.navigation_message);
                messageMotionLayout.transitionToEnd();
                exploreMotionLayout.transitionToStart();
                mineMotionLayout.transitionToStart();

            }
        });


        exploreMotionLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.navigation_explore);
                messageMotionLayout.transitionToStart();
                exploreMotionLayout.transitionToEnd();
                mineMotionLayout.transitionToStart();
            }
        });

        mineMotionLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.navigation_mine);
                messageMotionLayout.transitionToStart();
                exploreMotionLayout.transitionToStart();
                mineMotionLayout.transitionToEnd();
            }
        });

//        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
//            @Override
//            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
//                navController.popBackStack();
////                messageMotionLayout.setProgress(0f);
////                exploreMotionLayout.setProgress(0f);
////                mineMotionLayout.setProgress(0f);
//                messageMotionLayout.transitionToEnd();
//                exploreMotionLayout.transitionToEnd();
//                mineMotionLayout.transitionToEnd();
//                if (destination==findViewById(R.id.fragment_message)) {
//                    messageMotionLayout.transitionToEnd();
//                }
//                if (destination.getId() == R.id.fragment_explore) {
//                    exploreMotionLayout.transitionToEnd();
//                }
//                if (destination.getId() == R.id.fragment_mine) {
//                    mineMotionLayout.transitionToEnd();
//                }
////                while (destination.getId()==R.id.fragment_message){
////                    messageMotionLayout.transitionToEnd();
////                }
////                while (destination.getId()==R.id.fragment_explore){
////                    exploreMotionLayout.transitionToEnd();
////                }
////                while (destination.getId()==R.id.fragment_mine){
////                    mineMotionLayout.transitionToEnd();
////                }
//            }
//        });
    }

}

