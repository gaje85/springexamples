package com.bioauth.vote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.bioauth.domain.PoliticalParties;
import com.bioauth.domain.User;
import com.bioauth.domain.VoteDetails;

@SpringBootApplication(scanBasePackages={"com.bioauth.*"})
@EntityScan(basePackageClasses={PoliticalParties.class,User.class,VoteDetails.class})

public class SpringBootWebApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootWebApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootWebApplication.class, args);
	}

}