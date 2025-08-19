Task Management API
A RESTful API for managing tasks with user authentication, built with Spring Boot and Java. This project shows modern backend development
practices including REST API design, database integration, and secure management.

Features:
1. User Management: User registration with encrypted passwords
2. Task CRUD Operations: Create, read, update, and delete tasks
3. Task Filtering: Filter tasks by status and priority
4. Data Validation: Input validation with proper error handling
5. Database Intergation: JPA/Hibernate with H2 (Development) and SQL support (production)
6. RESTful Design: Clean API endpoints following REST conventions

Tech Stack:
Java 21, Spring Boot, Spring Security, Spring Data JPA, H2 Database, Maven, and Bean Validation

API Endpoints:
User Management
  POST /api/users/register #Register a new User
  GET /api/users/{email} #Get User by email
Task Management
  GET /api/tasks #Get all user tasks
  POST /api/tasks #Create a new task
  GET /api/tasks/{id} #Get specific task
  PUT /api/tasks/{id} #Update a task
  DELETE /api/tasks/{id} #Delete a task
Task Filtering
  GET /api/tasks/status/{status} #Get tasks by status (TODO, IN_PROGRESS, COMPLETED)
  GET /api/tasks/priority/{priority} #Get tasks by priority (LOW, MEDIUM, HIGH, URGENT)

To use clone the repository and run the application: mvn spring-boot:run

Jacob Balula
