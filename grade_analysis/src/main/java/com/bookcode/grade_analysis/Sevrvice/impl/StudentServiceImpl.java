package com.bookcode.grade_analysis.Sevrvice.impl;
import com.bookcode.grade_analysis.Sevrvice.StudentService;
import com.bookcode.grade_analysis.model.Student;
import com.bookcode.grade_analysis.model.Subject;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    public final List<Student> studentList = new ArrayList<>();
    @PostConstruct
    public void init() {
        Subject subject1 = new Subject(1, "数学", 88);
        Subject subject2 = new Subject(2, "语文", 87);
        Subject subject3 = new Subject(3, "英语", 86);
        Subject subject4 = new Subject(4, "Java", 99);
        List<Subject> subjectList = new ArrayList<>();
        subjectList.add(subject1);
        subjectList.add(subject2);
        subjectList.add(subject3);
        List<Subject> subjectList2 = Arrays.asList(subject1, subject4, new Subject(5, "c++", 89));
        List<Subject> subjectList3 = Arrays.asList(new Subject(1,"数学",0),new Subject(2,"语文",0),new Subject(3,"英语",0));
        Student student = new Student(1L, "刘正星", subjectList);
        studentList.add(student);
        student = new Student(2L, "刘德华", subjectList);
        studentList.add(student);
        studentList.add(new Student(3L,"李四",subjectList3));
        studentList.add(new Student(4L,"老八", Arrays.asList(subject1,subject2,subject3)));
        studentList.add(new Student(5L, "张三", subjectList2));
    }
    @Override
    public Mono<String> save(Student student) {
        studentList.add(student);
        return Mono.just("添加成功");
    }
    @Override
    public Flux<Student> getAll() {
        return Flux.fromIterable(studentList);
    }
    @Override
    public Mono<Student> getById(String id) {
        return Mono.justOrEmpty(studentList.stream().filter(student -> {
            return student.getId().equals(Long.valueOf(id));
        }).findFirst().orElse(null));
    }
    public Flux<Student> scoreThan(double score, String subjectName) {
        return Flux.fromIterable(studentList).filter(student -> isThan(student, score, subjectName));
    }
    Boolean isThan = false;
    public Boolean isThan(Student student, double score, String subjectName) {
        isThan = false;
        Flux<Subject> flexSubject = Flux.fromIterable(student.getSubjectList());
        Flux<Subject> flexSubject2 = flexSubject.filter(subject -> subject.getName().equals(subjectName) && subject.getScore() >= score);
        flexSubject2.subscribe(subject -> {
            isThan = true;
        });
        return isThan;
    }
}
