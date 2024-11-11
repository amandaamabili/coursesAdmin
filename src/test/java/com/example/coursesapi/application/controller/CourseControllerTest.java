package com.example.coursesapi.application.controller;

import static com.example.coursesapi.testUtils.TestUtils.createCourseDto;
import static com.example.coursesapi.testUtils.TestUtils.createCourseDtoList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.example.coursesapi.application.service.CourseService;
import com.example.coursesapi.domain.dto.CourseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;

class CourseControllerTest {

    @Mock
    private CourseService courseService;

    @InjectMocks
    private CourseController courseController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createCourse_returnsCreatedCourse() {
        CourseDto courseDto = createCourseDto();
        when(courseService.createCourse(courseDto)).thenReturn(courseDto);

        ResponseEntity<CourseDto> response = courseController.createCourse(courseDto);

        assertEquals(ResponseEntity.ok(courseDto), response);
        verify(courseService).createCourse(courseDto);
    }

    @Test
    void getCourse_returnsCoursesByNameOrCategory() {
        String name = "testName";
        String category = "testCategory";
        List<CourseDto> courses =createCourseDtoList();
        when(courseService.getCourse(name, category)).thenReturn(courses);

        ResponseEntity<List<CourseDto>> response = courseController.getCourse(name, category);

        assertEquals(ResponseEntity.ok(courses), response);
        verify(courseService).getCourse(name, category);
    }

    @Test
    void updateCourse_returnsUpdatedCourse() {
        Long id = 1L;
        CourseDto courseDto = createCourseDto();
        when(courseService.updateCourse(id, courseDto)).thenReturn(courseDto);

        ResponseEntity<CourseDto> response = courseController.updateCourse(id, courseDto);

        assertEquals(ResponseEntity.ok(courseDto), response);
        verify(courseService).updateCourse(id, courseDto);
    }

    @Test
    void deleteCourse_returnsDeletedCourse() {
        Long id = 1L;
        CourseDto courseDto = createCourseDto();
        when(courseService.deleteCourse(id)).thenReturn(courseDto);

        ResponseEntity<CourseDto> response = courseController.deleteCourse(id);

        assertEquals(ResponseEntity.ok(courseDto), response);
        verify(courseService).deleteCourse(id);
    }

    @Test
    void toggleActiveCourse_returnsToggledCourse() {
        Long id = 1L;
        CourseDto courseDto = createCourseDto();
        when(courseService.toggleActiveCourse(id)).thenReturn(courseDto);

        ResponseEntity<CourseDto> response = courseController.toggleActiveCourse(id);

        assertEquals(ResponseEntity.ok(courseDto), response);
        verify(courseService).toggleActiveCourse(id);
    }
}