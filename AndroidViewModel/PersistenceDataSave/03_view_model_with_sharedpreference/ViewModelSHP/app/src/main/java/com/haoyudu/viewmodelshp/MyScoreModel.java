package com.haoyudu.viewmodelshp;


import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;

/**
 * 如果我们想要在model层引入SharedPreference以存储数据至内部,我们需要将context\application实例传入进来,才可以调用
 * 因此,开发者编写了了一个已经传入实例的新的ViewModel子类,AndroidViewModel类
 */

public class MyScoreModel extends AndroidViewModel {
    /**
     * handle(携带着textview.score信息)<--(对其负责)---SharedPreferences(维护手机根目录下的一个xml文件)
     */
    private final SavedStateHandle handle;
    private final String local_key = String.valueOf(R.string.shred_preference_local_key);
    private final String handle_key = String.valueOf(R.string.score_key);
    private SharedPreferences shp;
//    private SharedPreferences.Editor editor;

    public MyScoreModel(@NonNull Application application, SavedStateHandle handle) {
        super(application);
        //model层如何能对MainActivity负责?     ->      被MainActivity实例化
        this.handle = handle;
    }

    public void save(int num) {
        shp = getApplication().getSharedPreferences("my_data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shp.edit();
        editor.putInt(local_key, num);
        editor.apply();
    }

    public int load() {
        return shp.getInt(local_key, 0);
    }

    public void setHandle(int num) {
        handle.set(handle_key, num);
    }

    public LiveData<Integer> getHandle() {
        if (!handle.contains(handle_key)) {
            handle.set(handle_key, shp.getInt(local_key, 0));
        }
        return handle.getLiveData(handle_key);
    }

    public void add(int num) {
        setHandle(load() + num);

        /*将handle的存放信息存入shared_preference根目录存储文件中,将其放在add()点击事件中,使得每次点击都对
         * 文件进行重写,当然,该方法也可以放在其他地方,例如在MainActivity中的重写方法onPause()中,使得应用每次
         * 切入后台时存储信息*/
        save(getHandle().getValue() == null ? 0 : getHandle().getValue());
    }

}
