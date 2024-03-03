package kz.aitu.springproject.services;

import lombok.Data;

@Data
public class CourseRequest {
    private String courseName;
    private int teacherId;
}
