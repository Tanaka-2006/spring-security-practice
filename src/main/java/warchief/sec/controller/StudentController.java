package warchief.sec.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import warchief.sec.Entity.Student;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    public List<Student> students = new ArrayList<>(List.of(

            new Student(20,"Brighton",60),
            new Student(24,"Getrude",63)
    ));

    @GetMapping("/Student")
    public List<Student> getStudent(){
     return students;
    }
@GetMapping("/csrf-token")
public CsrfToken getCrsfToken(HttpServletRequest request){

        return (CsrfToken) request.getAttribute("_csrf");
}

    @PostMapping("/Student")
    public Student addStudent(@RequestBody Student student){

       students.add(student);
       return student;

    }

}
