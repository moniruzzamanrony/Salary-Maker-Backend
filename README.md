
# Salary Maker-Backend

Build Restful CRUD API for [Salary Maker-Frontend](https://github.com/monirozzaman/Salary-Maker-Frontend) application using Spring Boot, Mysql, JPA and Hibernate.


## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/monirozzaman/Salary-Maker-Backend.git
```

**2. Create Mysql database**
```bash
create database salaryMaker
```

**3. Change mysql username and password as per your installation**

+ open `src/main/resources/application.yml`

+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

**4. Build and run the app using maven**
.

Alternatively, you can run the app without packaging it using -

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:22000>.

## Explore Rest APIs

The app defines following CRUD APIs.

    GET /bank/accounts/{acNo}/details
    
    PUT /bank/add/balance
    
    GET /employees
    
    POST /employees/add
    
    POST /employees/salary

You can test them using postman or any other rest client.
