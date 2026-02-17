package com.github.copilot.demo.service;

import com.github.copilot.demo.model.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Course Service - Business logic layer
 * 
 * Copilot Refactoring Example:
 * Original approach: All CRUD operations were in the controller
 * Refactored: Moved business logic to service layer (separation of concerns)
 * Copilot helped quickly generate the service methods following the pattern
 */
@Service
public class CourseService {

    private final List<Course> courses = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public CourseService() {
        // Initialize with sample data
        courses.add(new Course(idCounter.getAndIncrement(), "CS101", "Introduction to Programming", "Dr. Smith", 3));
        courses.add(new Course(idCounter.getAndIncrement(), "MATH201", "Calculus II", "Prof. Johnson", 4));
        courses.add(new Course(idCounter.getAndIncrement(), "PHY301", "Quantum Mechanics", "Dr. Brown", 4));
    }

    public List<Course> getAllCourses() {
        return new ArrayList<>(courses);
    }

    public Optional<Course> findById(Long id) {
        return courses.stream()
                .filter(course -> course.getId().equals(id))
                .findFirst();
    }

    public Course createCourse(Course course) {
        course.setId(idCounter.getAndIncrement());
        courses.add(course);
        return course;
    }

    public Optional<Course> updateCourse(Long id, Course updatedCourse) {
        return findById(id).map(course -> {
            course.setCode(updatedCourse.getCode());
            course.setName(updatedCourse.getName());
            course.setInstructor(updatedCourse.getInstructor());
            course.setCredits(updatedCourse.getCredits());
            return course;
        });
    }

    public boolean deleteCourse(Long id) {
        return courses.removeIf(course -> course.getId().equals(id));
    }

    public List<Course> findByInstructor(String instructor) {
        if (instructor == null) {
            return new ArrayList<>();
        }
        return courses.stream()
                .filter(course -> course.getInstructor() != null && course.getInstructor().equalsIgnoreCase(instructor))
                .toList();
    }
}
