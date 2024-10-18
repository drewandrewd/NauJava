package ru.andrew.NauJava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class NauJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(NauJavaApplication.class, args);
	}

}
