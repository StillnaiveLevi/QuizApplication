# QuizApp

A Spring Boot REST API for creating and managing quizes using a PostgreSQL database.

## Features

- Get all questions
- Create quizzes by category and difficulty
- Retrieve all quizzes
- Retrieve a quiz by ID
- PostgreSQL database integration
- Spring Data JPA + Hibernate
- Lombok support for cleaner code

## Tech Stack

- Backend: Spring Boot 3
- Database: PostgreSQL
- ORM: Spring Data JPA
- Build Tool: Maven
- Language: Java 17


## Project Structure

src/main/java/com/codewithme/quizapp/
├── controller/
│   ├── QuestionsController.java
│   └── QuizController.java
├── dao/
│   ├── QuestionsDao.java
│   └── QuizDao.java
├── model/
│   ├── Questions.java
│   └── Quiz.java
├── service/
│   └── QuestionService.java
└── QuizappApplication.java

## API Endpoints

### Questions

| Method | Endpoint                  | Description                 |
|--------|---------------------------|-----------------------------|
| GET    | `/questions/allQuestions` | Get all available questions |

### Quiz

| Method | Endpoint           | Description      |
|--------|--------------------|------------------|
| POST   | `/quiz/createQuiz` | Create a new quiz|
| GET    | `/quiz/allQuizzes` | Get all quizzes  |
| GET    | `/quiz/{id}`       | Get a quiz by ID |

### Create Quiz Parameters

| Parameter  | Type   | Description         |
|----------- |------  |-------------------- |
| category   | String | Quiz category       |
| difficulty | String | Difficulty level    |
| title      | String | Quiz title          |
| num        | Integer| Number of questions |

## Example Request

### Create a Quiz

```bash
curl -X POST "http://localhost:8080/quiz/createQuiz?category=Java&difficulty=Easy&title=Java%20Basics&numQuestions=5"
```

## Setup & Installation

### 1. Clone the Repository

```bash
git clone https://github.com/StillnaiveLevi/QuizApplication.git
cd quizapp
```


### 2. Configure PostgreSQL

Create the database:

```sql
CREATE DATABASE "QuestionDB";
```

Create the table:

```sql
CREATE TABLE questions (
    id SERIAL PRIMARY KEY,
    question_text VARCHAR(1000),
    category VARCHAR(100),
    difficulty VARCHAR(50),
    created_at TIMESTAMP
);
```

Insert sample data:

```sql
INSERT INTO questions (question_text, category, difficulty, created_at) VALUES
('What is Java?', 'Java', 'Easy', NOW()),
('What is Spring Boot?', 'Java', 'Medium', NOW()),
('Explain OOP?', 'Java', 'Easy', NOW());
```

---

### 3. Configure Application Properties

Update:

```text
src/main/resources/application.properties
```

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/QuestionDB
spring.datasource.username=postgres
spring.datasource.password=0000
spring.jpa.hibernate.ddl-auto=update
```

---

### 4. Run the Application

Using Maven Wrapper:

```bash
./mvnw clean spring-boot:run
```

Or using Maven:

```bash
mvn clean spring-boot:run
```

Application runs at: http://localhost:8080

## Testing the API

### Get All Questions

http://localhost:8080/questions/allQuestions


### Get All Quizzes

http://localhost:8080/quiz/allQuizzes

### Create a Quiz

Use the POST endpoint: /quiz/createQuiz


---

## Future Improvements

- Add authentication & authorization
- Add quiz scoring system
- Add frontend using React or Vue
- Docker support
- Swagger/OpenAPI documentation
- Pagination and filtering

---

## Author

Built  using Spring Boot and PostgreSQL.
