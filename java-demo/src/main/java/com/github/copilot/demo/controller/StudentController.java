package com.github.copilot.demo.controller;

import com.github.copilot.demo.model.Student;
import com.github.copilot.demo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Student REST Controller
 * 
 * Copilot Code Generation Examples:
 * 1. Type: "@GetMapping" and Copilot suggests the full endpoint with path
 * 2. Type: "// GET endpoint to retrieve all students" - Copilot generates the method
 * 3. Type: "// POST endpoint to create" - Copilot suggests the @PostMapping method
 * 4. After defining one CRUD operation, Copilot can suggest similar patterns for others
 * 5. Type: "ResponseEntity" and Copilot suggests proper HTTP status codes
 */
@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // GET all students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    // GET student by ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return studentService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST create new student
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        // Validate student and required fields
        if (student == null || student.getName() == null || student.getEmail() == null 
            || !studentService.isValidEmail(student.getEmail())) {
            return ResponseEntity.badRequest().build();
        }
        Student created = studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // PUT update existing student
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return studentService.updateStudent(id, student)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE student
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        boolean deleted = studentService.deleteStudent(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    // GET students by major
    @GetMapping("/major/{major}")
    public ResponseEntity<List<Student>> getStudentsByMajor(@PathVariable String major) {
        return ResponseEntity.ok(studentService.findByMajor(major));
    }
}
