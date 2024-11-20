package com.haoyudu.navigationdefaultbottom.ui.home;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<Float> rotationPosition;

    public HomeViewModel() {
        rotationPosition=new MutableLiveData<>();
        rotationPosition.setValue((float) 0);
    }

    public void setRotationPosition(float num) {
        rotationPosition.setValue(num);
    }

    public MutableLiveData<Float> getRotationPosition() {

        return rotationPosition;
    }

    public void addPosition(float position){
        setRotationPosition(rotationPosition.getValue()+position);
    }
}