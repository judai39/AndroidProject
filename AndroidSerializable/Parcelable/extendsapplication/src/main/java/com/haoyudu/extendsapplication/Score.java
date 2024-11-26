package com.haoyudu.extendsapplication;

import android.os.Parcel;
import android.os.Parcelable;

/**实现android自带的Parcelable接口*/
public class Score implements Parcelable {
    private static final long serialVersionUID = 6957563487876428429L;
    private int chinese,math;
    public Score(int chinese,int math){
        this.chinese=chinese;
        this.math=math;
    }

    protected Score(Parcel in) {
        chinese = in.readInt();
        math = in.readInt();
    }

    //Add Parcelable implements
    public static final Creator<Score> CREATOR = new Creator<Score>() {
        @Override
        public Score createFromParcel(Parcel in) {
            return new Score(in);
        }

        @Override
        public Score[] newArray(int size) {
            return new Score[size];
        }
    };

    public String getGrade(){
        if(chinese>=90&&math>=90){
            return "A";
        }else if(chinese>=80&&math>=80){
            return "B";
        }else{
            return "C";
        }
    }

    public int getChinese() {
        return chinese;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    //implements Parcelable
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(chinese);
        dest.writeInt(math);
    }
}


