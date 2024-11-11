package com.example.coursesapi.application.service.implementation;

import com.example.coursesapi.domain.dto.CourseDto;
import com.example.coursesapi.domain.entities.Course;
import com.example.coursesapi.domain.repository.CourseRepository;
import com.example.coursesapi.exception.CourseNotFoundException;
import com.example.coursesapi.utils.CourseUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static com.example.coursesapi.testUtils.TestUtils.createCourseDto;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class CourseServiceImpTest {

    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private CourseServiceImp courseServiceImp;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createCourse_createsAndReturnsCourse() {
        CourseDto courseDto = createCourseDto();
        Course course = new Course();

        try (var mockedCourseUtils = mockStatic(CourseUtils.class)) {
            mockedCourseUtils.when(() -> CourseUtils.getNewCourse(courseDto)).thenReturn(course);
            when(courseRepository.save(course)).thenReturn(course);

            CourseDto result = courseServiceImp.createCourse(courseDto);

            assertNotNull(result);
            verify(courseRepository).save(course);
        }
    }

    @Test
    void getCourse_returnsCoursesByNameOrCategory() {
        String name = "testName";
        String category = "testCategory";
        List<Course> courses = List.of(new Course());
        when(courseRepository.findAllByNameOrCategory(name, category)).thenReturn(courses);

        List<CourseDto> result = courseServiceImp.getCourse(name, category);

        Assertions.assertFalse(result.isEmpty());
        verify(courseRepository).findAllByNameOrCategory(name, category);
    }

    @Test
    void updateCourse_updatesAndReturnsCourse() {
        Long id = 1L;
        CourseDto courseDto = createCourseDto();
        Course course = new Course();
        when(courseRepository.findById(id)).thenReturn(Optional.of(course));
        when(courseRepository.save(course)).thenReturn(course);

        CourseDto result = courseServiceImp.updateCourse(id, courseDto);

        assertNotNull(result);
        verify(courseRepository).save(course);
    }

    @Test
    void updateCourse_throwsExceptionWhenCourseNotFound() {
        Long id = 1L;
        CourseDto courseDto =  createCourseDto();
        when(courseRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(CourseNotFoundException.class, () -> courseServiceImp.updateCourse(id, courseDto));
    }

    @Test
    void deleteCourse_deletesAndReturnsCourse() {
        Long id = 1L;
        Course course = new Course();
        when(courseRepository.findById(id)).thenReturn(Optional.of(course));

        CourseDto result = courseServiceImp.deleteCourse(id);

        assertNotNull(result);
        verify(courseRepository).deleteById(id);
    }

    @Test
    void deleteCourse_throwsExceptionWhenCourseNotFound() {
        Long id = 1L;
        when(courseRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(CourseNotFoundException.class, () -> courseServiceImp.deleteCourse(id));
    }

    @Test
    void toggleActiveCourse_togglesAndReturnsCourse() {
        Long id = 1L;
        Course course = new Course();
        course.setActive(false);
        when(courseRepository.findById(id)).thenReturn(Optional.of(course));
        when(courseRepository.save(course)).thenReturn(course);

        CourseDto result = courseServiceImp.toggleActiveCourse(id);

        assertTrue(result.isActive());
        verify(courseRepository).save(course);
    }

    @Test
    void toggleActiveCourse_throwsExceptionWhenCourseNotFound() {
        Long id = 1L;
        when(courseRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(CourseNotFoundException.class, () -> courseServiceImp.toggleActiveCourse(id));
    }
}
