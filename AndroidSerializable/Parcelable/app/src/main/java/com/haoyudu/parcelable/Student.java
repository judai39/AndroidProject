package com.haoyudu.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**实现android自带的Parcelable接口*/
public class Student implements Parcelable {
    private static final long serialVersionUID = 3369452620490726091L;
    private String name;
    private int age;
    private Score score;

    public Student(String name,int age,Score score){
        this.name=name;
        this.age=age;
        this.score=score;
    }

    protected Student(Parcel in) {
        name = in.readString();
        age = in.readInt();
        score = in.readParcelable(Score.class.getClassLoader());
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
        dest.writeParcelable(score, flags);
    }
}
