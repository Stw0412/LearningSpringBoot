package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Farm;

public interface FarmRepository extends JpaRepository<Farm, Long> {
}
