# Event Management System

## Project Overview

This is a **Spring Boot-based Event Management System** developed by **Amrit Acharya** as a project for **BCA Semester 7**. The application provides a RESTful API to manage events, attendees, and user authentication. It includes features for user registration, login, event creation, attendee registration, event/attendee management, and updating events/attendees, secured with JWT-based authentication.

The project leverages **Spring Boot**, **Spring Security**, **JPA/Hibernate**, and **MySQL** to implement a robust backend system. The API endpoints return standardized JSON responses with appropriate HTTP status codes.

---

## Features

- 🔐 **User Authentication**: Register and login with JWT-based authentication.
- 📅 **Event Management**: Create, retrieve, update, and delete events.
- 👥 **Attendee Management**: Register, retrieve, update, and delete attendees.
- 🛡️ **Security**: Passwords are hashed with BCrypt, and endpoints are protected with JWT.
- ⚠️ **Error Handling**: Consistent JSON responses using a custom `ApiResponse` wrapper.

---

## Technologies Used

- **Spring Boot**
- **Spring Security**
- **Spring Data JPA (Hibernate)**
- **MySQL**
- **JWT (JSON Web Tokens)**
- **Maven**

---

## Prerequisites

- Java 17+
- Maven 3.6+
- MySQL or compatible database
- IDE (e.g., IntelliJ, Eclipse)
- Postman or API testing tool

---

## Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/Amrit-Acharya1/Event-Management-Api-Spring-Boot.git
cd event-management-system
```

### 2. Configure the Database

Create the database:

```sql
CREATE DATABASE event_management;
```

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/event_management
spring.datasource.username=your-username
spring.datasource.password=your-password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3. Configure JWT Secret

Open `JwtUtil.java` and replace:

```java
private final String SECRET_KEY = "your-256-bit-secret-key-here";
```

### 4. Build and Run the Application

```bash
mvn clean install
mvn spring-boot:run
```

### 5. Test the API

- Register via `/api/auth/register`
- Login via `/api/auth/login` → receive JWT token
- Include JWT in header: `Authorization: Bearer <token>`

---

## API Endpoints Overview

### Authentication (`/api/auth`)
- `POST /register` – Register new user
- `POST /login` – Authenticate and receive JWT

### Events (`/api/events`)
- `POST /` – Create new event
- `GET /` – List all events
- `GET /{id}` – Retrieve event by ID
- `PUT /{id}` – Update event
- `DELETE /{id}` – Delete event

### Attendees (`/api/attendees`)
- `POST /` – Register attendee
- `GET /` – List all attendees
- `GET /{id}` – Retrieve attendee by ID
- `PUT /{id}` – Update attendee
- `DELETE /{id}` – Delete attendee

---

## Project Structure

```
event-management-system/
├── src/
│   ├── main/java/com/eventmanagement/
│   │   ├── config/
│   │   ├── controller/
│   │   ├── dto/
│   │   ├── entity/
│   │   ├── exception/
│   │   ├── repository/
│   │   ├── service/
│   │   └── util/
│   └── resources/
│       └── application.properties
├── pom.xml
└── README.md
```

---

## Dependencies (`pom.xml`)

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.33</version>
    </dependency>
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt</artifactId>
        <version>0.9.1</version>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

---

## Notes

- Store secrets like JWT key securely (e.g., environment variables)
- Add input validation using `@Valid`, `@NotNull`, etc.
- Add unit/integration tests for production readiness
- Future enhancements: role-based access, event filtering, frontend UI

---

## Author

**Amrit Acharya**  
BCA Semester 7  
*portfolio: [Visit my site](https://acharyaamrit.com.np)
*Institution: Oxford College of Engineering and Management

---

## License

Licensed under the [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0)
