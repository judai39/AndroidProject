package com.haoyudu.kotlindatabase

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Word::class] ,version=1,exportSchema = false)
abstract class WordDatabase: RoomDatabase() {
    abstract fun getDao():WordDao

    companion object{
        private  var database: WordDatabase? =null
        @Synchronized
        @JvmStatic
        fun getInstance(application:Application):WordDatabase{
            if (database==null){
                database= Room.databaseBuilder(application,WordDatabase::class.java,"word_database").build()
            }
            return database as WordDatabase
        }
    }

}