package com.VoteApplication.service;



import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.not;



import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.Assert;

class UserDetailsServiceTest {

	@Test
	public void generate_encoded_password() {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = "pass123";
		String encodedPassword = encoder.encode(rawPassword);
		
		System.out.println(encodedPassword);
		
	}

}
