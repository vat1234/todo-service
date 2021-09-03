FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY ./target/todo-service-0.1.0.jar todo-service.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/todo-service.jar"]
