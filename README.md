Communication between two microservices namely Employee service and Address service using Feign Client.
Database -> MySQL
Project -> Java, Spring Boot, REST APIs

What it does? -> Employee microservice consumes the data from Address microservice.

Employee project http method -> GET => http://localhost:8080/employee-service/employee/getemployee/1
Address project http method -> GET => http://localhost:8081/address-service/address/getAddress/2

Use 1st http method and we will get outp as below which has the data from other project that is address microservice.

Output -> 

{
    "id": 2,
    "name": "Asish",
    "email": "asis@gmail",
    "age": "30",
    "addressResponse": {
        "id": 1,
        "city": "BLS",
        "state": "Odisha"
    }
}
