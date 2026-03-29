<div align="center">

# 🎮 Game Library

**An EXTREMELY simple web application for "managing" game collections**

Built with Spring Boot • MVC • JPA • Thymeleaf

</div>

---

---

## 🚀 Quick Start

```bash
# Clone and run
git clone <repo-url>
cd gamelibrarylab
./mvnw spring-boot:run

# Open in browser
http://localhost:8080
```
---

## 📖 Features

- **List games** - Browse with pagination
- **Add games** - Form with validation
- **Search** - Filter by title/developer
- **Edit/Delete** - Full CRUD operations

---

## 🎮 Dev Mode

App starts in **dev mode** by default with 15 pre-loaded games!

**Sample games:**
- The Legend of Zelda: Breath of the Wild
- Elden Ring
- Super Mario Odyssey
- The Witcher 3
- Minecraft
- ... and 10 more

**Disable dev mode:**
```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=default
```

---

## 🗄️ Database

**H2 Console:** `http://localhost:8080/h2-console`

```
JDBC URL: jdbc:h2:mem:gamedb
User: sa
Password: (empty)
```

> **Note:** Data resets on restart. Change to `file:./data/gamedb` in `application.properties` to persist.

---

## 🧪 Tests

```bash
./mvnw test
```

29 tests • All passing ✅

---

## 🛠 Tech Stack

- Java 25
- Spring Boot 4.0.4
- Spring Data JPA
- Thymeleaf
- H2 Database
- Maven

---

<div align="center">

Made with stress and Spring Boot

</div>
