package manageClass.controller;

import manageClass.model.Course;
import manageClass.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/course")
@CrossOrigin(origins = "http://localhost:8080")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("courses")
    public ResponseEntity<List> getAllCourses() {
        List list = courseService.getAllCourses();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("course/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable("id") Long id) {
        Course course = courseService.getCourseById(id);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @PostMapping("saveCourse")
    public ResponseEntity<String> saveCourse(@RequestBody Course course) {
        courseService.saveCourse(course);
        return new ResponseEntity<>("Course Saved Successfully", HttpStatus.CREATED);
    }

    @PostMapping("updateCourse/{id}")
    public ResponseEntity<String> updateCourse(@PathVariable("id") Long id) {
        courseService.updateCourse(id);
        return new ResponseEntity<>("Course Updated Successfully", HttpStatus.CREATED);
    }
}
