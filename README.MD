# UniLearn API

Учебный проект: REST API для онлайн-платформы курсов.

## 🔧 Технологии
- Java 17
- Spring Boot
- Spring Security (JWT)
- Spring Data JPA (Hibernate)
- PostgreSQL
- Swagger (springdoc-openapi)
- JUnit + Mockito

## 🚀 Как запустить
1. Клонировать репозиторий:
   ```bash
   git clone https://github.com/твоеимя/unilearn.git
   cd unilearn
2. Заполнить application.properties:
    ```bash
    spring.datasource.url=jdbc:postgresql://localhost:5432/unilearn
    spring.datasource.username=postgres
    spring.datasource.password=yourpassword
3. Собрать и запустить:
    ```bash
    ./mvnw spring-boot:run
## 📘 Документация API
После запуска Swagger доступен по адресу:
📎 http://localhost:8081/swagger-ui.html

## 👤 Роли пользователей
USER: может просматривать курсы, лекции, просматривать и редактировать комментарии

ADMIN: может редактировать курсы, категории, лекции, комментарии

## 🧪 Тестирование
    ./mvnw test

## 📂 Структура проекта
- configuration/ — настройки Spring Security и JWT

- controller/ — REST-контроллеры

- dto/ — классы запросов/ответов

- exception/ - обработка исключений

- mapper/ - преобразование между DTO и сущностями 

- model/ — сущности

- Repository/ — JPA-репозитории

- service/ — бизнес-логика