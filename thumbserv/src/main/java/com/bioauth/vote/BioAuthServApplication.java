package com.bioauth.vote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.bioauth.domain.PoliticalParties;
import com.bioauth.domain.User;
import com.bioauth.domain.VoteDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication(scanBasePackages={"com.bioauth.*"})
@EntityScan(basePackageClasses={PoliticalParties.class,User.class,VoteDetails.class})
public class BioAuthServApplication {

	public static void main(String[] args) {
		SpringApplication.run(BioAuthServApplication.class, args);
	}
}
