package com.github.copilot.demo.service;

import com.github.copilot.demo.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Student Service - Business logic layer
 * 
 * Copilot Usage Examples:
 * 1. Type: "// method to find student by id" and Copilot suggests the method signature
 * 2. Type: "// method to get all students" and Copilot generates the implementation
 * 3. Type: "// validate email format" and Copilot suggests email validation logic
 * 4. When you type a method name like "findById", Copilot suggests the entire implementation
 */
@Service
public class StudentService {

    private final List<Student> students = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public StudentService() {
        // Initialize with sample data
        students.add(new Student(idCounter.getAndIncrement(), "Alice Johnson", "alice@example.com", "Computer Science"));
        students.add(new Student(idCounter.getAndIncrement(), "Bob Smith", "bob@example.com", "Mathematics"));
        students.add(new Student(idCounter.getAndIncrement(), "Carol Davis", "carol@example.com", "Physics"));
    }

    // Get all students
    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    // Find student by ID
    public Optional<Student> findById(Long id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst();
    }

    // Create a new student
    public Student createStudent(Student student) {
        student.setId(idCounter.getAndIncrement());
        students.add(student);
        return student;
    }

    // Update existing student
    public Optional<Student> updateStudent(Long id, Student updatedStudent) {
        return findById(id).map(student -> {
            student.setName(updatedStudent.getName());
            student.setEmail(updatedStudent.getEmail());
            student.setMajor(updatedStudent.getMajor());
            return student;
        });
    }

    // Delete student
    public boolean deleteStudent(Long id) {
        return students.removeIf(student -> student.getId().equals(id));
    }

    // Search students by major
    public List<Student> findByMajor(String major) {
        if (major == null) {
            return new ArrayList<>();
        }
        return students.stream()
                .filter(student -> student.getMajor() != null && student.getMajor().equalsIgnoreCase(major))
                .toList();
    }

    // Validate email format - Copilot can help generate this
    public boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
}
