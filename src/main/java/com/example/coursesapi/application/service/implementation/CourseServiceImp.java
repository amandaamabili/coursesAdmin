package com.example.coursesapi.application.service.implementation;

import com.example.coursesapi.domain.dto.CourseDto;
import com.example.coursesapi.domain.entities.Course;
import com.example.coursesapi.domain.repository.CourseRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import com.example.coursesapi.application.service.CourseService;

@Service
public class CourseServiceImp implements CourseService {

    private final CourseRepository courseRepository;
    public CourseServiceImp(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public CourseDto createCourse(CourseDto course) {
        try {
            //colocar isso em classe utilitaria
            Course newCourse = getNewCourse(course);
            Course savedCourse = courseRepository.save(newCourse);
            return new CourseDto(savedCourse);
        } catch (Exception e) {
            throw new RuntimeException("Error creating course", e);
        }}

    @NotNull
    private static Course getNewCourse(CourseDto course) {
        Course newCourse = new Course();
        newCourse.setName(course.getName());
        newCourse.setCategory(course.getCategory());
        newCourse.onCreate();
        return newCourse;
    }
}
