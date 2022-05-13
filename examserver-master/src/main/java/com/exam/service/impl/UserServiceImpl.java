package com.exam.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.models.User;
import com.exam.models.UserRole;
import com.exam.repo.RoleRepository;
import com.exam.repo.UserRepository;
import com.exam.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;

@Service
@CrossOrigin("*")
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository user_repo;
	
	@Autowired
	RoleRepository role_repo;
	
	
	@Override
	public User createUser(User user, Set<UserRole> userRoles) {
		User local = user_repo.findByUsername(user.getUsername());
		if(local!=null)
		{
			System.out.println("User already exists");
			
			
		}
		else {
			for(UserRole user_role:userRoles)
			{
				role_repo.save(user_role.getRole());
			}
			user.getRole().addAll(userRoles);
			local = this.user_repo.save(user);
		}
		
			
		return local;
	}


	@Override
	public User findUser(String username) {
		return this.user_repo.findByUsername(username);
		
	}


	@Override
	public void deleteUser(Long id) {
		if(id!=null)
			this.user_repo.deleteById(id);
		else
			System.out.println("No entries");
		
	}
	

}
