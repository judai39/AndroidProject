package com.haoyudu.roomdatabaseupgrade;

import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;

import java.util.List;

public class WordDataRepository {

    private LiveData<List<Word>> allWordsLive;
    private WordDataBase wordDataBase;
    private WordDao wordDao;

    public WordDataRepository(Application application) {
        wordDataBase = WordDataBase.getInstance(application);
        wordDao = wordDataBase.getWordDao();
        allWordsLive = wordDao.queryWords();
    }

    void insertWord(Word... word) {
        new AddAsyncTask(wordDao).execute(word);
    }

    void deleteWord(Word... word) {
        new DeleteAsyncTask(wordDao).execute(word);
    }

    void upgradeWord(Word... word) {
        new UpgradeAsyncTask(wordDao).execute(word);
    }

    void clearWord() {
        new ClearAsyncTask(wordDao).execute();
    }

    public LiveData<List<Word>> getAllWordsLive() {
        return allWordsLive;
    }

    static class AddAsyncTask extends AsyncTask<Word, Void, Void> {

        WordDao wordDao;

        public AddAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }

        //后台执行时调用
        @Override
        protected Void doInBackground(Word... words) {
            wordDao.insertWords(words);
            return null;
        }

        //进度更新时调用
//        @Override
//        protected void onProgressUpdate(Void... values) {
//            super.onProgressUpdate(values);
//        }


        //在后台任务执行之前调用
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//        }
    }

    static class DeleteAsyncTask extends AsyncTask<Word, Void, Void> {

        WordDao wordDao;

        public DeleteAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }

        //后台执行时调用
        @Override
        protected Void doInBackground(Word... words) {
            wordDao.deleteWords(words);
            return null;
        }
    }

    static class UpgradeAsyncTask extends AsyncTask<Word, Void, Void> {

        WordDao wordDao;

        public UpgradeAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }

        //后台执行时调用
        @Override
        protected Void doInBackground(Word... words) {
            wordDao.updateWords(words);
            return null;
        }
    }

    static class ClearAsyncTask extends AsyncTask<Word, Void, Void> {

        WordDao wordDao;

        public ClearAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }

        //后台执行时调用
        @Override
        protected Void doInBackground(Word... words) {
            wordDao.deleteAllWords();
            return null;
        }
    }
}
