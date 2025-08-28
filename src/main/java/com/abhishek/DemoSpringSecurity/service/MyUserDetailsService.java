package com.abhishek.DemoSpringSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.abhishek.DemoSpringSecurity.model.Student;
import com.abhishek.DemoSpringSecurity.repo.StudentRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private StudentRepo studentRepo;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Student student = studentRepo.findByUsername(username);
		if (student == null) {
			throw new UsernameNotFoundException("User not found");
		}

		return new UserPrincipal(student);
	}

}
