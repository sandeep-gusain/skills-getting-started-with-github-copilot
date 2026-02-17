# GitHub Copilot Java Spring Boot Demo - Quick Start Guide

This repository contains a comprehensive Java Spring Boot demo project that demonstrates how to use GitHub Copilot for code generation and refactoring.

## 📁 Repository Structure

- **`src/`** - Python FastAPI demo (original exercise)
- **`java-demo/`** - Java Spring Boot demo (**NEW!**)

## 🚀 Getting Started with the Java Demo

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- GitHub Copilot extension (for VS Code or your IDE)

### Quick Start

1. **Navigate to the Java demo directory:**
   ```bash
   cd java-demo
   ```

2. **Build the project:**
   ```bash
   mvn clean install
   ```

3. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```

4. **Test the API endpoints:**
   ```bash
   # Get all students
   curl http://localhost:8080/api/students
   
   # Get all courses
   curl http://localhost:8080/api/courses
   
   # Create a new student
   curl -X POST http://localhost:8080/api/students \
     -H "Content-Type: application/json" \
     -d '{"name":"Jane Doe","email":"jane@example.com","major":"Physics"}'
   ```

## 🎯 What You'll Learn

The Java demo showcases:

1. **Code Generation with Copilot:**
   - Automatic generation of getters, setters, and constructors
   - RESTful endpoint creation with Spring annotations
   - Service layer method implementations

2. **Pattern Recognition:**
   - After creating one CRUD controller, Copilot suggests similar patterns
   - Consistent code style across the project

3. **Refactoring Examples:**
   - Separation of concerns (Controller → Service → Model)
   - Business logic extraction

4. **Real-World Examples:**
   - Complete REST API with CRUD operations
   - Student and Course management system
   - Input validation and error handling

## 📚 Detailed Documentation

For complete documentation, examples, and Copilot usage tips, see:
- [Java Demo README](java-demo/README.md)

## 🔗 Additional Resources

- [GitHub Copilot Documentation](https://docs.github.com/en/copilot)
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Original Python FastAPI Demo](src/README.md)

## 💡 Copilot Tips

1. **Write descriptive comments** - Copilot uses them as prompts
2. **Start with method signatures** - Let Copilot fill in the implementation
3. **Leverage patterns** - After one example, Copilot recognizes the pattern
4. **Review and refine** - Accept suggestions and modify as needed

---

**Happy Coding with GitHub Copilot! 🚀**
