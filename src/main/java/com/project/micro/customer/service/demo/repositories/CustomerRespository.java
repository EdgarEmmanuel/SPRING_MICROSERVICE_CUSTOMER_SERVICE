package com.project.micro.customer.service.demo.repositories;

import com.project.micro.customer.service.demo.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRespository extends JpaRepository<Customer, String> {
}
