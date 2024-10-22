package com.example.coursesapi.domain.repository;

import com.example.coursesapi.domain.entities.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {


    @Query("SELECT c FROM Course c WHERE (:name IS NULL OR c.name = :name) AND (:category IS NULL OR c.category = :category)")
    List<Course> findAllByNameOrCategory(@Param("name") String name, @Param("category") String category);
}
