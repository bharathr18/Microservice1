package com.project.employee_service.response;

import lombok.Data;

@Data
public class EmployeeResponse {

    private int id;
    private String name;
    private String email;
    private int age;
    // Add AddressResponse Here
    private AddressResponse addressResponse;
}
