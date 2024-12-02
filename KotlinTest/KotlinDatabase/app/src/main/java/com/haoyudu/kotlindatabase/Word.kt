package com.haoyudu.kotlindatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Word(name:String,meaning:String) {
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0

    @ColumnInfo(name="english_word")
    var name:String = name

    @ColumnInfo(name="chinese_meaning")
    var meaning:String = meaning

}