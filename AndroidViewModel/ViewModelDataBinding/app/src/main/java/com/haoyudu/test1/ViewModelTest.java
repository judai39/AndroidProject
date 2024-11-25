package com.haoyudu.test1;

import androidx.lifecycle.MutableLiveData;

public class ViewModelTest {

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
