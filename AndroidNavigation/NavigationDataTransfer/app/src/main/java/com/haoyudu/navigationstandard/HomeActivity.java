package com.haoyudu.navigationstandard;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeActivity#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeActivity extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeActivity() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeActivity.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeActivity newInstance(String param1, String param2) {
        HomeActivity fragment = new HomeActivity();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_activity, container, false);
    }

    //在此方法中填写组件的初始化工作
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //为什么不能直接findView(),而是要getView().findView()?因为只有onCreate()重写方法涉及到实例化对象
        //这里都是编译类型逻辑,当然要获取指针对象
        Button btn=getView().findViewById(R.id.button_home);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText=getView().findViewById(R.id.home_edit_text);
                String edit_text=editText.getText().toString();
                if(TextUtils.isEmpty(edit_text)){
                    Toast.makeText(getActivity(), "请输入您的文字", Toast.LENGTH_SHORT).show();
                    return;
                }
                Bundle bundle=new Bundle();
                bundle.putString("edit_text",edit_text);
                /**以上是动态传递数据的逻辑,在下方的navigate()调用时传入参数*/
                NavController navController= Navigation.findNavController(v);
//                navController.navigate(R.id.fragment_first_id);
                navController.navigate(R.id.action_fragment_home_id_to_fragment_first_id,bundle);
            }
        });


    }
}