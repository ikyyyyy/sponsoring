package com.projet.sponsoring;

import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
@Data
public class SponsoringApplication {

	public static void main(String[] args) {

		SpringApplication.run(SponsoringApplication.class, args);
	}
}
