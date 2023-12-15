package com.david.citasMedicas;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(
		title = "Citas medicas API",
		version = "1.0",
		description = "This API provide useful tools for developing a medical appointment app"
))

@SpringBootApplication
public class CitasMedicasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CitasMedicasApplication.class, args);
	}

}
