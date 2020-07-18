package com.bookcode.grade_analysis.model;
import java.util.List;
public class TopStudent extends Student{
    //奖学金等级
    private String level;
    public TopStudent(Long id, String name, List<Subject> subjectList) {
        super(id, name, subjectList);
    }
    public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
        this.level = level;
    }
}
