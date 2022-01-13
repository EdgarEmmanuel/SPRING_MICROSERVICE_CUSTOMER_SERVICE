package com.project.micro.customer.service.demo;

import com.project.micro.customer.service.demo.dto.CustomerRequestDto;
import com.project.micro.customer.service.demo.services.ICustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MicroCustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroCustomerServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner start(ICustomerService iCustomerService){
        return args -> {
            iCustomerService.save(new CustomerRequestDto("C01","Customer One","c01@gmail.com"));
            iCustomerService.save(new CustomerRequestDto("C02","Customer Two","c02@gmail.com"));
        };
    }

}
