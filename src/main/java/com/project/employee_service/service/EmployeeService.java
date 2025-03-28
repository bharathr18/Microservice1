package com.project.employee_service.service;

import com.project.employee_service.entity.Employee;
import com.project.employee_service.feignclient.AddressClient;
import com.project.employee_service.repository.EmployeeRepo;
import com.project.employee_service.response.AddressResponse;
import com.project.employee_service.response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AddressClient addressClient;
    public EmployeeResponse getEmployee(int id)
    {
        Optional<Employee> employee = employeeRepo.findById(id);
        EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);

        // Using FeignClient
        ResponseEntity<AddressResponse> addressResponse = addressClient.getAddressByEmployeeId(id);
        employeeResponse.setAddressResponse(addressResponse.getBody());

        return employeeResponse;
    }
}
