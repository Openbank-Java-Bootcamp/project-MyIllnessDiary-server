package com.Ironhack.finalProjectserver;

import com.Ironhack.finalProjectserver.model.Role;
import com.Ironhack.finalProjectserver.model.User;
import com.Ironhack.finalProjectserver.service.impl.RoleService;
import com.Ironhack.finalProjectserver.service.impl.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;

@SpringBootApplication
public class FinalProjectServerApplication {

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectServerApplication.class, args);
	}

	@Bean

	CommandLineRunner run(UserService userService, RoleService roleService) {
		return args -> {
			roleService.saveRole(new Role(null, "ROLE_PATIENT"));
			roleService.saveRole(new Role(null, "ROLE_DOCTOR"));

			userService.saveUser(new User(null, "John Doe", "john@gmail.com", "P@ssw0rd", null));
			userService.saveUser(new User(null, "James Smith", "james@gmail.com", "P@ssw0rd", null));
			userService.saveUser(new User(null, "Jane Carry", "jane@gmail.com", "P@ssw0rd", null));
			userService.saveUser(new User(null, "Chris Anderson", "chris@gmail.com", "P@ssw0rd", null));

			roleService.addRoleToUser("john@gmail.com", "ROLE_PATIENT");
			roleService.addRoleToUser("james@gmail.com", "ROLE_DOCTOR");
			roleService.addRoleToUser("jane@gmail.com", "ROLE_PATIENT");
			roleService.addRoleToUser("chris@gmail.com", "ROLE_DOCTOR");
		};
	}

	@Bean

	public WebMvcConfigurer corsConfigurer(){
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry){
				registry.addMapping("/**").allowedMethods("*").allowedOrigins("http://localhost:3000");
			}
		};
	}

}