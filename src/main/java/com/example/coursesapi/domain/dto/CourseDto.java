package com.example.coursesapi.domain.dto;

import com.example.coursesapi.domain.entities.Course;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

@Data

@JsonIgnoreProperties(ignoreUnknown = true)
public class CourseDto {

    private Long id;

    @NotNull( "Name is required")
    private String name;
    @NotNull("Category is required")
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
