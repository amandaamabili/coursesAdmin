# Courses API

Courses API is a Spring Boot application that provides a RESTful API for managing courses.

## Prerequisites

- Docker
- Docker Compose

## Technologies Used

- **Java 21**: The programming language used for the application.
- **Spring Boot**: Framework for building the RESTful API.
- **Gradle**: Build tool for managing dependencies and building the project.
- **Docker**: Containerization platform to run the application in isolated environments.
- **Docker Compose**: Tool for defining and running multi-container Docker applications.
- **MySQL**: Database used for storing course data.

## Getting Started

### Clone the repository
`https://github.com/amandaamabili/coursesAdmin.git `



##Run the aplication 

Run the application with Docker
Build and run the Docker containers using Docker Compose.

`docker-compose up --build`


### Access the API
The API will be available at http://localhost:8080.

#### API Endpoints
Courses
- GET /courses - Get all courses
`curl --location 'http://localhost:8080/courses' \
--header 'Content-Type: application/json' \
--data '' `
  
- GET /courses?name={name}&category={category} - Get a course by Name or Category
  
` curl --location 'http://localhost:8080/courses?name=th6uy6&category=roo' \
--header 'Content-Type: application/json' \
--data '' `
    
-  POST /courses - Create a new course
  
``curl --location 'http://localhost:8080/courses' \
--header 'Content-Type: application/json' \
--data '{
    "name" : "tesrtew",
    "category": "dff" 
}'``

- PUT /courses/{id} - Update a course by ID
  
`curl --location --request PUT 'http://localhost:8080/courses/5' \
--header 'Content-Type: application/json' \
--data '{
    "name" : "tgbtyyyj",
    "category": "dff"
}'`

- DELETE /courses/{id} - Delete a course by ID
  
` curl --location --request DELETE 'http://localhost:8080/courses/16'`

-PATCH courses/{id}/active - Set Toggle to active

`
curl --location --request PATCH 'http://localhost:8080/courses/5/active' \
--header 'Content-Type: application/json' \
--data '' `


