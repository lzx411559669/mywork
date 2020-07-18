package com.bookcode.grade_analysis.model;

/**
 * 科目类
 */
public class Subject {
    //课程id
    private int id;
    //课程名
    private String name;
    //分数
    private double score;

    public Subject(int id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
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

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }


}
