package manageClass.controller;

import com.google.gson.Gson;
import manageClass.model.Student;
import manageClass.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/student")
@CrossOrigin(origins = "http://localhost:8080")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("students")
    public ResponseEntity<List> getAllStudents() {
        List list = studentService.getAllStudents();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("studentDetails")
    public ResponseEntity<List> getAllStudentDetails() {
        List<Student> list = studentService.getAllDetailsOfStudents();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id) {
        Student student = studentService.getStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping("saveStudent")
    public ResponseEntity<String> saveStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return new ResponseEntity<>("Student Saved Successfully", HttpStatus.CREATED);
    }

    @PostMapping("updateStudent/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable("id") Long id) {
        studentService.updateStudent(id);
        return new ResponseEntity<>("Student Updated Successfully", HttpStatus.CREATED);
    }
}
