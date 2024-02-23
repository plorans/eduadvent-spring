package edu.um.eduadventspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"webapp.WEB-INF.views.escuela;edu.um.eduadventspring"})
public class EduadventSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(EduadventSpringApplication.class, args);
	}

}
