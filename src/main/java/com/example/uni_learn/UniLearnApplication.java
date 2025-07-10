package com.example.uni_learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class UniLearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniLearnApplication.class, args);
	}

}
