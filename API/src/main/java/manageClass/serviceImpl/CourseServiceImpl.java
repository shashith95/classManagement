package manageClass.serviceImpl;

import manageClass.model.Course;
import manageClass.repository.CourseRepository;
import manageClass.service.CourseService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class CourseServiceImpl implements CourseService {
    
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void saveCourse(Course Course) {
        courseRepository.save(Course);
    }

    public Course updateCourse(Long id) {
        return courseRepository.findById(id).get();
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    public Long getCourseCount() {
        return courseRepository.count();
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id).get();
    }

    public List getAllCourses() {
        return (List) courseRepository.findAll();
    }
}
