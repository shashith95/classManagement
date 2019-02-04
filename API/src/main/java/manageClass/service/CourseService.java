package manageClass.service;

import manageClass.model.Course;

import java.util.List;

public interface CourseService {

    void saveCourse(Course Course);

    Course updateCourse(Long id);

    void deleteCourse(Long id);

    Long getCourseCount();

    Course getCourseById(Long id);

    List getAllCourses();
}
