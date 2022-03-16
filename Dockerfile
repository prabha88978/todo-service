FROM openjdk:15-alpine
WORKDIR /app
COPY build/libs/todo-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java", "-jar", "/app/todo-0.0.1-SNAPSHOT.jar"]