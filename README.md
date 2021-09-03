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



LOGIN via API provided by user-service 

POST http://${host}:${port}/login

Refer : https://github.com/vat1234/user-service/blob/main/README.md 
 
Pass the token got in the RESPONSE HEADER after LOGIN in the REQUEST HEADER  or AUTHORIZATION FIELD.

NOTE: todo-service doesn't have dependency on the user-service in Run time

POST http://${host}:${port}/v1/categories
Example:
body - 
{"name":"Education"}

Response : {"name":"Education","id":"${id}","msg":"Category creation succesful."} 

ADD TODO to a Category 
----------------------


POST http://${HOST}:${PORT}/v1/categories/${categoryId}/todo
Example:
body-{"name":"Tennis",
"description":"Course",
"dateTime":"2020-09-01",
"status":"INITIAL"
}

Response:{"id":"${id},"msg":"","name":"Tennis",
"description":"Course",
"dateTime":"2020-09-01",
"status":"INITIAL"}


