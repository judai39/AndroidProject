package com.haoyudu.navigationstandard;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.navigation.Navigation;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstActivity#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstActivity extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FirstActivity() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FirstActivity.
     */
    // TODO: Rename and change types and number of parameters
    public static FirstActivity newInstance(String param1, String param2) {
        FirstActivity fragment = new FirstActivity();
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
        return inflater.inflate(R.layout.fragment_first_activity, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //直接调用Navigation静态绑定方法
        getView().findViewById(R.id.button_first).setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_fragment_first_id_to_fragment_home_id));
        String str=getArguments().getString("first_key");
        TextView textView=getView().findViewById(R.id.first_textView);
        textView.setText(str);


        /**读取从home页面传来的bundle值*/
        String edit_text=getArguments().getString("edit_text");
        EditText editText=getView().findViewById(R.id.first_edit_text);
        editText.setText(edit_text);
    }
}