package com.project.micro.customer.service.demo.services;

import com.project.micro.customer.service.demo.dto.CustomerRequestDto;
import com.project.micro.customer.service.demo.dto.CustomerResponseDto;
import com.project.micro.customer.service.demo.entities.Customer;
import com.project.micro.customer.service.demo.mappers.CustomerMapper;
import com.project.micro.customer.service.demo.repositories.CustomerRespository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ImplementationCustomerService implements ICustomerService{

    private CustomerRespository customerRepository;

    private CustomerMapper customerMapper;

    public ImplementationCustomerService(CustomerRespository customerRepository, CustomerMapper customerMapper){
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerResponseDto save(CustomerRequestDto reqDto) {

        Customer customer = this.customerMapper.fromCustomerRequestDtoToCustomer(reqDto);
        customer.setId(UUID.randomUUID().toString());

        Customer savedCustomer = this.customerRepository.save(customer);

        CustomerResponseDto customerResponseDto = this.customerMapper.customerToCustomerResponseDto(savedCustomer);

        return customerResponseDto;

    }

    @Override
    public CustomerResponseDto delete(String customerId) {
        return null;
    }

    @Override
    public CustomerResponseDto update(CustomerRequestDto reqDto) {
        Customer customer = this.customerMapper.fromCustomerRequestDtoToCustomer(reqDto);

        Customer updatedCustomer = this.customerRepository.save(customer);

        CustomerResponseDto customerResponseDto = this.customerMapper.customerToCustomerResponseDto(updatedCustomer);

        return customerResponseDto;
    }

    @Override
    public CustomerResponseDto getCustomer(String customerId) {
        Customer customer = this.customerRepository.findById(customerId).orElse(null);

        CustomerResponseDto responseDto = this.customerMapper.customerToCustomerResponseDto(customer);

        return responseDto;
    }

    @Override
    public List<CustomerResponseDto> getAllCustomers() {
        List<Customer> lists = this.customerRepository.findAll();
        List<CustomerResponseDto> listsCustomerResponseDto = new ArrayList<>();

        lists.forEach( customer -> {
            CustomerResponseDto customerResponseDto = this.customerMapper.customerToCustomerResponseDto(customer);
            listsCustomerResponseDto.add(customerResponseDto);
        });

        return listsCustomerResponseDto;
    }
}
