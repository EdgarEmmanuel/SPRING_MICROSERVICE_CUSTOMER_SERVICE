package com.project.micro.customer.service.demo.web;

import com.project.micro.customer.service.demo.dto.CustomerRequestDto;
import com.project.micro.customer.service.demo.dto.CustomerResponseDto;
import com.project.micro.customer.service.demo.services.ICustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class CustomerRestController {
    private ICustomerService iCustomerService;


    public CustomerRestController(ICustomerService iCustomerService){
        this.iCustomerService = iCustomerService;
    }

    @GetMapping("/customers")
    public List<CustomerResponseDto> getAllCustomers(){
        return this.iCustomerService.getAllCustomers();
    }

    @GetMapping("/customers/{id}")
    public CustomerResponseDto getCustomerById(@PathVariable String id){
        return this.iCustomerService.getCustomer(id);
    }

    @PostMapping("/customer/save")
    public CustomerResponseDto saveCustomer(@RequestBody CustomerRequestDto dto){
        return this.iCustomerService.save(dto);
    }
}
