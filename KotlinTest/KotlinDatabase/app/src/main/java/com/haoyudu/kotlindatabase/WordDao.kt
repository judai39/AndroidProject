package com.haoyudu.kotlindatabase

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface WordDao {
   @Insert
   fun insertWords(word:Word)

   @Delete
   fun deleteWords(word:Word)

   @Update
   fun updateWords(word:Word)

   @Query("DELETE FROM WORD")
   fun deleteAllWords()

   @Query("SELECT * FROM WORD ORDER BY ID DESC")
   fun queryAllWords():LiveData<List<Word>>
}