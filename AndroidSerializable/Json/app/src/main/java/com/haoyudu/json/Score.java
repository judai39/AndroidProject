package com.haoyudu.json;

public class Score {
    private double chinese_score,math_score;

    public Score(double chinese_score, double math_score) {
        this.chinese_score = chinese_score;
        this.math_score = math_score;
    }

    public double getChinese_score() {
        return chinese_score;
    }

    public void setChinese_score(double chinese_score) {
        this.chinese_score = chinese_score;
    }

    public double getMath_score() {
        return math_score;
    }

    public void setMath_score(double math_score) {
        this.math_score = math_score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "chinese_score=" + chinese_score +
                ", math_score=" + math_score +
                '}';
    }
}
