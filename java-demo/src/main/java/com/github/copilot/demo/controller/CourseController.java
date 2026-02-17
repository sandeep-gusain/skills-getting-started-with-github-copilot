package com.github.copilot.demo.controller;

import com.github.copilot.demo.model.Course;
import com.github.copilot.demo.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Course REST Controller
 * 
 * Copilot Pattern Recognition Example:
 * After creating StudentController, Copilot recognizes the CRUD pattern
 * and can suggest similar implementations for CourseController
 * Simply typing method names like "getAllCourses" triggers intelligent suggestions
 */
@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        return courseService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        // Validate course and required fields
        if (course == null || course.getCode() == null || course.getName() == null) {
            return ResponseEntity.badRequest().build();
        }
        Course created = courseService.createCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course course) {
        return courseService.updateCourse(id, course)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        boolean deleted = courseService.deleteCourse(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/instructor/{instructor}")
    public ResponseEntity<List<Course>> getCoursesByInstructor(@PathVariable String instructor) {
        return ResponseEntity.ok(courseService.findByInstructor(instructor));
    }
}
