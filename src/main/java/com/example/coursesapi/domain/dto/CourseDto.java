package com.example.coursesapi.domain.dto;

import com.example.coursesapi.domain.entities.Course;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CourseDto {

    private Long id;

    @NotNull( message =  "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @NotNull(message = "Category is required")
    @Size(min = 2, max = 50, message = "Category must be between 2 and 50 characters")
    private String category;

    private boolean active;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;



    public CourseDto(Course savedCourse) {
        this.id = savedCourse.getId();
        this.name = savedCourse.getName();
        this.category = savedCourse.getCategory();
        this.active = savedCourse.isActive();
        this.createdAt = savedCourse.getCreatedAt();
        this.updatedAt = savedCourse.getUpdatedAt();
    }
}
