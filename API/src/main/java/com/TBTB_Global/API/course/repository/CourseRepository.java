package com.TBTB_Global.API.course.repository;

import com.TBTB_Global.API.course.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
