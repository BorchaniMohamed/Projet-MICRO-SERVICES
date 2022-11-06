package org.ms.authentificationservice;

import org.ms.authentificationservice.entities.AppRole;
import org.ms.authentificationservice.entities.AppUser;
import org.ms.authentificationservice.services.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class AuthentificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthentificationServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(UserServiceImpl userService)
	{
		return args ->
		{
			AppRole role1 = new AppRole(1L, "ADMIN");
			AppRole role2 = new AppRole(2L, "USER");
			AppUser user1 = new AppUser(3L, "Chahine", "123456");
			AppUser user2 = new AppUser(4L, "ALI", "123456");

			userService.addRole(role1);
			userService.addRole(role2);
			userService.addUser(user1);
			userService.addUser(user2);


			userService.addRoleToUser("Chahine", "ADMIN");

			userService.addRoleToUser("ALI", "USER");


			userService.addRoleToUser("Chahine", "USER");

		};
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
