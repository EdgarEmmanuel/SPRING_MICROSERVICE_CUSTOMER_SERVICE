package com.project.micro.customer.service.demo.services;

import com.project.micro.customer.service.demo.dto.CustomerRequestDto;
import com.project.micro.customer.service.demo.dto.CustomerResponseDto;

import java.util.List;

public interface ICustomerService {
    CustomerResponseDto save(CustomerRequestDto reqDto);
    CustomerResponseDto delete(String customerId);
    CustomerResponseDto update(CustomerRequestDto reqDto);
    CustomerResponseDto getCustomer(String customerId);
    List<CustomerResponseDto> getAllCustomers();
}
