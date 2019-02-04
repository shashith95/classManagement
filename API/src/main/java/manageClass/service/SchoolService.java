package manageClass.service;

import manageClass.model.School;

import java.util.List;

public interface SchoolService {

    void saveSchool(School School);

    School updateSchool(Long id);

    void deleteSchool(Long id);

    Long getSchoolCount();

    School getSchoolById(Long id);

    List getAllSchools();
}
