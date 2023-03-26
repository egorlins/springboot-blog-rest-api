package com.springboot.blog;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot Blog App REST APIs",
				description = "Spring API Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Jegor",
						email = "jegor@Myemail.com",
						url = "http://www.ee"
				),
				license = @License(
						name = "Apache 2.0",
						url = "http://www.ee/license"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Spring Boot blog app",
				url = "https://github.com/egorlins/springboot-blog-rest-api"
		)
)
public class SpringbootBlogRestApiApplication {
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringbootBlogRestApiApplication.class, args);
	}

}
