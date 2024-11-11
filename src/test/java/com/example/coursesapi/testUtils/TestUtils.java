package com.example.coursesapi.testUtils;

import com.example.coursesapi.domain.dto.CourseDto;

import java.util.List;

public class TestUtils {

    public static List<CourseDto> createCourseDtoList() {
        return List.of(new CourseDto(
                1L,
                "testName",
                "testCategory",
                true,
                null,
                null
        ));
    }

    public static CourseDto createCourseDto() {
        return new CourseDto(
                1L,
                "testName",
                "testCategory",
                true,
                null,
                null
        );
    }
}
