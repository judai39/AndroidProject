package com.haoyudu.contentresolvertest.viewmodel

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.haoyudu.contentresolvertest.entity.Student
import com.haoyudu.roomcrud.dao.StudentDao

class StudentViewModel(application: Application): AndroidViewModel(application) {
    @RequiresApi(Build.VERSION_CODES.P)
    private var studentLiveData:LiveData<List<Student>> = MutableLiveData(StudentDao(application).queryAll())

    val _studentLiveData:LiveData<List<Student>>
        @RequiresApi(Build.VERSION_CODES.P)
        get (){return studentLiveData}
}