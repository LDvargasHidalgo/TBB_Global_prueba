package com.API.API.models.dao;

import com.API.API.models.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseDao extends JpaRepository<CourseEntity, Integer > {
}
