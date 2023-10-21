package com.API.API.models.dao;

import com.API.API.models.entity.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProfessorDao extends JpaRepository<ProfessorEntity, Integer> {

    //Trae todos los profesores relacionados con un curso
    @Query(value = "select p.* from professors p " +
            "inner join courses c on c.course_id = p.course_id " +
            "where c.course_id = ?; ", nativeQuery = true)
    public List<ProfessorEntity> FindProfessor(Integer courseId);
}
