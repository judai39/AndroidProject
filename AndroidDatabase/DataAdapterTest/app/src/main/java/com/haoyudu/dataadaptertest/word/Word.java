package com.haoyudu.dataadaptertest.word;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Word {
    @PrimaryKey(autoGenerate = true)
    private Integer id;

    @ColumnInfo(name="english_word")
    private String word;

    @ColumnInfo(name="chinese_meaning")
    private String meaning;

//
//    public Word(Integer id, String word, String meaning) {
//        this.id = id;
//        this.word = word;
//        this.meaning = meaning;
//    }

    public Word(String word, String meaning) {
        this.word = word;
        this.meaning = meaning;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}
