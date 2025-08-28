package com.abhishek.DemoSpringSecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abhishek.DemoSpringSecurity.model.Student;
import com.abhishek.DemoSpringSecurity.service.StudentService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	
	@GetMapping("/students")
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		return studentService.getAllStudents();
	}
	
	@GetMapping("/csrf-token")
	public CsrfToken getCsrfToken(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return (CsrfToken) request.getAttribute("_csrf");
	}
	
	@PostMapping("/register")
	public Student addStudent(@RequestBody Student student) {
		studentService.addStudent(student);
		System.out.println(student);
		return student;
	}
	@PostMapping("/login")
	public String login(@RequestBody Student student) {

		return studentService.verify(student);
	}

}
