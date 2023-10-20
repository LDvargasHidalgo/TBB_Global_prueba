package com.TBTB_Global.API.course.service;

import com.TBTB_Global.API.course.dto.CourseDTO;

import java.util.List;

public interface CourseService {
    List<CourseDTO> getAllCourses();
    CourseDTO getCourseById(int courseId) ;
    CourseDTO createCourse(CourseDTO courseDTO);
    CourseDTO updateCourse(int courseId, CourseDTO courseDTO);
    void deleteCourse(int courseId);
}
