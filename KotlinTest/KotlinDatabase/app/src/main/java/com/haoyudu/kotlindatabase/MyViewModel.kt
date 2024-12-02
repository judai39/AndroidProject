package com.haoyudu.kotlindatabase

import android.app.Application
import android.os.AsyncTask
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room

class MyViewModel(application: Application) : AndroidViewModel(application) {
    private var viewModelRepository:ViewModelRepository= ViewModelRepository(application)

    fun insert(word:Word){
        viewModelRepository.insert(word)
    }

    fun queryAllWords(){
        viewModelRepository.queryAllWords()
    }

    fun clearAllWords(){
        viewModelRepository.clearAllWords()
    }

    fun getAllWords():LiveData<List<Word>>{
        return viewModelRepository.getAllWords()
    }

}