package com.example.coursesapi.utils;

import com.example.coursesapi.domain.dto.CourseDto;
import com.example.coursesapi.domain.entities.Course;

public class CourseUtils  {

    public static Course getNewCourse(CourseDto course) {
        Course newCourse = new Course();
        newCourse.setName(course.getName());
        newCourse.setCategory(course.getCategory());
        newCourse.onCreate();
        return newCourse;
    }

    public static void updateCourse(CourseDto course, Course courseToUpdate) {
        courseToUpdate.setName(course.getName());
        courseToUpdate.setCategory(course.getCategory());
        courseToUpdate.onUpdate();
    }
}
