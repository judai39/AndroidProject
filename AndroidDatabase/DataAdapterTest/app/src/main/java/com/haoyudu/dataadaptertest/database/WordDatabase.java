package com.haoyudu.dataadaptertest.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.haoyudu.dataadaptertest.dao.WordDao;
import com.haoyudu.dataadaptertest.word.Word;

@Database(entities = {Word.class}, version = 1, exportSchema = false)
public abstract class WordDatabase extends RoomDatabase {
    public abstract WordDao getWordDao();

    static WordDatabase wordDatabase;
    public static WordDatabase getDatabase(Context context) {
        if (wordDatabase==null){
            wordDatabase= Room.databaseBuilder(context,WordDatabase.class,"word_database").
                    allowMainThreadQueries().
                    build();
        }
        return wordDatabase;
    }
}
