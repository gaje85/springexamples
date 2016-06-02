package com.example.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.basic.Address;

@Configuration
public class AddressConfig {
	

    @Bean(name="address")
    public Address getAdd() {
        return new Address();
    }

}
