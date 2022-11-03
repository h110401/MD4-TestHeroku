package rikkei.academy.security8;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import rikkei.academy.security8.model.Role;
import rikkei.academy.security8.model.User;
import rikkei.academy.security8.service.IRoleService;
import rikkei.academy.security8.service.IUserService;

import java.util.HashSet;

import static rikkei.academy.security8.model.RoleName.*;

@SpringBootApplication
public class Security8Application {

	public static void main(String[] args) {
		SpringApplication.run(Security8Application.class, args);
	}
	@Bean
	CommandLineRunner run(IRoleService roleService, IUserService userService) {
		return args -> {
			roleService.save(new Role(null, ADMIN));
			roleService.save(new Role(null, PM));
			roleService.save(new Role(null, USER));

			userService.save(new User(null, "admin", "admin", "admin@gmail.com", "1234", new HashSet<>()));
			userService.save(new User(null, "manager", "manager", "manager@gmail.com", "1234", new HashSet<>()));
			userService.save(new User(null, "user", "user", "user@gmail.com", "1234", new HashSet<>()));

			userService.addRoleToUser("admin", ADMIN);
			userService.addRoleToUser("manager", PM);
			userService.addRoleToUser("user", USER);
		};
	}
}
