package com.project.micro.customer.service.demo.mappers;

import com.project.micro.customer.service.demo.dto.CustomerRequestDto;
import com.project.micro.customer.service.demo.dto.CustomerResponseDto;
import com.project.micro.customer.service.demo.entities.Customer;
import com.project.micro.customer.service.demo.services.ImplementationCustomerService;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponseDto customerToCustomerResponseDto(Customer customer);
    Customer fromCustomerRequestDtoToCustomer(CustomerRequestDto customerRequestDto);
}
