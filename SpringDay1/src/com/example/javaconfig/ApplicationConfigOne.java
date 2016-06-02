package com.example.javaconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ ApplicationConfig.class, AddressConfig.class })
public class ApplicationConfigOne {

}
