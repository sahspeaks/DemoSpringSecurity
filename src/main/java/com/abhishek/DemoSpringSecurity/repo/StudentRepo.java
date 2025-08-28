package com.abhishek.DemoSpringSecurity.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abhishek.DemoSpringSecurity.model.Student;


@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
	Student findByUsername(String username);
	Student findByEmail(String email);
	Student findById(int id);
	
	// Other CRUD methods can be added here if needed

}
