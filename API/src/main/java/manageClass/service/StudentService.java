package manageClass.service;

import manageClass.model.Student;

import java.util.List;

public interface StudentService {

    void saveStudent(Student student);

    Student updateStudent(Long id);

    void deleteStudent(Long id);

    Long getStudentCount();

    Student getStudentById(Long id);

    List getAllStudents();

    List<Student> getAllDetailsOfStudents();
}
