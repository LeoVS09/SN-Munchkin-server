package ru.rmades.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@ComponentScan
@SpringBootApplication
@EnableAutoConfiguration
public class SnMunchkinServerApplication {

	private FirebaseWrapper firebase;
	public static void main(String[] args) {
		SpringApplication.run(SnMunchkinServerApplication.class, args);
	}

	@PostConstruct
	public void createFirebase(){
		firebase = new FirebaseWrapper();
		firebase.run();
	}
}
