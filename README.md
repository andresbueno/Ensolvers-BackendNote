# Notes Backend

This backend is responsible for handling the CRUD operations for notes and is implemented using Java and Spring Boot. This backend utilizes an in-memory H2 database to manage the persistence of notes. Additionally, it employs libraries such as JPA and Lombok

## Requirements:
- Java 17
- Gradle

## Execution:

- Update Dependendencies:
  ```
    ./gradlew build --refresh-dependencies
  ```
- Run service: 
  ```
    ./gradlew bootRun
  ```
  - Open the next URL
  http://localhost:8080/swagger-ui/index.html
## API Endpoints

- POST /notes - Method to create note
- DELETE /notes/{id} - Method to delete a note
- PATCH /notes/{id} - Method to update a note
- PATCH /notes/switch-status/{id} - Method to change status to a note
- GET /notes - Method to list all notes
