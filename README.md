todo-service
-----------------------------------

This project intent is to

    CREATE a Category
    ADD TODO to a Category
    MODIFY TODO in a Category
    FILTER TODO based on allowed criteria.
    DELETE a Category

This microservice is RESTful API written in Java structured and designed using Spring Boot.

Technologies
--------------------
Spring Boot

MySQL

Docker Compose to link the containers.

Checking out and Building 
----------------------------------

git clone <>

cd todo-service

mvn clean package

Installing docker and docker compose
-------------------------------------

Docker - https://docs.docker.com/install/
Docker compose - https://docs.docker.com/compose/install/

How to Run
------------------------------------------------

docker build . -t todo-service:latest

docker-compose up

Running the application
----------------------------------------

For testing the actions, I recommend using Postman.


CREATE a Category
-------------------

Example:
POST http://localhost:8080/v1/user

body- {
    "password":"c29tZXBhc3N3b3Jk",
    "firstName":"Varsha",
    "lastName":"Mulgur",
    "email":"test@testmail.com",
    "mobileNo":9888,
    "gender":"Female",
    "birthdate":"2016-01-16"
}
Response : {"user":"test@testmail.com","msg":"Registered successfully"} 

LOGIN  
--------------------
Example:

POST http://localhost:8080/login

body-{"username":"test@testmail.com","password":"somepassword"}

Response : Returns the bearertoken .


