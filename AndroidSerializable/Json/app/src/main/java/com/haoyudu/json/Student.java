package com.haoyudu.json;

import com.google.gson.annotations.SerializedName;

public class Student {
    /**@SerializedName标签声明后,生成的json文件中的对应属性的字段为我们声明的名字*/
    @SerializedName("student_name")
    private String name;
    @SerializedName("student_age")
    private double age;
    private Score score;

    public Student(String name, double age,Score score) {
        this.name = name;
        this.age = age;
        this.score=score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
