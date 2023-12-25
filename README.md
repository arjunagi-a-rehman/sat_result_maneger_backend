# SAT Results Manager

## Overview

SAT Results Manager is a backend service that provides REST APIs for managing student SAT results. The service allows users to perform CRUD (Create, Read, Update, Delete) operations on student records, retrieve all records, get a student's rank based on their name, update a student's SAT score, and delete records.

## Technology Used

- **Programming Language:** Java
- **Framework:** Spring Boot
- **Database:** MySQL

## Controller API Summary

### SATResultController

- **Package:** `com.Arjunagi.SATStudentDetailsMannger.controller`
- **Description:** This controller provides CRUD REST APIs for creating, updating, fetching, and deleting SAT scores for students.

#### Endpoints:

1. **Create SAT result REST API**
   - **URL:** `/api/student/result`
   - **Method:** POST
   - **Description:** Create a new SAT result record by student name.
   - **Response Codes:**
     - 201: HTTP Status CREATED
     - 500: HTTP Status Internal Server Error (with error details if applicable)

2. **Fetch Student Rank Details REST API**
   - **URL:** `/api/student/rank`
   - **Method:** GET
   - **Description:** Fetch the rank based on the student's name.
   - **Response Codes:**
     - 200: HTTP Status OK
     - 500: HTTP Status Internal Server Error (with error details if applicable)

3. **Fetch All Data REST API**
   - **URL:** `/api/sat/all`
   - **Method:** GET
   - **Description:** Fetch all the data.
   - **Response Codes:**
     - 200: HTTP Status OK
     - 500: HTTP Status Internal Server Error (with error details if applicable)

4. **Update Student Score REST API**
   - **URL:** `/api/student/score/{name}`
   - **Method:** PATCH
   - **Description:** Update a student's marks.
   - **Response Codes:**
     - 200: HTTP Status OK
     - 417: Expectation Failed
     - 500: HTTP Status Internal Server Error (with error details if applicable)

5. **Delete SAT Result Details REST API**
   - **URL:** `/api/result/student`
   - **Method:** DELETE
   - **Description:** Delete result details based on the student's name.
   - **Response Codes:**
     - 200: HTTP Status OK
     - 417: Expectation Failed
     - 500: HTTP Status Internal Server Error (with error details if applicable)

## Services

### DefaultSATResultServices

- **Package:** `com.Arjunagi.SATStudentDetailsMannger.services.Imp`
- **Description:** This service implements the business logic for managing SAT results.

#### Methods:

1. **createStudentResultRecord**
   - **Description:** Creates the SAT result and student data in the database.
   - **Parameters:** `SATResultsDto satResultsDto`
   - **Exceptions:** `RecordAlreadyExistException` if the student record already exists.

2. **getRankByName**
   - **Description:** Fetches the rank based on the student's name.
   - **Parameters:** `String name`

3. **getAll**
   - **Description:** Fetches all SAT result data.

4. **updateScore**
   - **Description:** Updates the student's SAT score.
   - **Parameters:** `String name, Float score`
   - **Returns:** `Boolean` indicating whether the update was successful.

5. **deleteRecord**
   - **Description:** Deletes a student record based on the name.
   - **Parameters:** `String name`
   - **Returns:** `Boolean` indicating whether the deletion was successful.

## Repository

### ISATResultsRepo

- **Package:** `com.Arjunagi.SATStudentDetailsMannger.repository`
- **Description:** This repository provides database access methods for SATResults.

#### Methods:

1. **findByName**
   - **Description:** Finds a record by the student's name.
   - **Parameters:** `String name`
   - **Returns:** `Optional<SATResults>`

2. **findAllByOrderByScoreDesc**
   - **Description:** Fetches all records ordered by score in descending order.
   - **Returns:** `List<SATResults>`

3. **calculateRank**
   - **Description:** Calculates the rank based on the student's score.
   - **Parameters:** `String studentName`
   - **Returns:** `int`

## Database Schema

### SATResults

- **Package:** `com.Arjunagi.SATStudentDetailsMannger.models`
- **Description:** This class represents the database schema for SATResults.

#### Fields:

- `id`: Integer (Primary Key)
- `name`: String (Unique)
- `address`: String
- `score`: Float
- `pincode`: String
- `passed`: Boolean
- `city`: String
- `country`: String
- `createdAt`: LocalDateTime
- `createdBy`: String
- `updatedAt`: LocalDateTime
- `updatedBy`: String

## Swagger UI

Swagger UI is provided for API documentation. The documentation includes details about each API endpoint, request parameters, and response codes. Access the Swagger UI at `/swagger-ui/index.html#`.

Feel free to explore the code and documentation for more details. If you have any questions or need further clarification, please don't hesitate to reach out.

Thank you for considering my submission.

Best regards,
[Your Full Name]
