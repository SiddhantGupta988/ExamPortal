package com.exam;



import
		java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exam.models.Role;
import com.exam.models.User;
import com.exam.models.UserRole;
import com.exam.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin("*")
@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner{


	@Autowired
	private UserService userservice;

	@Autowired
	private PasswordEncoder passwordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User user = new User();
		user.setFirstName("raj");
		user.setLastName("gupta");
		user.setUsername("raj303");
		user.setEmail("raj@gmail.com");
		user.setPassword(this.passwordEncoder.encode("12323"));
		user.setPhone("855465777");
		user.setProfile("profile.png");
		
		Role r1 = new Role();
		r1.setRole_id(23L);
		r1.setRole("Admin");


		UserRole user_role = new UserRole();
		user_role.setRole(r1);
		user_role.setUser(user);
		
		Set<UserRole> user_role_set = new HashSet<>();
		user_role_set.add(user_role);
//
//		User user1 = new User();
//		user1.setFirstName("sid");
//		user1.setLastName("gupta");
//		user1.setUsername("sid101");
//		user1.setEmail("sid@gmail.com");
//		user1.setPassword(this.passwordEncoder.encode("12323"));
//		user1.setPhone("7007672151");
//		user1.setProfile("profile.png");
//
//		Role r2 = new Role();
//		r2.setRole_id(20L);
//		r2.setRole("Admin");
//
//
//		UserRole user_role1 = new UserRole();
//		user_role1.setRole(r1);
//		user_role1.setUser(user);
//
//		Set<UserRole> user_role_set1 = new HashSet<>();
//		user_role_set1.add(user_role);
//
		User user2 = this.userservice.createUser(user,user_role_set);
//		User user3 = this.userservice.createUser(user1,user_role_set1);
		System.out.println(user2.getUsername());
	}

}
 