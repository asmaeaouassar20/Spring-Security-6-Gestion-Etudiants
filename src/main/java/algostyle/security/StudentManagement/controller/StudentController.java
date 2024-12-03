package algostyle.security.StudentManagement.controller;

import algostyle.security.StudentManagement.model.Student;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
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



    @PreAuthorize("hasRole('ADMIN')") // Cette annotation restreint l'accès à la méthode pour que seuls les utilisateurs ayant le rôle ADMIN puissent exécuter l'opération
    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student){
        students.add(student);
        return student;
    }

    /**
     * @PreAuthorize : vérifie les permissions avant l'exécution de la méthode
     * @PostAuthorize : Vérifier les permissions après l'exécution de la méthode (souvent pour valider le résultat)
     */
}
