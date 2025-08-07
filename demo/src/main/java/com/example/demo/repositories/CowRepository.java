package com.example.demo.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Cow;

public interface CowRepository extends JpaRepository<Cow, Long> {
	
	 List<Cow> findByFarmId(Long farmId);
	 
	 List<Cow> findByCowNameContainingIgnoreCase(String name);

}
