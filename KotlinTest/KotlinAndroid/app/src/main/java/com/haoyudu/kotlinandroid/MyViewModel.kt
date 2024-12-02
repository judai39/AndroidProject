package com.haoyudu.kotlinandroid

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel:ViewModel() {
    val number:MutableLiveData<Int> by lazy { MutableLiveData<Int>().also { it.value=0 } }

    fun modifyNumber(num:Int){
        number.value= number.value?.plus(num)
    }
}