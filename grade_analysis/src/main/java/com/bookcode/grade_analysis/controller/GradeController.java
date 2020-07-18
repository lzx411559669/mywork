package com.bookcode.grade_analysis.controller;
import com.bookcode.grade_analysis.Sevrvice.StudentService;
import com.bookcode.grade_analysis.model.Student;
import com.bookcode.grade_analysis.model.Subject;
import com.bookcode.grade_analysis.model.TopStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.Comparator;
import java.util.List;
@Controller
public class GradeController {
    double sum;
    double size;
    @Autowired
    StudentService studentService;
    @ResponseBody
    @PostMapping("/add")
    public Mono<String> addStudent(@RequestBody Student student) {
        return studentService.save(student);
    }
    @ResponseBody
    @GetMapping("/getstudent")
    public Flux<Student> getStudent() {
        return studentService.getAll();
    }
    @ResponseBody
    @GetMapping("/get")
    public Mono<Student> getStudentById(@RequestParam("id") String id) {
        return studentService.getById(id);
    }
    @ResponseBody
    @GetMapping("/getSum")
    //根据学生id获取每个人的总分
    public double getSum(@RequestParam("id") String id) {
        sum = 0;
        size = 0;
        Flux<Student> studentFlux = studentService.getAll();
        studentFlux.subscribe(student -> {
            if (student.getId().equals(Long.valueOf(id))) {
                Flux<Subject> subjectFlux = Flux.fromIterable(student.getSubjectList());
                size += student.getSubjectList().size();
                subjectFlux.subscribe(subject -> {
                    sum += subject.getScore();
                });
                student.setSum(sum);
                System.out.println("总分："+student.getSum());
            }

        });
        System.out.println("sum::"+sum);
        return sum;
    }
    @ResponseBody
    @GetMapping("/getAverage")
    //根据每个学生id获取他们的平均分
    public double getAverage(@RequestParam("id") String studentId) {
        return getSum(studentId) / size;
    }
    @ResponseBody
    @GetMapping("/than")
    //根据科目查询指定分数段以上的学生
    public Flux<Student> getThan(@RequestParam("score") double score, @RequestParam("subjectName") String subjectName) {
        return studentService.scoreThan(score, subjectName);
    }
    @ResponseBody
    @GetMapping("/getTopStudent")
    //按成绩获取优等生
    public Flux<TopStudent> getTopStudent(@RequestParam("level") String level) {
        Flux<Student> studentFlux = studentService.getAll();
        studentFlux.subscribe(student -> getSum(student.getId().toString()));
        double score = level.equals("一等") ? 90 : 80;
        return studentFlux.filter(student -> getAverage(student.getId().toString()) >= score && getAverage(student.getId().toString()) < score + 10).map(student -> {
            TopStudent topStudent = new TopStudent(student.getId(), student.getName(), student.getSubjectList());
            topStudent.setSum(student.getSum());
            topStudent.setLevel(level.equals("一等") ? "一等奖" : "二等");
            return topStudent;
        });

    }
    @ResponseBody
    @GetMapping("/sort")
    //根据成绩总分排序
    public Mono<List<Student>> sort() {
        Flux<Student> studentFlux = studentService.getAll();
        studentFlux.subscribe(student -> getSum(student.getId().toString()));
        return studentFlux .collectSortedList(Comparator.comparing(Student::getSum));
    }
}
