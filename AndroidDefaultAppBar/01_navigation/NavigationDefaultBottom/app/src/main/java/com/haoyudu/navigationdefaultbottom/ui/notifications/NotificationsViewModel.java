package com.haoyudu.navigationdefaultbottom.ui.notifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NotificationsViewModel extends ViewModel {

    private final MutableLiveData<Float> scaleX,scaleY;

    public NotificationsViewModel() {
        scaleX=new MutableLiveData<>();
        scaleY=new MutableLiveData<>();
        scaleX.setValue(0.5f);
        scaleY.setValue(0.5f);
    }

    public void setRotationPosition(float num) {
        scaleX.setValue(num);
        scaleY.setValue(num);
    }

    public MutableLiveData<Float> getScaleX() {
        return scaleX;
    }

    public MutableLiveData<Float> getScaleY(){
        return scaleY;
    }

    public void addPosition(float position){
        setRotationPosition(scaleX.getValue()+position);
    }
}