# This is user management springboot application.<br />

# Features <br />
.User-friendly CRUD operations for managing contacts.<br />
.Secure user authentication using Spring Security.<br />
.Utilizes Postgres database with Spring Data JPA and Hibernate.<br />
.RESTful API endpoints for interaction.<br />
.Postman collection for testing API endpoints.<br />

# To Run this Application follow the below steps.<br />
1. Please download or clone the project.
2. Open the project in your preferred code editor (like IntelliJ IDEA or Eclipse).
3. Onced open and after successfully scanning the index file by code editor please go to UserdetailstestApplication file and Run the file.

# Database<br />
In this project for Database we have used Postgres.<br />
Please change/modify the "application.properties" as per your Database configuration. <br />


# Following are the apis endpoints- 
1. Login endpoint "/api/users/login" -  <br />
   This is a POST request and in this we have to pass "username" and "password" and in respose we get JWT token.  <br />

2. Get All User List "/api/users" -  <br />
   This is GET request to get the list of "Users".  <br />

3. Create User "api/users/create" -  <br />
   This is POST request and in this we have to pass the following JSON data in body.  <br />
   { <br />
    "username": "xxx", <br />
    "last_name":"xxx", <br />
    "email":"xxx@gmail1.com", <br />
    "mobile_number":"98xxxxxxxx", <br />
    "status":"true", <br />
    "password":"passxxxd" <br />
  }  <br />

4. GetUserById "api/users/getById/{id}" -  <br />
   This is GET request to get the user by its "id".  <br />

5. Delete User "api/users/deleteById/{id}" -  <br />
   This is POST request to delete the user by its "id".  <br />

6. UpdateById "/api/users/updateById/{id}" -  <br />
   This is PUT request and in this we have to pass the following JSON data in body. <br />
   { <br />
    "username": "xxx", <br />
    "last_name":"xxx", <br />
    "email":"xxx@gmail1.com", <br />
    "mobile_number":"98xxxxxxxx", <br />
    "status":"true", <br />
    "password":"passxxxd" <br />
  } <br />


# About <br />
This project aims to showcase the implementation of a simple CRUD application using Spring Boot. It's a great starting point for learning how to build similar applications and understand the integration of Spring Security and database operations.<br />

Feel free to contribute, open issues, or suggest improvements! Your feedback is highly appreciated.<br />
# Thnak you. <br />
   
