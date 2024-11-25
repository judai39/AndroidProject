package com.haoyudu.serializable;

import java.io.Serializable;

/**实现Serializable接口才可序列化*/
public class Score implements Serializable {
    private static final long serialVersionUID = 6957563487876428429L;
    private int chinese,math;
    public Score(int chinese,int math){
        this.chinese=chinese;
        this.math=math;
    }

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
}


