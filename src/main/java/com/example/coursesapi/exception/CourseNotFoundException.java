package com.example.coursesapi.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CourseNotFoundException extends RuntimeException {
    public static final String COURSE_WITH_ID = "Course with ID ";
    public static final String NOT_FOUND = " not found.";
    public static final String COURSE_NOT_FOUND_EXCEPTION = "CourseNotFoundException";
    private final ErrorResponse errorResponse;

    public CourseNotFoundException(Long courseId) {
        super(COURSE_WITH_ID + courseId + NOT_FOUND);
        this.errorResponse = new ErrorResponse(COURSE_WITH_ID + courseId + NOT_FOUND, HttpStatus.NOT_FOUND, COURSE_NOT_FOUND_EXCEPTION);
    }

}