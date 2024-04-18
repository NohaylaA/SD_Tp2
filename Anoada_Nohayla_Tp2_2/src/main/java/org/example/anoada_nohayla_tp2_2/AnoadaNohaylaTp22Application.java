package org.example.anoada_nohayla_tp2_2;

import org.example.anoada_nohayla_tp2_2.entities.Role;
import org.example.anoada_nohayla_tp2_2.entities.User;
import org.example.anoada_nohayla_tp2_2.sevice.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class AnoadaNohaylaTp22Application
{
	public static void main(String[] args)
	{
		SpringApplication.run(AnoadaNohaylaTp22Application.class, args);
	}
	@Bean
	CommandLineRunner start(UserService userService)
	{
		return args -> {
			Stream.of("admin","user1","user2","user3", "user4", "user5")
					.forEach(name -> {
						User u=new User();
						u.setUserName(name);
						u.setPassword("123456");
						userService.addNewUser(u);
					});
			Stream.of("Admin","Student","User")
					.forEach(name -> {
						Role r=new Role();
						r.setRoleName(name);
						userService.addNewRole(r);
					});
			userService.addRoleToUser("user1","User");
			userService.addRoleToUser("user2","User");
			userService.addRoleToUser("user3","Student");
			userService.addRoleToUser("user4","User");
			userService.addRoleToUser("user5","Student");
			userService.addRoleToUser("admin","Admin");

			try
			{
				User user=userService.authenticate("user1","13456");
				System.out.println(user.getUserId());
				System.out.println(user.getUserName());
				System.out.println("Roles=>");
				user.getRoles().forEach(r-> {
					System.out.println("Role=>" + r);
				});
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		};
	}
}
