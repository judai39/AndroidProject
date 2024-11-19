package com.haoyudu.dataadaptertest.model.repository;

import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import com.haoyudu.dataadaptertest.dao.WordDao;
import com.haoyudu.dataadaptertest.database.WordDatabase;
import com.haoyudu.dataadaptertest.word.Word;

import java.util.List;

public class ModelRepository {
    private final LiveData<List<Word>> allWords;
    private final WordDao wordDao;

    public ModelRepository(Application application){
        WordDatabase wordDatabase = WordDatabase.getDatabase(application);
        wordDao=wordDatabase.getWordDao();
        allWords=wordDao.QueryAllWordsLiveData();
    }

    static class InsertAsyncTask extends AsyncTask<Word,Void,Void> {

        private WordDao wordDao;

        public InsertAsyncTask(WordDao wordDao){
            this.wordDao=wordDao;
        }

        @Override
        protected Void doInBackground(Word...words) {
            wordDao.InsertWords(words);
            return null;
        }
    }

    static class DeleteAsyncTask extends AsyncTask<Word,Void,Void>{

        private WordDao wordDao;

        public DeleteAsyncTask(WordDao wordDao){
            this.wordDao=wordDao;
        }

        @Override
        protected Void doInBackground(Word...words) {
            wordDao.DeleteWord(words);
            return null;
        }
    }

    static class ClearAsyncTask extends AsyncTask<Void,Void,Void>{

        private WordDao wordDao;

        public ClearAsyncTask(WordDao wordDao){
            this.wordDao=wordDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            wordDao.DeleteAllWords();
            return null;
        }
    }

    static class DeleteLatestAsyncTask extends AsyncTask<Void,Void,Void>{

        private WordDao wordDao;

        public DeleteLatestAsyncTask(WordDao wordDao){
            this.wordDao=wordDao;
        }

        @Override
        protected Void doInBackground(Void...voids) {
            Word word=wordDao.QueryLatestWord();
            wordDao.DeleteWord(word);
            return null;
        }
    }

    static class QueryWordAsyncTask extends AsyncTask<Void,Void,Void>{

        private WordDao wordDao;
        private String wordName;
        private Word word;

        public QueryWordAsyncTask(WordDao wordDao, String wordName) {
            this.wordDao = wordDao;
            this.wordName = wordName;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            word=wordDao.QueryWordByName(wordName);
            return null;
        }

        public Word getWord() {
            return word;
        }
    }

    static class WordHaveAsyncTask extends AsyncTask<Void,Void,Void>{

        private WordDao wordDao;
        private String wordName;
        private boolean isHave;

        public WordHaveAsyncTask(WordDao wordDao,String wordName) {
            this.wordDao = wordDao;
            this.wordName=wordName;
        }

        @Override
        protected Void doInBackground(Void...voids) {
            isHave=wordDao.QueryWordIsHave(wordName);
            return null;
        }

        public boolean isHave() {
            return isHave;
        }
    }

    public void insertWords(Word...words){
        new InsertAsyncTask(wordDao).execute(words);
    }

    public Word queryWord(String wordName){
        return wordDao.QueryWordByName(wordName);
    }

    public void deleteWord(Word...words){
        new DeleteAsyncTask(wordDao).execute(words);
    }

    public void clearWords(){
        new ClearAsyncTask(wordDao).execute();
    }

    public void deleteWordLatest(){
        new DeleteLatestAsyncTask(wordDao).execute();
    }

    public boolean wordIsHave(String wordName){
//        new WordHaveAsyncTask(wordDao,wordName).execute();
        return wordDao.QueryWordIsHave(wordName);
    }

    public LiveData<List<Word>> getAllWords() {
        return allWords;
    }
}
