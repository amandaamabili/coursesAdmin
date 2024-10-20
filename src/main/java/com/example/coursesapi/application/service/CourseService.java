package com.example.coursesapi.application.service;

import com.example.coursesapi.domain.dto.CourseDto;

public interface CourseService {

    CourseDto createCourse(CourseDto course);
}
