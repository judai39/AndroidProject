package com.haoyudu.gallerytest

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.google.gson.Gson

class GalleryViewModel(application: Application) : AndroidViewModel(application) {
    private val _photoListLive= MutableLiveData<List<PhotoItem>>()
    val photoListLive:LiveData<List<PhotoItem>>
        get() {
            return _photoListLive
        }
    fun fetchData(){
        val stringRequest=StringRequest(
            Request.Method.GET,
            getUrl(),
            { _photoListLive.value=Gson().fromJson(it,Pixbay::class.java).hits./*array转换为list*/toList() },//Response TO Do 解析Gson
            { Log.e("my_log",it.toString()) }//Error Response To Do
        )
        VolleySingleton.getInstance(getApplication()).requestQueue.add(stringRequest)
    }
    fun getUrl():String{
        return "https://pixabay.com/api/?key=47310451-ebdbd99801f0b518340980159&q=${keyWords.random()}&per_page=100"
    }
    private val keyWords= arrayOf("cat","dog","car","phone","cow","computer")

}