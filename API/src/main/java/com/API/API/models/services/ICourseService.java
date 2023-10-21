package com.API.API.models.services;

import com.API.API.models.entity.CourseEntity;

import java.util.List;

public interface ICourseService {

    public List<CourseEntity> findAll();

    public CourseEntity findById(Integer id);
    public CourseEntity save(CourseEntity cliente);
    public void delete(Integer id);

    public String deleteCourse(Integer id);
}
