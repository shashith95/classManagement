package manageClass.daoImpl;

import manageClass.dao.StudentDao;
import manageClass.model.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class StudentDaoImpl implements StudentDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Student> getAllDetailsOfStudents() {
        String sql = "SELECT s.student_name, s.nic, c.course_name, sc.school_name" +
                " FROM student s INNER JOIN course c ON s.course = c.id " +
                "INNER JOIN school sc ON sc.id = s.school";
        return entityManager.createNativeQuery(sql).getResultList();
    }
}
