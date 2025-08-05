package com.example.demo.repositories;

import com.example.demo.entities.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long>{
	List<Student> findByAgeBetween(int min, int max);


}
