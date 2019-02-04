package manageClass.serviceImpl;

import manageClass.dao.StudentDao;
import manageClass.model.Student;
import manageClass.repository.StudentRepository;
import manageClass.service.StudentService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao;

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentDao studentDao, StudentRepository studentRepository) {
        this.studentDao = studentDao;
        this.studentRepository = studentRepository;
    }

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    public Student updateStudent(Long id) {
        return studentRepository.findById(id).get();
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Long getStudentCount() {
        return studentRepository.count();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    public List getAllStudents() {
        return (List) studentRepository.findAll();
    }

    @Override
    public List<Student> getAllDetailsOfStudents() {
        return studentDao.getAllDetailsOfStudents();
    }
}
