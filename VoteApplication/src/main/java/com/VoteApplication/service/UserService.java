package com.VoteApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.VoteApplication.domain.Authority;
import com.VoteApplication.domain.User;
import com.VoteApplication.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	// create a method that will save user object to DB
	public User save(User user) {
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		Authority authority = new Authority();
		authority.setAuthority("ROLE_USER");
		authority.setUser(user);
		
		user.getAuthorities().add(authority);
		
		
		return userRepo.save(user);
		
	}
	
	
}
