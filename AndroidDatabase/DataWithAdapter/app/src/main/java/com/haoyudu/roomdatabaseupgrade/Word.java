package com.haoyudu.roomdatabaseupgrade;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Word {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "english_name")
    private String name;
    @ColumnInfo(name = "chinese_meaning")
    private String meaning;

    public Word(String name, String meaning) {
        this.name = name;
        this.meaning = meaning;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}
