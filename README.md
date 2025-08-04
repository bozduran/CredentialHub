

🛡️ CredentialHub

CredentialHub is a secure and scalable web application designed to manage certification, users, roles, and privileges. Built with Spring Boot, it uses PostgreSQL for data persistence and leverages a custom authentication provider via Spring Security to implement fine-grained access control.

🔧 Features

    ✅ RESTful API built with Spring Boot

    🔐 Custom authentication and authorization using Spring Security

    🧑‍🤝‍🧑 Role-based access control (RBAC):

        Users: can access and manage personal data

        Admins: can manage users, roles, and extended domain logic

    🗄️ PostgreSQL integration via Spring Data JPA

    ⚙️ Spring Actuator for monitoring

    🧪 Validation with Hibernate Validator

    ✨ Clean and maintainable codebase using Lombok


| Layer      | Technology                                    |
| ---------- | --------------------------------------------- |
| Backend    | Spring Boot 3.5.3                             |
| Security   | Spring Security (custom provider)             |
| Database   | PostgreSQL                                    |
| ORM        | Spring Data JPA                               |
| Validation | Hibernate Validator 9.0.1                     |
| Monitoring | Spring Boot Actuator                          |
| Dev Tools  | Lombok                                        |
| Testing    | Spring Boot Test                              |
| Build Tool | Maven                                         |
| Java       | Java 21                                       |




| Role    | Capabilities                                                                                                     |
| ------- |------------------------------------------------------------------------------------------------------------------|
| `USER`  | Can view and manage own data                                                                                     |
| `ADMIN` | Can create, update, delete users,certifications and companies assign roles, and view system metrics via Actuator |


🚀 Getting Started
✅ Prerequisites

    Java 21+

    Maven

    PostgreSQL (running and accessible)

📝 License

This project is licensed under the MIT License.
