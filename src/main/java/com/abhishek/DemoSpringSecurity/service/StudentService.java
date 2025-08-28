package com.abhishek.DemoSpringSecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.abhishek.DemoSpringSecurity.model.Student;
import com.abhishek.DemoSpringSecurity.repo.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private JWTService jwtService;
	
	@Autowired
	AuthenticationManager authManager;
	
	private BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder(12);
	
	
	public Student addStudent(Student student) {
		// Logic to add a student
		student.setPassword(passwordEncoder.encode(student.getPassword()));
		studentRepo.save(student);
		return student;
	}
	public Student getStudentById(int id) {
		// Logic to get a student by ID
		return studentRepo.findById(id);
	}
	public void deleteStudent(int id) {
		// Logic to delete a student by ID
		studentRepo.deleteById(id);
	}
	public List<Student> getAllStudents() {
		// Logic to get all students
		return studentRepo.findAll();
	}
	public String verify(Student student) {
		Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    student.getUsername(), 
                    student.getPassword()
                )
            );
			if (authentication.isAuthenticated()) {
					return jwtService.generateToken(student.getUsername());
			}
			return "Login Failed";
	}

}
