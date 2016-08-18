package ru.rmades.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@SpringBootApplication
@EnableAutoConfiguration
public class SnMunchkinServerApplication {

//	@Autowired
//	UserDAO userDAO;

	public static void main(String[] args) {
		SpringApplication.run(SnMunchkinServerApplication.class, args);
	}

//	@Autowired
//	DBLoader dbLoader;
//
//	@PostConstruct
//	void seeTheDB(){
//		for(User user: userDAO.findAll()){
//			System.out.println(user.toString());
//		}
//	}
}
