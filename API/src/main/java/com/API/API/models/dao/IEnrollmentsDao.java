package com.API.API.models.dao;

import com.API.API.models.entity.EnrollmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IEnrollmentsDao extends JpaRepository<EnrollmentEntity, Integer> {

    //Consulta trae todos los registros de la tabla enrolments relacionados a un curso
    @Query(value = "select e.* from enrollments e " +
            "inner join courses c on c.course_id = e.course_id " +
            "where c.course_id = ?;", nativeQuery = true)
    public List<EnrollmentEntity> FindEnrolments(Integer courseId);

}
