package com.haoyudu.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    private MutableLiveData<Integer> num_data;

    public MutableLiveData<Integer> get_num_data() {
        if(num_data==null){
            num_data=new MutableLiveData<>();
            num_data.setValue(0);
        }
        return num_data;
    }

    public void set_num_data(int num){
        num_data.setValue(num);
    }

    public void add(int num){
        num_data.setValue(num_data.getValue()+num);
    }

}
