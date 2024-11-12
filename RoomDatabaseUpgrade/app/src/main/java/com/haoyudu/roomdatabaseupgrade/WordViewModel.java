package com.haoyudu.roomdatabaseupgrade;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    private WordDataRepository repository;

    public WordViewModel(@NonNull Application application) {
        super(application);
        repository = new WordDataRepository(application);
    }

    void insertWord(Word... word) {
        repository.insertWord(word);
    }

    void deleteWord(Word... word) {
        repository.deleteWord(word);
    }

    void upgradeWord(Word... word) {
        repository.upgradeWord(word);
    }

    void clearWord() {
        repository.clearWord();
    }

    public LiveData<List<Word>> getAllWordsLive() {
        return repository.getAllWordsLive();
    }

}
