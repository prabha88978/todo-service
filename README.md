# ToDo App (Backend Rest Api) + TDD
This is the SpringBoot application called ToDo developed for task management. \
Developed using : \
SpringBoot \
Spring Web \
Spring JPA \
H2 Database \
Lombok 

### To Start The Server
```shell
./gradlew clean build
./gradlew bootRun
```

### How To Use APIs
1. Create ToDo (Save the ToDo to the database)
```shell
curl -v --location --request POST 'http://localhost:8080/todos' \
--header 'Content-Type: application/json' \
--data-raw '{
"text":"Learn SpringBoot",
"date":"2022-03-16'T'12:00:00.002Z"
}'
```

2. Fetch ToDos
```shell
curl --location --request GET 'http://localhost:8080/todos'
```

3. Fetch ToDo by Id
```shell
curl --location --request GET 'http://localhost:8080/todos/{id}'
```

4. Update ToDo by Id
```shell
curl -v --location --request PUT 'http://localhost:8080/todos/{id}' \
--header 'Content-Type: application/json' \
--data-raw '{
"text":"Learn SpringBoot",
"date":"2022-03-16'T'12:00:00.002Z",
"completed":true
}'
```

5. Delete ToDo by Id
```shell
curl --location --request DELETE 'http://localhost:8080/todos/{id}'
```