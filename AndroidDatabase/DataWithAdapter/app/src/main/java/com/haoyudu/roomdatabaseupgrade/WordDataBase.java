package com.haoyudu.roomdatabaseupgrade;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Word.class, version = 4, exportSchema = false)
public abstract class WordDataBase extends RoomDatabase {
    private static WordDataBase instance;

    static synchronized WordDataBase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), WordDataBase.class, "word_database").build();
        }
        return instance;
    }

    public abstract WordDao getWordDao();

}
