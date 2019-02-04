package manageClass.serviceImpl;

import manageClass.model.School;
import manageClass.repository.SchoolRepository;
import manageClass.service.SchoolService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class SchoolServiceImpl implements SchoolService {
    
    private final SchoolRepository schoolRepository;

    public SchoolServiceImpl(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public void saveSchool(School School) {
        schoolRepository.save(School);
    }

    public School updateSchool(Long id) {
        return schoolRepository.findById(id).get();
    }

    public void deleteSchool(Long id) {
        schoolRepository.deleteById(id);
    }

    public Long getSchoolCount() {
        return schoolRepository.count();
    }

    public School getSchoolById(Long id) {
        return schoolRepository.findById(id).get();
    }

    public List getAllSchools() {
        return (List) schoolRepository.findAll();
    }
}
