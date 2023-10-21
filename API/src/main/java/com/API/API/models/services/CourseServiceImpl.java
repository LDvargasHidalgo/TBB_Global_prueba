package com.API.API.models.services;

import com.API.API.models.dao.ICourseDao;
import com.API.API.models.dao.IEnrollmentsDao;
import com.API.API.models.dao.IProfessorDao;
import com.API.API.models.entity.CourseEntity;
import com.API.API.models.entity.EnrollmentEntity;
import com.API.API.models.entity.ProfessorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private ICourseDao courseDao;

    @Autowired
    private IEnrollmentsDao enrollmentsDao;
    @Autowired
    private IProfessorDao professorDao;

    @Override
    public List<CourseEntity> findAll() {
        return (List<CourseEntity>) courseDao.findAll();
    }

    @Override
    public CourseEntity findById(Integer id) {
        return courseDao.findById(id).orElse(null);
    }

    @Override
    public CourseEntity save(CourseEntity course) {
        return courseDao.save(course);
    }

    @Override
    public void delete(Integer id) {
        courseDao.deleteById(id);
    }

    @Override
    public String deleteCourse(Integer id) {
       Optional<CourseEntity> course =  courseDao.findById(id);
       if(course.isEmpty()){
           return "No existe este curso en la base de datos";
       }
        List<EnrollmentEntity> enrollments = enrollmentsDao.FindEnrolments(id);
        if (!enrollments.isEmpty()) {
            enrollments.forEach(item -> {
                enrollmentsDao.delete(item);
            });
        }

        List<ProfessorEntity> professors = professorDao.FindProfessor(id);
        if (!professors.isEmpty()) {
            professors.forEach(item -> {
                item.setCourseId(null);
                professorDao.save(item);
            });
        }
        courseDao.deleteById(id);
        return "Se elimino el registro";
    }
}
