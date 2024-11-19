package com.haoyudu.dataadaptertest.dao;

import androidx.lifecycle.LiveData;
import androidx.room.*;
import com.haoyudu.dataadaptertest.word.Word;

import java.util.List;

//database access object
@Dao
public interface WordDao {
    @Insert
    void InsertWords(Word...words);

    @Update
    void UpdateWords(Word...words);

    @Delete
    void DeleteWord(Word...words);

    @Query("Delete From word")
    void DeleteAllWords();

    @Query("SELECT * FROM word ORDER BY id DESC LIMIT 1")
    Word QueryLatestWord();


    @Query("SELECT * FROM WORD WHERE english_word=(:name)")
    Word QueryWordByName(String name);

    @Query("SELECT * FROM word ORDER BY id DESC")
    LiveData<List<Word>> QueryAllWordsLiveData();

    @Query("SELECT * FROM word WHERE english_word=(:name)")
    boolean QueryWordIsHave(String name);

}
