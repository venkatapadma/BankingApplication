🏦 Banking Application

A full‑stack backend banking application built using Spring Boot 4, Spring Data JPA (Hibernate), MySQL, and Java 25,
following SOLID principles and clean architecture best practices.

This application exposes RESTful APIs to manage bank accounts and transactions such as create account, deposit,
withdraw, view accounts, delete account, with global exception handling using @ControllerAdvice.
<img width="950" height="1001" alt="image" src="https://github.com/user-attachments/assets/bb4933cd-2f9c-4497-b6d3-88b519bf05c1" />

<img width="1776" height="1059" alt="Screenshot 2026-05-11 at 11 14 51" src="https://github.com/user-attachments/assets/dd16c118-c2f9-4288-8af1-abb25f740818" />

<img width="1786" height="1063" alt="Screenshot 2026-05-11 at 11 15 52" src="https://github.com/user-attachments/assets/b0455c69-a705-4f14-ba08-e3b4ef1588b9" />


🚀 Tech Stack

Java 25,
Spring Boot 4.x,
Spring Data JPA (Hibernate),
MySQL Database,
Maven,
REST APIs,
JUnit,
CI/CD,
Docker,
Kubernetes,
Swagger,
Open API documentation,
Prometheus,
Grafana,
OpenTelemtry

📌 Features

✅ Account Management

Create a new bank account
Get account details by account number
Get all bank accounts
Delete a bank account

✅ Transactions

Deposit money into an account
Withdraw money from an account
Balance validation and business rules

✅ Exception Handling

Centralized exception handling using @ControllerAdvice
Custom exceptions for:

Account not found
Insufficient balance
Invalid transaction

Meaningful HTTP status codes and error messages

✅ Architecture & Design

Layered architecture:

Controller
Service
Repository

SOLID principles applied
Clean separation of concerns
Transaction management with Spring

📘 API Documentation (Swagger / OpenAPI)
The application includes Swagger/OpenAPI documentation using Springdoc OpenAPI, providing interactive and self‑describing REST APIs.

Automatically generates OpenAPI 3.0 specification from controller annotations
Interactive Swagger UI for testing APIs without external tools
Improves developer onboarding and API discoverability

Access Swagger UI
http://localhost:8080/swagger-ui.html

Access OpenAPI Specification
http://localhost:8080/v3/api-docs


🐳 Docker Support
The application is fully containerized using Docker to ensure consistent execution across development, CI, and production environments.
Docker Capabilities

Lightweight production-ready Docker image
Externalized configuration via environment variables
Supports local development and cloud deployments
Compatible with CI/CD and Kubernetes workflows

Run Using Docker Compose
Shelldocker compose up -dShow more lines
This starts:

Banking Application
MySQL database
with correct networking and environment configuration.


🚀 CI/CD Pipeline
The project includes a CI/CD pipeline to automate build and delivery processes.
CI/CD Highlights

Implemented using GitHub Actions
Automated steps:

Code checkout
Build and test with Maven
Docker image creation
Push image to container registry


Ensures every change is validated before release

Benefits

Faster feedback cycles
Reduced manual errors
Repeatable and reliable deployments


☸️ Kubernetes Support

The application is Kubernetes‑ready and supports cloud‑native deployment patterns.
Kubernetes Features

Kubernetes Deployment for application pods
Service abstraction for internal/external access
Horizontal scaling via replicas
Health checks powered by Spring Boot Actuator
Rolling updates with zero downtime

Kubernetes Readiness

Designed for container orchestration
Environment‑driven configuration
Compatible with Ingress controllers and service meshes


▶️ How to Run the Application

Clone the repository

git clone https://github.com/venkatapadma/BankingApplication.git

Create MySQL database:
SQL

CREATE DATABASE banking_db;

Update application.properties
Run the application:
Shell
mvn spring-boot:runShow more lines

Access APIs via Postman or browser

✅ Future Enhancements

Authentication & Authorization (Spring Security, JWT)

Transaction history

Pagination & sorting
