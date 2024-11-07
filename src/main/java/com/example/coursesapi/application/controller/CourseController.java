package com.example.coursesapi.application.controller;

import com.example.coursesapi.domain.dto.CourseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.coursesapi.application.service.CourseService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<CourseDto> createCourse( @Validated @RequestBody CourseDto course) {
            CourseDto newCourse = courseService.createCourse(course);
            return ResponseEntity.ok(newCourse);
    }

    @GetMapping
    public ResponseEntity<List<CourseDto>> getCourse(@RequestParam(required = false) String name, @RequestParam(required = false) String category) {
            List<CourseDto> newCourse = courseService.getCourse(name, category);
            return ResponseEntity.ok(newCourse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDto> updateCourse(@PathVariable Long id, @Validated @RequestBody CourseDto course) {
            CourseDto newCourse = courseService.updateCourse(id, course);
            return ResponseEntity.ok(newCourse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CourseDto> deleteCourse(@PathVariable Long id) {
            CourseDto newCourse = courseService.deleteCourse(id);
            return ResponseEntity.ok(newCourse);
    }


     @PatchMapping("/{id}/active")
     public ResponseEntity<CourseDto> toggleActiveCourse(@PathVariable Long id) {
             CourseDto newCourse = courseService.toggleActiveCourse(id);
             return ResponseEntity.ok(newCourse);
         }
}
