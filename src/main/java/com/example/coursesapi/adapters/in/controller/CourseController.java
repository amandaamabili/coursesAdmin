package com.example.coursesapi.adapters.in.controller;

import com.example.coursesapi.domain.dto.CourseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.coursesapi.application.service.CourseService;

@RestController
@AllArgsConstructor
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<CourseDto> createCourse( @Validated @RequestBody CourseDto course) {
        try {
            CourseDto newCourse = courseService.createCourse(course);
            return ResponseEntity.ok(newCourse);
        }catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
