package com.example.coursesapi.domain.repository;

import com.example.coursesapi.domain.entities.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
}
