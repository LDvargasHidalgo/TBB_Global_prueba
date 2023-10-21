package com.API.API.models.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "professors")
@Data
public class ProfessorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "professor_id")
    private int professorId;
    @Column(name = "professor_name")
    private String professorName;
    @Column(name = "professor_email")
    private String professorEmail;
    @Column(name = "course_id")
    private  Integer courseId;
}
