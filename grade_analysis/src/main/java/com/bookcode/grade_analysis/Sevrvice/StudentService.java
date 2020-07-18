package com.bookcode.grade_analysis.Sevrvice;

import com.bookcode.grade_analysis.model.Student;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Stream;

public interface StudentService {
    public Mono<String> save(Student student);
    public Flux<Student> getAll();
    public Mono<Student> getById(String id);
    public Flux<Student> scoreThan(double score,String subjectName);
}
