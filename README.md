# ⚽ LiveScoreBoard – Backend Service

A Java-based backend service for the LiveScoreBoard application, built with **Spring Boot, MongoDB, REST APIs, and WebClient**.

The service provides the backend architecture required to manage football-related application data and support the LiveScoreBoard React frontend.

## 🎯 Project Overview

The LiveScoreBoard Service is the backend component of the LiveScoreBoard application.

It follows a layered Spring architecture separating controllers, services, repositories, entities, DTOs, and data-access components.

The project is configured with **Java 21**, Spring Boot Web, Spring Data MongoDB, Lombok, and Spring WebClient.

## 🏗️ Architecture

The backend is organized into separate application layers:

```text
Client / React Frontend
          ↓
     REST Controllers
          ↓
       Services
          ↓
     Repositories
          ↓
       MongoDB
```

Supporting components include:

* DAO
* DTO
* Entity
* Configuration
* Repository
* Service
* Controller

These components are organized under the main `LiveScoreBoardService` package.

## 🔧 Technology Stack

### Backend

* **Java 21**
* **Spring Boot**
* Spring Web
* Spring Data MongoDB
* REST APIs
* WebClient
* Lombok
* Maven

### Database

* **MongoDB**

### Development

* Maven Wrapper
* Spring Boot Maven Plugin
* Docker Compose configuration

The Maven configuration defines Spring Web, Spring Data MongoDB, Lombok, and WebClient dependencies and targets Java 21.

## 📁 Project Structure

```text
LiveScoreBoard-Service/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── LiveScoreBoardService/
│       │           ├── Dao/
│       │           ├── Dto/
│       │           ├── configuration/
│       │           ├── controller/
│       │           ├── entity/
│       │           ├── repository/
│       │           ├── service/
│       │           └── LiveScoreBoardService.java
│       │
│       └── resources/
│           └── application.properties
│
├── compose.yaml
├── pom.xml
├── mvnw
└── mvnw.cmd
```

The repository contains the Spring Boot application source, configuration, Maven build files, and Docker Compose configuration.

## 🔄 Backend Responsibilities

The service is designed to support the football application by handling backend operations such as:

* Exposing REST endpoints
* Managing football-related data
* Persisting application data in MongoDB
* Separating business logic from data access
* Communicating with external services through WebClient
* Providing structured data to the React frontend

## 🚀 Getting Started

### Clone the repository

```bash
git clone https://github.com/uddiptagogoi/LiveScoreBoard-Service.git
cd LiveScoreBoard-Service
```

### Build the project

```bash
./mvnw clean install
```

On Windows:

```bash
mvnw.cmd clean install
```

### Run the application

```bash
./mvnw spring-boot:run
```

On Windows:

```bash
mvnw.cmd spring-boot:run
```

### Database

The application uses MongoDB through Spring Data MongoDB.

Database configuration can be found in:

```text
src/main/resources/application.properties
```

## 🔗 Frontend Application

The React frontend for this service is available here:

https://github.com/uddiptagogoi/LiveScoreBoard-app

## 📈 Skills Demonstrated

* Java development
* Spring Boot
* REST API development
* MongoDB
* Spring Data
* Backend architecture
* Layered application design
* WebClient
* Maven
* Frontend/backend integration
* API-driven application development

## 🔗 Project Repository

https://github.com/uddiptagogoi/LiveScoreBoard-Service

## 👨‍💻 About

This project demonstrates practical experience building a Java/Spring Boot backend service and integrating it with a React frontend to create a full-stack football application.
