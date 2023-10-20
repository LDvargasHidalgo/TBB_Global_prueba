package com.TBTB_Global.API.course.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "courses")
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int courseId;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "course_description")
    private  String courseDescription;

    @Column(name = "credit_hours")
    private int creditHours;

}
