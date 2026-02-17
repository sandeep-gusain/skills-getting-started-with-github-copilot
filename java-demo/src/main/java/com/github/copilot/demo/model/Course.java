package com.github.copilot.demo.model;

/**
 * Course model class
 * 
 * Copilot Refactoring Example:
 * - Original: Had separate variables for courseCode and courseName
 * - Refactored: Combined into a cohesive Course class
 * - Copilot helped generate the boilerplate code quickly
 */
public class Course {
    private Long id;
    private String code;
    private String name;
    private String instructor;
    private int credits;

    public Course() {
    }

    public Course(Long id, String code, String name, String instructor, int credits) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.instructor = instructor;
        this.credits = credits;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", instructor='" + instructor + '\'' +
                ", credits=" + credits +
                '}';
    }
}
