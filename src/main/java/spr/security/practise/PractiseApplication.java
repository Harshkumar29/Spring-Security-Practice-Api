package spr.security.practise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import spr.security.practise.Modal.User;
import spr.security.practise.Services.UserServices;

@SpringBootApplication
public class PractiseApplication implements CommandLineRunner {

	@Autowired
	private UserServices services;
	@Autowired
	private BCryptPasswordEncoder encoder;
	public static void main(String[] args) {
		SpringApplication.run(PractiseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User();
		user1.setEmail("harshkumarver@gmail.com");
		user1.setPassword(encoder.encode("123456"));
		user1.setUsername("harsh kumar");
		user1.setRole("ROLE_NORMAL");

		User user2 = new User();
		user2.setEmail("vvruhan6@gmail.com");
		user2.setPassword(encoder.encode("654321"));
		user2.setUsername("ruhan verma");
		user2.setRole("ROLE_NORMAL");
		services.addUser(user1);
		services.addUser(user2);

		User user = services.getUserbyEmail("vvruhan6@gmail.com");
		System.out.println("user password: "+user.getPassword());
		System.out.println("user email: "+user.getEmail());
		System.out.println("user role: "+user.getRole());
		System.out.println("user username: "+user.getUsername());
	}

}
