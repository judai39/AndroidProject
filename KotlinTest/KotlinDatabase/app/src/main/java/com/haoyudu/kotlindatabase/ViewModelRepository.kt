package com.haoyudu.kotlindatabase

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData

class ViewModelRepository (application: Application){
    private var database: WordDatabase=WordDatabase.getInstance(application)
    private var dao: WordDao=database.getDao()
    private var liveData: LiveData<List<Word>> =dao.queryAllWords()

    fun insert(word:Word){
        AddAsyncTask(dao).execute(word)
    }

    fun queryAllWords(){
        QueryAllAsyncTask(dao).execute()
    }

    fun clearAllWords(){
        DeleteAllAsyncTask(dao).execute()
    }

    fun getAllWords():LiveData<List<Word>>{
        return liveData
    }

    open class AddAsyncTask(dao:WordDao) : AsyncTask<Word, Unit, Unit>() {
        private var dao:WordDao=dao
        override fun doInBackground(vararg params: Word?) {
            //null?判断传递
            for (word:Word? in params){
                word?.let { dao.insertWords(it) }
            }

        }
    }
    open class QueryAllAsyncTask(dao:WordDao) : AsyncTask<Word, Unit, LiveData<List<Word>>>() {
        private var dao:WordDao=dao
        override fun doInBackground(vararg params: Word?): LiveData<List<Word>> {
            return dao.queryAllWords()
        }
    }
    open class DeleteAllAsyncTask(dao:WordDao): AsyncTask<Unit, Unit, Unit>(){
        private var dao:WordDao=dao
        override fun doInBackground(vararg params: Unit?) {
            dao.deleteAllWords()
        }

    }
}