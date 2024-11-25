package com.haoyudu.viewmodeldatabinding;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ViewModelNum extends ViewModel {

    private MutableLiveData<Integer> num;

    public MutableLiveData<Integer> getNum(){
        if(num==null){
            num=new MutableLiveData<>();
            num.setValue(0);
        }
        return num;
    }

    public void setNum(){
        num.setValue(num.getValue()+1);
    }
}
