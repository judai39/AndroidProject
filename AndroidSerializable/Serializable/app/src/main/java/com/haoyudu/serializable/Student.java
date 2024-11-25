package com.haoyudu.serializable;

import java.io.Serializable;

/**实现Serializable接口才可序列化*/
public class Student implements Serializable {
    private static final long serialVersionUID = 3369452620490726091L;
    private String name;
    private int age;
    private Score score;

    public Student(String name,int age,Score score){
        this.name=name;
        this.age=age;
        this.score=score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
