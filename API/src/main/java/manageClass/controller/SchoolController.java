package manageClass.controller;

import manageClass.model.School;
import manageClass.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/school")
@CrossOrigin(origins = "http://localhost:8080")
public class SchoolController {
    
    @Autowired
    private SchoolService schoolService;

    @GetMapping("schools")
    public ResponseEntity<List> getAllSchools() {
        List list = schoolService.getAllSchools();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("school/{id}")
    public ResponseEntity<School> getSchoolById(@PathVariable("id") Long id) {
        School School = schoolService.getSchoolById(id);
        return new ResponseEntity<>(School, HttpStatus.OK);
    }

    @PostMapping("saveSchool")
    public ResponseEntity<String> saveSchool(@RequestBody School school) {
        schoolService.saveSchool(school);
        return new ResponseEntity<>("School Saved Successfully", HttpStatus.CREATED);
    }

    @PostMapping("updateSchool/{id}")
    public ResponseEntity<String> updateSchool(@PathVariable("id") Long id) {
        schoolService.updateSchool(id);
        return new ResponseEntity<>("School Updated Successfully", HttpStatus.CREATED);
    }
}
