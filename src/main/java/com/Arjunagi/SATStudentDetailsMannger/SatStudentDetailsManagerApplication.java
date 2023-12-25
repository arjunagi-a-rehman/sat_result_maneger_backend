package com.Arjunagi.SATStudentDetailsMannger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin("*")
@EnableJpaAuditing(auditorAwareRef = "AuditAwareImp")
@OpenAPIDefinition(
		info = @Info(
				title = "SAT results manger",
				description = "This service store, retrieve the rank and provide the other CURD functionalities for sat results for students",
				version = "v1",
				contact = @Contact(
						name = "Arjunagi A Rehman",
						email = "andul123arj@gmail.com"
				),
				license =@License(
						name = "Apache"
				)
		)
)
public class SatStudentDetailsManagerApplication {
	public static void main(String[] args) {
		SpringApplication.run(SatStudentDetailsManagerApplication.class, args);
	}
}
