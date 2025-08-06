package com.example.demo.repositories;

import com.example.demo.entities.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long>{
	//age between
	List<Student> findByAgeBetween(int min, int max);
	//find name no case
	List<Student> findByNameContainingIgnoreCase(String keyword);
	// less to more 
    List<Student> findAllByOrderByAgeAsc();
    //more to less
    List<Student> findAllByOrderByAgeDesc();
    //search name and age between
    List<Student> findByNameContainingIgnoreCaseAndAgeBetween(String name, int min, int max);
   
}
