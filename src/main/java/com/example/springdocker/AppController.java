package com.example.springdocker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Student{
    public String name;
    public Integer marks;

    Student(String name, Integer marks){
        this.name = name;
        this.marks = marks;
    }
}

@RestController
public class AppController {

//    @Value("${url}")
//    private String url;

    @GetMapping("/hello")
    public ResponseEntity<?> hello(){

//        System.out.println(url);
        return ResponseEntity.ok(usingList());
    }

    public List<Student> usingList(){
        List<Student> list = new ArrayList<>();
        list.add(new Student("Student 1", 10));
        list.add(new Student("Student 2", 40));
        list.add(new Student("Student 3", 42));
        list.add(new Student("Student 4", 95));

        list.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.marks>o2.marks){
                    return 1;
                } else if(o1.marks<o2.marks){
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        return list;
    }
}
