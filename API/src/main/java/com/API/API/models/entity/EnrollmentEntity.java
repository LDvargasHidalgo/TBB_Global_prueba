package com.API.API.models.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "enrollments")
@Data
public class EnrollmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enrollment_id")
    private int enrollmentId;
    @Column(name = "student_id")
    private int studentId;
    @Column(name = "course_id")
    private int courseId;
}
