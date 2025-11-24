# Bank Account Management System 🏦

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-13+-blue)
![MongoDB](https://img.shields.io/badge/MongoDB-5.0+-green)
![License](https://img.shields.io/badge/License-MIT-yellow)
![Build](https://img.shields.io/badge/Build-Passing-success)

A modular and scalable banking management application built with Clean Architecture, supporting user registration, automatic bank account creation, currency management, local and forex transactions, and PDF statement generation.

## 🎯 Overview

This system provides a clean, maintainable, and extendable solution for managing users and bank accounts with advanced transactional capabilities.

It is designed following **Clean Architecture**, ensuring:
- High testability
- Strong separation of concerns
- Framework independence
- Database independence
- Maintainability over time

The system currently supports:
- User registration with automatic account creation
- Multi-currency support
- Role-based access control
- Local and Forex transactions
- PDF bank statement generation
- Transaction logging with AOP

## ✨ Key Features

### ✔ 1. User Registration & Account Creation

When a user registers:
- A bank account is **automatically created**
- The account is initialized with:
  - Balance = 0
  - A generated account number
  - The chosen currency
  - Creation date
  - Active status
- Users are assigned roles (Client, Manager)

### ✔ 2. Bank Account Management

- Each user can have multiple accounts
- Each account is associated with:
  - Currency (EUR, MAD, USD, etc.)
  - Active / inactive status
  - Creation date
  - Unique account number
  - Current balance

### ✔ 3. User Account Blocking

- Users can be **blocked** by administrators
- **Blocked users cannot**:
  - Perform any banking transactions
  - Transfer money
  - Access certain features
- Account status is checked before every operation

### ✔ 4. Banking Transactions

The system supports two types of transactions:

#### 📍 Local Transactions
- Transfers between accounts with the **same currency**
- Instant processing
- Real-time balance updates
- Validation checks:
  - Sufficient balance
  - Account not blocked
  - Valid account numbers

#### 🌍 Forex Transactions
- Cross-currency transfers between accounts with **different but valid currencies**
- Automatic exchange rate application
- Support for multiple currencies
- Additional validations:
  - Compatible currency pairs
  - Current exchange rates
  - Market availability

**Transaction Security & Logging:**
- All transactions are logged in **MongoDB** (separate from SQL data)
- Custom `@TrackTransaction` **AOP annotation** automatically captures:
  - Transaction type
  - Amount and currencies
  - Timestamp
  - User information
  - Success/failure status
- Transactional integrity with rollback support

### ✔ 5. Bank Statement Generation

- Users can generate detailed account statements
- Statement includes:
  - Account information
  - Transaction history (filtered by date range)
  - Opening and closing balances
  - Transaction types and amounts
- **Export to PDF** with professional formatting
- Download or email options

### ✔ 6. Multi-Currency Support

- Each bank account has its own currency
- Supported currencies: EUR, MAD, USD, GBP, etc. (customizable)
- Real-time exchange rate management
- Currency validation before transactions

### ✔ 7. Role-Based System

Users can have roles such as:
- **Client**: Standard banking operations
- **Manager/Admin**: Administrative functions, user blocking, system monitoring

Used for access control and permission management via Spring Security.

## 🏗️ Architecture

This project fully follows **Clean Architecture** principles:
- **UI and database** can be changed without touching domain logic
- **Business rules** are fully isolated in the domain layer
- **Highly testable** - each layer can be tested independently
- **Framework independence** - business logic doesn't depend on Spring
- **Database independence** - easy to switch between databases


**Layer Descriptions:**

🔵 **Presentation Layer** (Blue)
- REST Controllers handling HTTP requests
- Input validation and response formatting
- No business logic

🟡 **Application Layer** (Yellow)
- Use Cases implementing business workflows
- DTOs for data transfer
- Mappers for entity/DTO conversion
- Orchestrates domain logic

🟣 **Infrastructure Layer** 
- Adapters for external systems
- Database repositories (JPA & MongoDB)
- AOP aspects for cross-cutting concerns
- PDF generation service
- Technical implementations

🟢 **Domain Layer** 
- Core business entities
- Business rules and logic
- No dependencies on outer layers
- Framework-agnostic



## 🛠️ Technologies

### Backend
- **Java 17+**
- **Spring Boot 3.x**
- **Spring Data JPA** - SQL persistence
- **Spring Data MongoDB** - Transaction logs
- **Spring AOP** - Transaction logging
- **Clean Architecture**

### Databases
- **PostgreSQL** (or MySQL) - Main relational data
- **MongoDB** - Transaction history and audit logs

### Tools & Libraries
- **Maven** - Build & dependency management
- **Lombok** - Reduce boilerplate
- **MapStruct** - DTO mapping (optional)
- **iText** or **Apache PDFBox** - PDF generation


## 🚀 Getting Started

### Prerequisites
```bash
Java 17+
Maven 3.8+
PostgreSQL 13+
MongoDB 5.0+

```

### Installation

1. **Clone the repository**
```bash
git clone https://github.com/AyaSaidii/banking-management-system.git
cd bank-account-management
```

2. **Configure PostgreSQL**

Create database:
```sql
CREATE DATABASE bank_accounts;
```

3. **Configure application.properties**

Edit `
