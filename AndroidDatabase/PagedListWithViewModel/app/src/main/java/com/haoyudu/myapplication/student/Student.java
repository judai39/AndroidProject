package com.haoyudu.myapplication.student;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "student_tbl")
public class Student {
    @PrimaryKey
    private Integer id;
    @ColumnInfo(name="student_num")
    private Integer num;

    public Student( Integer num) {
        this.num = num;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
