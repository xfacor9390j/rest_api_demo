package com.abhinay.restapi.rest;

import com.abhinay.restapi.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student>studentlist;
    @PostConstruct
    public void loadData(){
         studentlist=new ArrayList<>();
        Student student1=new Student("jetti","abhinay");
        Student student2=new Student("jetti","sravanthi");
        Student student3=new Student("jetti","sujatha");
        studentlist.add(student1);
        studentlist.add(student2);
        studentlist.add(student3);
        studentlist.add(new Student("jetti","lakshmana rao"));
    }
    @GetMapping("/students")
    public List<Student> getStudent(){



        return studentlist;
    }

//define the new endpoint /student/{studentid}// ;
    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId){
        //check the studentid against the size of the list;
        if(studentId>studentlist.size() || studentId<0){
            throw new StudentNotFoundException("student not found"+studentId);
        }

        return studentlist.get(studentId);
    }

    //add an exception handler using @exceptionhadler


}



