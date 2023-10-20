package com.TBTB_Global.API.course.service;


import com.TBTB_Global.API.course.dto.CourseDTO;
import com.TBTB_Global.API.course.entity.Course;
import com.TBTB_Global.API.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CourseDTO getCourseById(int courseId) {
        Course course = courseRepository.findById(courseId).orElse(null);
        return (course != null) ? convertToDTO(course) : null;
    }

    @Override
    public CourseDTO createCourse(CourseDTO courseDTO) {
        Course course = convertToEntity(courseDTO);
        Course savedCourse = courseRepository.save(course);
        return convertToDTO(savedCourse);
    }

    @Override
    public CourseDTO updateCourse(int courseId, CourseDTO courseDTO) {
        if (courseRepository.existsById(courseId)) {
            Course course = convertToEntity(courseDTO);
            course.setCourseId(courseId);
            Course updatedCourse = courseRepository.save(course);
            return convertToDTO(updatedCourse);
        }
        return null;
    }

    @Override
    public void deleteCourse(int courseId) {
        courseRepository.deleteById(courseId);
    }


    //MAPPER
    private CourseDTO convertToDTO(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setCourseId(course.getCourseId());
        courseDTO.setCourseName(course.getCourseName());
        courseDTO.setCourseDescription(course.getCourseDescription());
        courseDTO.setCreditHours(course.getCreditHours());
        return courseDTO;
    }

    private Course convertToEntity(CourseDTO courseDTO) {
        Course course = new Course();
        course.setCourseName(courseDTO.getCourseName());
        course.setCourseDescription(courseDTO.getCourseDescription());
        course.setCreditHours(courseDTO.getCreditHours());
        return course;
    }
}
