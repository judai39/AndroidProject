package com.haoyudu.roomdatabase;

import android.provider.UserDictionary;
import androidx.room.*;

import java.util.List;

@Dao
public interface WordDao {
    @Insert
    void insertWords(Word...word);

    @Delete
    void deleteWords(Word...word);

    @Update
    void updateWords(Word...word);

    @Query("DELETE  FROM WORD")
    void deleteAllWords();

    @Query("SELECT * FROM WORD ORDER BY ID DESC")
    List<Word> queryWords();



}
