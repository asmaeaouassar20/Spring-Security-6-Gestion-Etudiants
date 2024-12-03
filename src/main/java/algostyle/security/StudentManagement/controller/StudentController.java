package algostyle.security.StudentManagement.controller;

import algostyle.security.StudentManagement.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    private  List<Student> students=new ArrayList<>();

    @GetMapping("/students")
    public List<Student> students(){

        Student student1=new Student();
        student1.setId(1);
        student1.setFirstName("Asmae");
        student1.setLastName("Aouassar");

        Student student2=new Student();
        student2.setId(2);
        student2.setFirstName("Fatima");
        student2.setLastName("afd");

        students.add(student1);
        students.add(student2);
        return students;
    }


    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student){
        students.add(student);
        return student;
    }
}
