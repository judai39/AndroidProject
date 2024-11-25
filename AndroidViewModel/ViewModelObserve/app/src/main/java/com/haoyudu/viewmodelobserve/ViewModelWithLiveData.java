package com.haoyudu.viewmodelobserve;

import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ViewModelWithLiveData extends ViewModel {
    private MutableLiveData<Integer> likedNum;

    public MutableLiveData<Integer> getLikedNum(){
        if(likedNum==null){
            likedNum=new MutableLiveData<>();
            likedNum.setValue(0);
        }
        return likedNum;
    }

    public void addLikedNum(int i){
        likedNum.setValue(likedNum.getValue()+i);
    }

}
