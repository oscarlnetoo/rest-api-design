# REST API Design

This project demonstrates the implementation of REST API concepts, design best practices, security measures, and documentation using Swagger/OpenAPI. The code is structured following the **Hexagonal Architecture**, promoting separation of concerns, scalability, and ease of testing.

## Prerequisites

Before starting, make sure you've met the following requirements:

- You have installed **Java Development Kit (JDK) 22**. You can download it from the [official Oracle website](https://www.oracle.com/java/technologies/javase/jdk22-archive-downloads.html) or use an open-source alternative.
- You have installed **Maven** for project management and build automation. Installation instructions are available on the [Maven official website](https://maven.apache.org/install.html).
- You have a `<Windows / Linux / Mac>` machine. This project is compatible with all major operating systems.
- You have read the [official Spring Boot documentation](https://spring.io/projects/spring-boot) for a better understanding of the framework.

## Installing the Project

Below is how you can install and set up the project:

1. Clone the repository

    ```bash
    git clone https://github.com/oscarlnetoo/rest-api-design.git
    ```

2. Navigate to the project directory

    ```bash
    cd rest-api-design
    ```

3. Build the project with Maven

    ```bash
    mvn clean install
    ```

## Using the Project

To use **REST API Design**, follow these steps:

1. Run the application

    ```bash
    mvn spring-boot:run
    ```

2. Once running, access the Swagger UI for API documentation and testing:

    ```
    http://localhost:8080/swagger-ui.html
    ```

3. Explore the API endpoints through Swagger or your preferred API client.

## Key Features

- **Hexagonal Architecture**: The project is structured to promote maintainability, testability, and scalability by dividing the code into:
  - **Domain Layer**: Contains core business logic and entities.
  - **Application Layer**: Handles use cases and orchestration of domain logic.
  - **Infrastructure Layer**: Manages external integrations like databases and APIs.

- **REST API Best Practices**:
  - **Resource Naming**: Resources are identified using nouns and plural forms (e.g., `/users`, `/products`).
  - **Proper Use of HTTP Methods**: Implements HTTP methods like GET, POST, PUT, DELETE appropriately.
  - **HTTP Status Codes**: Returns meaningful status codes for different responses (e.g., 200 OK, 404 Not Found, 400 Bad Request).

- **Error Handling**: Standardized error responses with clear messages and error codes.

- **Versioning**: Supports versioned endpoints (e.g., `/v1/users`) to manage API changes.

- **Partial Responses**: Allows clients to specify the fields they need in responses, reducing payload size.

- **Pagination**: Implements pagination for endpoints returning large datasets.

- **Security**:
  - **JWT Token**: Secures endpoints using JSON Web Tokens (JWT) for authentication and authorization.

- **Swagger/OpenAPI Integration**: Provides interactive documentation and API testing capabilities.

## Additional Resources

- [Hexagonal Architecture by Alistair Cockburn](https://alistair.cockburn.us/hexagonal-architecture/)
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Swagger/OpenAPI Tools](https://swagger.io/tools/open-source/getting-started/)
