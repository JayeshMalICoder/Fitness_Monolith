🏋️ Fitness Monolith
A Spring Boot REST API for tracking user fitness activities with JWT authentication, role-based access control, and an AI-powered recommendation module.

📋 Table of Contents
About
Tech Stack
Features
Project Structure
API Endpoints
Getting Started
Environment Setup
Authentication Flow
Roles

📖 About
Fitness Monolith is a backend application that allows users to:

Register and authenticate securely
Track fitness activities
Store flexible workout metadata (sets, reps, exercises)

The system is designed using a layered architecture and follows best practices like DTO usage and JWT security.

⚙️ Tech Stack
Technology	Version
Java	21
Spring Boot	4.0.3
Spring Security	—
Spring Data JPA	—
MySQL	—
JJWT	0.13.0
Lombok	—
Maven	—
Docker	—

🚀 Features
🔐 JWT Authentication & Authorization
👤 User Registration & Login
🏃 Activity Tracking (with flexible JSON metadata)
🤖 AI-Based Recommendation System
🧱 Clean Layered Architecture (Controller → Service → Repository)
🐳 Docker Support (Deployment Ready)

📁 Project Structure
src/main/java/com/project/fitness_monolith/
│
├── controller/
│   ├── AuthController.java
│   ├── ActivityController.java
│   └── RecommendationController.java
│
├── service/
│   ├── UserService.java
│   ├── ActivityService.java
│   └── RecommendationService.java
│
├── repository/
│   ├── UserRepository.java
│   ├── ActivityRepository.java
│   └── RecommendationRepository.java
│
├── model/
│   ├── User.java
│   ├── Activity.java
│   ├── Recommendation.java
│   ├── ActivityType.java
│   └── UserRole.java
│
├── dto/
│   ├── RegisterRequest.java
│   ├── LoginRequest.java
│   ├── LoginResponse.java
│   ├── UserResponse.java
│   ├── ActivityRequest.java
│   ├── ActivityResponse.java
│   └── RecommendationRequest.java
│
└── security/
    ├── SecurityConfig.java
    ├── JwtUtils.java
    ├── JwtAuthenticationFilter.java
    └── CustomUserDetailsService.java
    
🔌 API Endpoints

🔑 Auth — /api/auth

Method	Endpoint	Description	Auth Required
POST	/api/auth/register	Register a new user	❌
POST	/api/auth/login	Login & get JWT token	❌

Register Request
{
  "email": "user@example.com",
  "password": "yourpassword",
  "firstname": "John",
  "lastname": "Doe",
  "role": "USER"
}

Login Response

{
  "token": "jwt-token",
  "user": {
    "id": "uuid",
    "email": "user@example.com",
    "firstname": "John",
    "lastname": "Doe"
  }
}

🏃 Activities — /api/activities
Requires: Authorization: Bearer <token>

Method	  Endpoint	   Description
POST	/api/activities	Log new activity
GET	/api/activities	Get all activities
Request Body
{
  "userId": "uuid",
  "type": "WEIGHT_TRAINING",
  "duration": 45,
  "caloriesBurned": 300,
  "startTime": "2026-03-16T11:27:51",
  "additionalMetrics": {
    "exercise": ["BenchPress", "DeadLifts"],
    "sets": 12,
    "reps": 120
  }
}

🤖 Recommendations — /api/recommendation
Method	       Endpoint	             Description
POST	/api/recommendation/generate	Generate recommendation
GET	/api/recommendation/user/{userId}	Get by user
GET	/api/recommendation/activity/{activityId}	Get by activity

🛠️ Getting Started

Prerequisites
Java 21
Maven
MySQL

1. Clone Repository
git clone https://github.com/your-username/fitness-monolith.git
cd fitness-monolith

3. Create Database
CREATE DATABASE fitness_demo;

4. Configure Application
spring.datasource.url=jdbc:mysql://localhost:3306/fitness_demo
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

4. Run Application
mvn spring-boot:run

👉 Server runs at: http://localhost:8080

🔐 Environment Setup
Move secrets to environment variables:

jwt.secret=your-secret-key
jwt.expiration=172800000

🔄 Authentication Flow
Client → POST /api/auth/login
       ← JWT Token

Client → Protected API
       → Authorization: Bearer <token>
       ← Response
       
👥 Roles
Role	Permissions
USER	Manage own activities
ADMIN	Access admin APIs

📈 Future Improvements
Add Swagger API Documentation
Add Input Validation (@Valid)
Build Frontend (React)
Convert to Microservices Architecture

📜 License
This project is licensed under the MIT License.
