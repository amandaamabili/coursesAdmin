package com.example.coursesapi.application.service.implementation;

import com.example.coursesapi.domain.dto.CourseDto;
import com.example.coursesapi.domain.entities.Course;
import com.example.coursesapi.domain.repository.CourseRepository;
import com.example.coursesapi.exception.CourseNotFoundException;
import com.example.coursesapi.utils.CourseUtils;
import org.springframework.stereotype.Service;
import com.example.coursesapi.application.service.CourseService;

import java.util.List;

import static com.example.coursesapi.utils.CourseUtils.getNewCourse;

@Service
public class CourseServiceImp implements CourseService {

    private final CourseRepository courseRepository;
    public CourseServiceImp(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public CourseDto createCourse(CourseDto course) {
            Course newCourse = getNewCourse(course);
            Course savedCourse = courseRepository.save(newCourse);
            return new CourseDto(savedCourse);
    }

    @Override
    public List<CourseDto> getCourse( String name, String category) {
            List<Course> course = courseRepository.findAllByNameOrCategory(name, category);
            return course.stream().map(CourseDto::new).toList();

    }

    @Override
    public CourseDto updateCourse(Long id, CourseDto course) {
        Course courseToUpdate = courseRepository.findById(id).orElseThrow(()
                -> new CourseNotFoundException(id));
        CourseUtils.updateCourse(course, courseToUpdate);
        Course savedCourse = courseRepository.save(courseToUpdate);
        return new CourseDto(savedCourse);
    }

    @Override
    public CourseDto deleteCourse(Long id) {
        Course courseToDelete = courseRepository.findById(id).orElseThrow(()
                -> new CourseNotFoundException(id));
        courseRepository.deleteById(id);
        return new CourseDto(courseToDelete);
    }

    @Override
    public CourseDto toggleActiveCourse(Long id) {
        Course courseToUpdate = courseRepository.findById(id).orElseThrow(()
                -> new CourseNotFoundException(id));
        courseToUpdate.setActive(!courseToUpdate.isActive());
        Course savedCourse = courseRepository.save(courseToUpdate);
        return new CourseDto(savedCourse);
    }
}
