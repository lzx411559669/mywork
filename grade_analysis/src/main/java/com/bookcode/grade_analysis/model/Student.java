package com.bookcode.grade_analysis.model;

import java.util.List;

/**
 * 学生类
 */
public class Student {
    //学生id
    private Long id;
    //学生名
    private String name;
    //科目列表
    private List<Subject> subjectList ;
    //sum
    private double sum;

    public Student() {

    }

    public Student(Long id, String name, List<Subject> subjectList) {
        this.id = id;
        this.name = name;
        this.subjectList = subjectList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}
