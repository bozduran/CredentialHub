

🛡️ ReviewMyCert

ReviewMyCert is a secure and scalable web application designed to manage certifications, users, roles, and privileges. Built with Spring Boot, it uses PostgreSQL for data persistence and leverages a custom authentication provider via Spring Security to implement fine-grained access control.

🆕 Feature Update: Certification Reviews
🔍 Overview

In upcoming releases, ReviewMyCert will support user-generated comments and reviews for each certification. This allows:

    📌 Users to leave feedback on certifications

    🌟 Other users to view reviews before pursuing a certification

    🗳️ Optional: Ratings (e.g. 1–5 stars)

🔧 Features

    ✅ RESTful API built with Spring Boot

    🧑‍🤝‍🧑 Role-based access control (RBAC):

        Users: can access and manage personal data

        Admins: can manage users, roles, and extended domain logic

    🗄️ PostgreSQL integration via Spring Data JPA

    ⚙️ Spring Actuator for monitoring

    🧪 Validation with Hibernate Validator

    ✨ Clean and maintainable codebase using Lombok

### 🔐 Security

ReviewMyCert uses **Spring Security** with a **custom authentication provider**, enabling:

- Authentication against **in-house user accounts** stored in a local PostgreSQL database
- Role- and privilege-based access using custom logic (not relying on default Spring `UserDetailsService`)
- Fine-grained control over login, registration, and access policies

Admin users have elevated privileges to manage users, roles, and review submitted data. 

Used Springdoc OpenAPI to automatically generate:

    📄 API documentation

    🌐 Interactive Swagger UI

    🔁 Live testing interface for endpoints (right from your browser)

| Layer      | Technology                                                          |
|------------|---------------------------------------------------------------------|
| Backend    | Spring Boot 3.5.3                                                   |
| Security   | Spring Security (custom provider in house stored and managed users) |
| Database   | PostgreSQL                                                          |
| ORM        | Spring Data JPA                                                     |
| Validation | Hibernate Validator 9.0.1                                           |
| Monitoring | Spring Boot Actuator                                                |
| Dev Tools  | Lombok                                                              |
| Testing    | Spring Boot Test                                                    |
| Build Tool | Maven                                                               |
| Java       | Java 21                                                             |
| Swagger    | https://localhost:8080/swagger-ui/index.html                                                                    |



| Role    | Capabilities                                                                                                     |
| ------- |------------------------------------------------------------------------------------------------------------------|
| `USER`  | Can view and manage own data                                                                                     |
| `ADMIN` | Can create, update, delete users,certifications and companies assign roles, and view system metrics via Actuator |


🚀 Getting Started
✅ Prerequisites

    Java 21+

    Maven

    PostgreSQL (running and accessible)

