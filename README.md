# 🚀 Employee Management System (Spring Boot + JWT)

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.x-brightgreen)
![MySQL](https://img.shields.io/badge/MySQL-Database-blue)
![JWT](https://img.shields.io/badge/Auth-JWT-red)

---

## 📌 Project Overview

A **secure backend application** for managing employees with **JWT authentication**, **role-based access control**, and **analytics dashboard**.

This project demonstrates **real-world backend development skills** using Spring Boot.

---

## ✨ Features

### 🔐 Authentication & Security

* User Registration & Login
* JWT Token-based Authentication
* Role-Based Access Control (ADMIN / EMPLOYEE)
* Secure REST APIs

### 👨‍💼 Employee Management

* Create, Read, Update, Delete Employees
* Search Employees by Department

### 📊 Analytics Dashboard

* Total Employee Count
* Salary Statistics (Min, Max, Avg, Total)
* Department-wise Distribution

### ⚙️ Additional Features

* Global Exception Handling
* Logging using SLF4J
* Clean layered architecture

---

## 🏗️ Tech Stack

| Layer       | Technology            |
| ----------- | --------------------- |
| Backend     | Spring Boot           |
| Security    | Spring Security + JWT |
| Database    | MySQL                 |
| ORM         | Spring Data JPA       |
| Build Tool  | Maven                 |
| API Testing | Postman               |

---

## 📂 Project Structure

```bash
src/main/java/com/stackly/employee_management
│
├── controller      # REST Controllers
├── service         # Business Logic
├── repository      # Database Access
├── entity          # JPA Entities
├── security        # JWT & Security Config
├── exception       # Global Exception Handling
```

---

## 🔗 API Endpoints

### 🔐 Auth APIs

| Method | Endpoint       |
| ------ | -------------- |
| POST   | /auth/register |
| POST   | /auth/login    |

### 👨‍💼 Employee APIs

| Method | Endpoint            |
| ------ | ------------------- |
| GET    | /api/employees      |
| GET    | /api/employees/{id} |
| POST   | /api/employees      |
| PUT    | /api/employees/{id} |
| DELETE | /api/employees/{id} |

### 📊 Analytics APIs

| Method | Endpoint                 |
| ------ | ------------------------ |
| GET    | /api/analytics/dashboard |

---

## 🔄 Application Flow

```text
Client → AuthController → JWT Token
Client → JwtFilter → Validate Token → Controller → Service → Repository → DB
```

---

## ⚙️ Setup Instructions

### 1️⃣ Clone Repository

```bash
git clone https://github.com/tarunyendu-developer/employee-management-system.git
cd employee-management-system
```

### 2️⃣ Configure Database

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
```

### 3️⃣ Run Application

```bash
mvn spring-boot:run
```

---

## 📮 Postman Collection

Import the provided Postman collection:

```text
/postman/employee-management-postman.json
```

---

## 🗄️ Database Schema

```sql
CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE,
    password VARCHAR(255),
    role VARCHAR(20)
);

CREATE TABLE employees (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100),
    department VARCHAR(50),
    salary DOUBLE
);
```

---

## 📊 ER Diagram

![ER Diagram](docs/er-diagram.png)

---

## 🧪 Testing

* API testing done using Postman
* Basic unit tests implemented

---

## 🎥 Demo

👉 Add your video link here

---


## ⭐ If you like this project

Give it a ⭐ on GitHub!
