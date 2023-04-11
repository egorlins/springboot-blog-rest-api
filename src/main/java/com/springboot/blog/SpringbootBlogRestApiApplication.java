package com.springboot.blog;

import com.springboot.blog.entity.Role;
import com.springboot.blog.repository.RoleRepository;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

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
//use this annotation only if using plain spring framework without springboot @EnableTransactionManagement
public class SpringbootBlogRestApiApplication  implements CommandLineRunner {
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringbootBlogRestApiApplication.class, args);
	}

	//2nd approach to insert missing data into DB
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void run(String... args) throws Exception {
//		Role adminRole = new Role();
//		adminRole.setName("ROLE_ADMIN");
//		roleRepository.save(adminRole);
//
//		Role userRole = new Role();
//		userRole.setName("ROLE_USER");
//		roleRepository.save(userRole);
	}
}
