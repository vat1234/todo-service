todo-service
-----------------------------------

This project intent is to

    CREATE a Category
    ADD TODO to a Category
    MODIFY TODO in a Category
    FILTER TODO based on allowed criteria.
    DELETE a Category
    
for authorised users.
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

Supported Status criteria
-------------------------

{INITIAL, STARTED, COMPLETED, SNOOZED, OVERDUE}

Supported Date Format
-------------------------

yyyy-MM-dd

CREATE a Category
-------------------



LOGIN via API provided by user-service 

POST http://${user-service}:${port}/login

Refer : https://github.com/vat1234/user-service/blob/main/README.md 
 
Pass the token obtained from the user-service RESPONSE HEADER after successful LOGIN in the AUTHORIZATION FIELD while POST.

POST http://${host}:${port}/v1/categories

Example:

body - 
{"name":"Education"}

Response :

{"name":"Education","id":"${id}","msg":"Category creation succesful."} 

ADD TODO to a Category 
----------------------


POST http://${HOST}:${PORT}/v1/categories/${categoryid}/todo

Pass the token obtained from the user-service RESPONSE HEADER after successful LOGIN in the AUTHORIZATION FIELD while POST.

Example:

body-{"name":"Tennis",
"description":"Course",
"dateTime":"2020-09-01",
"status":"INITIAL"
}

Response-{"id":"${id},"msg":"","name":"Tennis",
"description":"Course",
"dateTime":"2020-09-01",
"status":"INITIAL"}

MODIFY TODO in a Category 
-------------------------

PUT http://${HOST}:${PORT}/v1/categories/${categoryid}/todo/${todoid}

Pass the token obtained from the user-service RESPONSE HEADER after successful LOGIN in the AUTHORIZATION FIELD while POST.

Example:

body-{"name":"Tennis",
"description":"Course",
"dateTime":"2020-09-01",
"status":"STARTED"
}

Response-{"id":"${id},"msg":"","name":"Tennis",
"description":"Course",
"dateTime":"2020-09-01",
"status":"INITIAL"}

FILTER TODO for a USER by Status, Category and date
----------------------------------------------------

GET http://${HOST}:${PORT}/v1/categories/${categoryid}?page=${page}&size=${size}&status=${status}&fromDate=${fromdate}&toDate=${todate}

Pass the token obtained from the user-service RESPONSE HEADER after successful LOGIN in the AUTHORIZATION FIELD while POST.

Example: 

GET http://localhost:8084/v1/categories/58?page=0&status=STARTED&fromDate=2020-09-01&toDate=2020-09-10&

Response-

List of todo 

Points to NOTE
----------------------------------
1. Use the port mentioned in the docker compose file

