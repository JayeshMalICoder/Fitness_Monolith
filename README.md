# 🏋️ Fitness Monolith

A **Spring Boot REST API** for tracking user fitness activities with JWT authentication, role-based access control, and an  recommendation module.

---

## 📋 Table of Contents

- [About](#about)
- [Tech Stack](#tech-stack)
- [Features](#features)
- [Project Structure](#project-structure)
- [API Endpoints](#api-endpoints)
- [Getting Started](#getting-started)
- [Environment Setup](#environment-setup)
- [Authentication Flow](#authentication-flow)
- [Roles](#roles)

---

## 📖 About

Fitness Monolith is a backend application that allows users to:

- Register and authenticate securely  
- Track fitness activities  
- Store flexible workout metadata (sets, reps, exercises)  

The system is designed using a **layered architecture** and follows best practices like **DTO usage and JWT security**.

---

## ⚙️ Tech Stack

| Technology | Version |
|------------|--------|
| Java | 21 |
| Spring Boot | 4.0.3 |
| Spring Security | — |
| Spring Data JPA | — |
| MySQL | — |
| JWT | 0.13.0 |
| Lombok | — |
| Maven | — |
| Docker | — |

---

## 🚀 Features

- 🔐 JWT Authentication & Authorization  
- 👤 User Registration & Login  
- 🏃 Activity Tracking (with flexible JSON metadata)    
- 🧱 Clean Layered Architecture (Controller → Service → Repository)  
- 🐳 Docker Support (Deployment Ready)  

---

## 📁 Project Structure

```
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
```

---

## 🔌 API Endpoints

### 🔑 Auth — `/api/auth`

| Method | Endpoint | Description | Auth Required |
|--------|----------|------------|--------------|
| POST | `/api/auth/register` | Register a new user | ❌ |
| POST | `/api/auth/login` | Login & get JWT token | ❌ |

#### Register Request

```json
{
  "email": "user@example.com",
  "password": "yourpassword",
  "firstname": "John",
  "lastname": "Doe",
  "role": "USER"
}
```

#### Login Response

```json
{
  "token": "jwt-token",
  "user": {
    "id": "uuid",
    "email": "user@example.com",
    "firstname": "John",
    "lastname": "Doe"
  }
}
```

---

### 🏃 Activities — `/api/activities`

> Requires: `Authorization: Bearer <token>`

| Method | Endpoint | Description |
|--------|----------|------------|
| POST | `/api/activities` | Log new activity |
| GET | `/api/activities` | Get all activities |

#### Request Body

```json
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
```

---

### 🤖 Recommendations — `/api/recommendation`

| Method | Endpoint | Description |
|--------|----------|------------|
| POST | `/api/recommendation/generate` | Generate recommendation |
| GET | `/api/recommendation/user/{userId}` | Get by user |
| GET | `/api/recommendation/activity/{activityId}` | Get by activity |

---

## 🛠️ Getting Started

### Prerequisites

- Java 21  
- Maven  
- MySQL  

---

### Clone Repository

```bash
git clone https://github.com/your-username/fitness-monolith.git
cd fitness-monolith
```

---

### Create Database

```sql
CREATE DATABASE fitness_demo;
```

---

### Configure Application

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/fitness_demo
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

---

### Run Application

```bash
mvn spring-boot:run
```

👉 Server runs at: `http://localhost:8080`

---

## 🔐 Environment Setup

Move secrets to environment variables:

```properties
jwt.secret=your-secret-key
jwt.expiration=172800000
```

---

## 🔄 Authentication Flow

```
Client → POST /api/auth/login
       ← JWT Token

Client → Protected API
       → Authorization: Bearer <token>
       ← Response
```

---

## 👥 Roles

| Role | Permissions |
|------|------------|
| USER | Manage own activities |
| ADMIN | Access admin APIs |

---

## 📈 Future Improvements

- Add Swagger API Documentation  
- Add Input Validation (`@Valid`)  
- Build Frontend (React)  
- Convert to Microservices Architecture  

---

## 📜 License

This project is licensed under the **MIT License**.

