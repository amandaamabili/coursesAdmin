package com.example.coursesapi.application.service;

import com.example.coursesapi.domain.dto.CourseDto;

import java.util.List;

/**
 * Course Service Interface
 *
 */
public interface CourseService {

    CourseDto createCourse(CourseDto course);

    List<CourseDto> getCourse(String name, String category);

    CourseDto updateCourse(Long id, CourseDto course);

    CourseDto deleteCourse(Long id);

    CourseDto toggleActiveCourse(Long id);


}
