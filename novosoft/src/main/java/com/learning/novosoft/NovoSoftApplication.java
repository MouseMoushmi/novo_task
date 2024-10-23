package com.learning.novosoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class NovoSoftApplication {

	public static void main(String[] args) {
		SpringApplication.run(NovoSoftApplication.class, args);
	}

}
