package com.haoyudu.dataadaptertest.model;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.haoyudu.dataadaptertest.model.repository.ModelRepository;
import com.haoyudu.dataadaptertest.word.Word;

import java.util.List;

public class MyViewModel extends AndroidViewModel{

    private final ModelRepository modelRepository;

    public MyViewModel(@NonNull Application application) {
        super(application);
        modelRepository=new ModelRepository(application);
    }

    public void insertWords(Word...words){
        modelRepository.insertWords(words);
    }

    public Word queryWord(String wordName){
        return modelRepository.queryWord(wordName);
    }

    public void deleteWord(Word...words){
        modelRepository.deleteWord(words);
    }

    public void clearWords(){
        modelRepository.clearWords();
    }

    public void deleteWordLatest(){
        modelRepository.deleteWordLatest();
    }

    public boolean wordIsHave(String wordName){
        return modelRepository.wordIsHave(wordName);
    }


    public LiveData<List<Word>> getAllWords() {
        return modelRepository.getAllWords();
    }
}
