package com.example.coursesapi.application.service.implementation;

import com.example.coursesapi.domain.dto.CourseDto;
import com.example.coursesapi.domain.entities.Course;
import com.example.coursesapi.domain.repository.CourseRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import com.example.coursesapi.application.service.CourseService;

import java.util.List;

@Service
public class CourseServiceImp implements CourseService {

    //todo remove runtime execption`
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

    @Override
    public List<CourseDto> getCourse( String name, String category) {
        try {
            List<Course> course = courseRepository.findAllByNameOrCategory(name, category);
            return course.stream().map(CourseDto::new).toList();
        } catch (Exception e) {
            throw new RuntimeException("Error getting course", e);
        }
    }

    @Override
    public CourseDto updateCourse(Long id, CourseDto course) {
        try {
            Course courseToUpdate = courseRepository.findById(id).orElse    (null);
            validateIfCourseExists(courseToUpdate);
            updateCourse(course, courseToUpdate);
            Course savedCourse = courseRepository.save(courseToUpdate);
            return new CourseDto(savedCourse);
        }catch (Exception e) {
            throw new RuntimeException("Error updating course", e);
        }}

    @Override
    public CourseDto deleteCourse(Long id) {
        try {
            Course courseToDelete = courseRepository.findById(id).orElse(null);
            validateIfCourseExists(courseToDelete);
             courseRepository.deleteById(id);
            return new CourseDto(courseToDelete);
        }catch (Exception e) {
            throw new RuntimeException("Error deleting course", e);
        }
    }

    @Override
    public CourseDto toggleActiveCourse(Long id) {
        try {
            Course courseToUpdate = courseRepository.findById(id).orElse(null);
            validateIfCourseExists(courseToUpdate);
            courseToUpdate.setActive(!courseToUpdate.isActive());
            Course savedCourse = courseRepository.save(courseToUpdate);
            return new CourseDto(savedCourse);
        }catch (Exception e) {
            throw new RuntimeException("Error updating course", e);
        }

    }

    private static void validateIfCourseExists(Course courseToUpdate) {
        if (courseToUpdate == null) {
            throw new RuntimeException("Course not found");
        }
    }

    private static void updateCourse(CourseDto course, Course courseToUpdate) {
        courseToUpdate.setName(course.getName());
        courseToUpdate.setCategory(course.getCategory());
        courseToUpdate.onUpdate();
    }

    @NotNull
    private static Course getNewCourse(CourseDto course) {
        Course newCourse = new Course();
        newCourse.setName(course.getName());
        newCourse.setCategory(course.getCategory());
        newCourse.onCreate();
        return newCourse;
    }
}
