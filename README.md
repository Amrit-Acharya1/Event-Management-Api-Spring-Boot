
# Event Management System

## Project Overview

This is a Spring Boot-based Event Management System developed by **Amrit Acharya** & **Saroj Dhungana** as a project for **BCA Semester 7**. The application provides a RESTful API to manage events, attendees, and user authentication. It includes features for user registration, login, event creation, attendee registration, event/attendee management, and updating events/attendees, secured with JWT-based authentication.

The project leverages Spring Boot, Spring Security, JPA/Hibernate, and a relational database (e.g., MySQL) to implement a robust backend system. The API endpoints return standardized JSON responses with appropriate HTTP status codes for success, error, and unauthorized scenarios.

## Features

- **User Authentication**: Register and login users with JWT-based authentication.
- **Event Management**: Create, retrieve, update, and delete events.
- **Attendee Management**: Register, retrieve, update, and delete attendees for events.
- **Security**: Passwords are hashed using BCrypt, and protected endpoints require a valid JWT token.
- **Error Handling**: Consistent JSON responses using a custom ApiResponse wrapper.

## Technologies Used

- **Spring Boot**: Backend framework for building RESTful APIs.
- **Spring Security**: For JWT-based authentication and authorization.
- **Spring Data JPA**: For database operations with Hibernate.
- **MySQL**: Relational database (configurable to other databases).
- **JWT (JSON Web Tokens)**: For securing API endpoints.
- **Maven**: Dependency management and build tool.

## Prerequisites

- Java 17 or later
- Maven 3.6+
- MySQL (or another relational database)
- IDE (e.g., IntelliJ IDEA, Eclipse)
- Postman or a similar tool

## Setup Instructions

1. **Clone the Repository**
   ```bash
   git clone <repository-url>
   cd event-management-system
   ```

2. **Configure the Database**
   - Install MySQL and create a database named `event_management`.
   - Edit `src/main/resources/application.properties`:
   ```properties
spring.datasource.url=jdbc:mysql://localhost:3306/event_management
spring.datasource.username=your-username
spring.datasource.password=your-password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
jwt.secret=your-256-bit-secret-key-here
jwt.expiration=expiration time here
```
- Or if you want to manage jwt secret and jwt expiration from utility class do step no 3 and remove it from application properties

3. **Configure JWT Secret**
   - Open `src/main/java/com/eventmanagement/util/JwtUtil.java`.
   - Replace the `SECRET_KEY` with a secure key:
     ```java
     private final String SECRET_KEY = "your-256-bit-secret-key-here";
     ```

4. **Build and Run the Application**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

   Access at: [http://localhost:8080](http://localhost:8080)

5. **Test the API**
   - Register user: `POST /api/auth/register`
   - Login: `POST /api/auth/login`
   - Use `Bearer <token>` in headers for protected endpoints.

## API Endpoints

See the `docs/API.md` or use Postman collection.

## Project Structure

```
event-management-system/
├── src/
│   ├── main/
│   │   ├── java/com/eventmanagement/
│   │   │   ├── config/
│   │   │   ├── controller/
│   │   │   ├── dto/
│   │   │   ├── entity/
│   │   │   ├── exception/
│   │   │   ├── repository/
│   │   │   ├── service/
│   │   │   └── util/
│   │   └── resources/
│   └── test/
├── pom.xml
└── README.md
```

## Dependencies

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

## Notes

- **Security**: Store secrets securely (env variables).
- **Validation**: Use `@Valid`, `@NotNull`, etc. for request validation.
- **Testing**: Add unit/integration tests.
- **Future Enhancements**: Role-based access control, event search, frontend integration.

## Author

**Amrit Acharya**  
Project for BCA Semester 7  
- portfolio: [Visit my site](https://acharyaamrit.com.np)
- Institution: Oxford College of Engineering and Management

**Saroj Dhungana
- Institution: Oxford College of Engineering and Management


## License

Licensed under the [Apache License 2.0](LICENSE).
