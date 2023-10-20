package com.TBTB_Global.API.course.dto;

import lombok.Data;

@Data
public class CourseDTO {
    private int courseId;
    private String courseName;
    private String courseDescription;
    private int creditHours;
}
