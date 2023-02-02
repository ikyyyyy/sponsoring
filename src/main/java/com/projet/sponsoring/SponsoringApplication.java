package com.projet.sponsoring;

import com.projet.sponsoring.Model.Login;
import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.SessionAttributes;


@SpringBootApplication
@Data
@SessionAttributes
public class SponsoringApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(SponsoringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
