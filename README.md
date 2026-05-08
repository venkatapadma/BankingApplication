🏦 Banking Application

A full‑stack backend banking application built using Spring Boot 4, Spring Data JPA (Hibernate), MySQL, and Java 25,
following SOLID principles and clean architecture best practices.

This application exposes RESTful APIs to manage bank accounts and transactions such as create account, deposit,
withdraw, view accounts, delete account, with global exception handling using @ControllerAdvice.

🚀 Tech Stack

Java 25,
Spring Boot 4.x,
Spring Data JPA (Hibernate),
MySQL Database,
Maven,
REST APIs,
JUnit.

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

🧱 Application Architecture
controller

└── AccountController

service

├── AccountService

└── impl

repository

└── AccountRepository

entity

└── Account

exception

├── AccountNotFoundException

├── InsufficientBalanceException

└── GlobalExceptionHandler (@ControllerAdvice)

dto

└── AccountDto

mapper

└── AccountMapper

🔑 Core APIs

➕ Create Account
POST /api/accounts

💰 Deposit Amount
PUT /api/accounts/{id}/deposit

💸 Withdraw Amount
PUT /api/accounts/{id}/withdraw

📄 Get Account by ID
GET /api/accounts/{id}

📋 Get All Accounts
GET /api/accounts

❌ Delete Account
DELETE /api/accounts/{id}

⚠️ Exception Handling (Controller Advice)
All exceptions are handled centrally using @ControllerAdvice.
Examples:

AccountNotFoundException → 404 NOT FOUND

InsufficientBalanceException → 400 BAD REQUEST

Generic Exception → 500 INTERNAL SERVER ERROR

This ensures:
✅ Clean controllers
✅ Consistent error responses
✅ Better maintainability

🧠 SOLID Principles Applied

S – Single Responsibility
Each class has one responsibility (Controller, Service, Repository).

O – Open/Closed
Business logic can be extended without modifying existing code.

L – Liskov Substitution
Interfaces and implementations follow contract rules.

I – Interface Segregation
Clean service interfaces without unnecessary methods.

D – Dependency Inversion
Services depend on abstractions, not implementations.

▶️ How to Run the Application

Clone the repository
git
clone [https://github.com/your-username/BankingApplication.git](https://github.com/venkatapadma/BankingApplication.git)

Create MySQL database:
SQLCREATE DATABASE banking_db;

Update application.properties
Run the application:
Shell
mvn spring-boot:runShow more lines

Access APIs via Postman or browser

✅ Future Enhancements

Authentication & Authorization (Spring Security, JWT)

Transaction history

Pagination & sorting

Swagger / OpenAPI documentation

Docker support
