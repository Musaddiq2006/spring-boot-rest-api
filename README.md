[README (2).md](https://github.com/user-attachments/files/34927369/README.2.md)
<div align="center">

# 🍃 Spring Boot REST API

**A clean, beginner-friendly REST API built with Spring Boot, covering routing, query parameters, JSON request bodies and full CRUD operations.**

![Java](https://img.shields.io/badge/Java-25-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.1.1-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-Wrapper-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![REST](https://img.shields.io/badge/API-REST-0A66C2?style=for-the-badge)

[Features](#-features) • [Tech Stack](#-tech-stack) • [Getting Started](#-getting-started) • [API Reference](#-api-reference) • [Project Structure](#-project-structure) • [Roadmap](#-roadmap)

</div>

---

## 📖 About

This project is a lightweight RESTful web service built with **Spring Boot** and **Spring Web MVC**. It demonstrates the core building blocks every backend developer needs: defining controllers, mapping HTTP methods to handlers, reading query parameters and path variables, accepting JSON bodies, and returning proper HTTP status codes.

User data is stored in an **in-memory `HashMap`**, so there is nothing to install or configure. Clone it, run it, and start sending requests.

## ✨ Features

- 🚀 **Zero-setup startup**: no database or external services required
- 🔁 **Full CRUD** for a `User` resource (create, read, update, delete)
- 🎯 **Multiple request styles**: plain `GET`, query parameters, JSON request bodies and path variables
- ✅ **Meaningful HTTP responses**: `201 Created`, `200 OK` and `404 Not Found` via `ResponseEntity`
- 📦 **Maven Wrapper included**: no need to install Maven yourself
- 🧪 **Test scaffold ready**: a Spring Boot context-load test is included

## 🛠 Tech Stack

| Layer            | Technology                           |
| ---------------- | ------------------------------------ |
| Language         | Java 25                              |
| Framework        | Spring Boot 4.1.1 (Spring Web MVC)   |
| Build Tool       | Maven (via Maven Wrapper)            |
| Data Storage     | In-memory `HashMap` (demo purposes)  |
| Testing          | JUnit 5 + Spring Boot Test           |

## 🚀 Getting Started

### Prerequisites

- **JDK 25** (matches the `java.version` set in `pom.xml`)
- **Git**

> Maven is not required. The included wrapper (`mvnw` / `mvnw.cmd`) downloads the right version automatically.

### Installation & Run

**1. Clone the repository**

```bash
git clone https://github.com/Musaddiq2006/spring-boot-rest-api.git
cd spring-boot-rest-api
```

**2. Start the application**

```bash
# macOS / Linux
./mvnw spring-boot:run

# Windows
mvnw.cmd spring-boot:run
```

**3. Open it up**

The server starts on **http://localhost:8080**. Try it:

```bash
curl http://localhost:8080/api/hello
# Hello World
```

### Run the Tests

```bash
./mvnw test
```

### Build a Runnable JAR

```bash
./mvnw clean package
java -jar target/firstApp-0.0.1-SNAPSHOT.jar
```

## 📡 API Reference

**Base URL:** `http://localhost:8080`

### Overview

| Method   | Endpoint        | Description                       | Success Response     |
| -------- | --------------- | --------------------------------- | -------------------- |
| `GET`    | `/api/hello`    | Simple health/hello endpoint      | `200` + text         |
| `GET`    | `/order`        | Echo an order using a query param | `200` + text         |
| `GET`    | `/user`         | List all users                    | `200` + JSON array   |
| `POST`   | `/user`         | Create a user                     | `201` + created user |
| `PUT`    | `/user`         | Update an existing user           | `200` / `404`        |
| `DELETE` | `/user/{id}`    | Delete a user by ID               | `200` / `404`        |

### The `User` Model

```json
{
  "id": 1,
  "name": "Musaddiq",
  "email": "musaddiq@example.com"
}
```

| Field   | Type      | Description                    |
| ------- | --------- | ------------------------------ |
| `id`    | `integer` | Unique identifier (map key)    |
| `name`  | `string`  | Full name of the user          |
| `email` | `string`  | Email address of the user      |

### Endpoint Details

<details>
<summary><b>GET /api/hello</b>: Say hello</summary>

```bash
curl http://localhost:8080/api/hello
```

**Response**
```
Hello World
```
</details>

<details>
<summary><b>GET /order?item=</b>: Place an order</summary>

```bash
curl "http://localhost:8080/order?item=laptop"
```

**Response**
```
Your order is laptop
```

> The `item` query parameter is required. Omitting it returns `400 Bad Request`.
</details>

<details>
<summary><b>POST /user</b>: Create a user</summary>

```bash
curl -X POST http://localhost:8080/user \
  -H "Content-Type: application/json" \
  -d '{"id": 1, "name": "Musaddiq", "email": "musaddiq@example.com"}'
```

**Response** `201 Created`
```json
{
  "id": 1,
  "name": "Musaddiq",
  "email": "musaddiq@example.com"
}
```
</details>

<details>
<summary><b>GET /user</b>: List all users</summary>

```bash
curl http://localhost:8080/user
```

**Response** `200 OK`
```json
[
  {
    "id": 1,
    "name": "Musaddiq",
    "email": "musaddiq@example.com"
  }
]
```
</details>

<details>
<summary><b>PUT /user</b>: Update a user</summary>

```bash
curl -X PUT http://localhost:8080/user \
  -H "Content-Type: application/json" \
  -d '{"id": 1, "name": "Syed Musaddiq", "email": "new@example.com"}'
```

**Response** `200 OK` with the updated user, or `404 Not Found` if no user with that `id` exists.
</details>

<details>
<summary><b>DELETE /user/{id}</b>: Delete a user</summary>

```bash
curl -X DELETE http://localhost:8080/user/1
```

**Response** `200 OK`
```
User Deleted
```

Returns `404 Not Found` if no user with that `id` exists.
</details>

## 📂 Project Structure

```
spring-boot-rest-api/
├── .mvn/wrapper/                      # Maven Wrapper configuration
├── src/
│   ├── main/
│   │   ├── java/com/codewith/firstApp/
│   │   │   ├── FirstAppApplication.java      # Application entry point
│   │   │   ├── controllers/
│   │   │   │   ├── HelloController.java      # GET /api/hello
│   │   │   │   ├── OrderController.java      # GET /order?item=
│   │   │   │   └── UserController.java       # User CRUD endpoints
│   │   │   └── model/
│   │   │       └── User.java                 # User data model
│   │   └── resources/
│   │       └── application.properties        # App configuration
│   └── test/java/com/codewith/firstApp/
│       └── FirstAppApplicationTests.java     # Context-load test
├── mvnw / mvnw.cmd                    # Maven Wrapper scripts
└── pom.xml                            # Project dependencies & build config
```

## 💡 Good to Know

This project is intentionally simple, so a few behaviours are worth keeping in mind:

- **Data is not persistent.** Users live in memory and are cleared whenever the app restarts.
- **Duplicate IDs on `POST`:** if a user with the same `id` already exists, the original is kept, but the endpoint still responds with `201 Created`.
- **No input validation yet.** Fields such as `name` and `email` are not checked.

## 🗺 Roadmap

- [ ] `GET /user/{id}` to fetch a single user
- [ ] Return `409 Conflict` when creating a user with an existing ID
- [ ] Add request validation (Bean Validation)
- [ ] Persist data with Spring Data JPA and a real database
- [ ] Add unit and integration tests for each controller
- [ ] Document the API with OpenAPI / Swagger UI
- [ ] Global exception handling

## 🤝 Contributing

Contributions, issues and feature requests are welcome.

1. Fork the project
2. Create your feature branch: `git checkout -b feature/amazing-feature`
3. Commit your changes: `git commit -m "Add amazing feature"`
4. Push to the branch: `git push origin feature/amazing-feature`
5. Open a Pull Request

## 👤 Author

**Syed Musaddiq Ahmed**

- GitHub: [@Musaddiq2006](https://github.com/Musaddiq2006)

---

<div align="center">

If you found this project helpful, consider giving it a ⭐

</div>
