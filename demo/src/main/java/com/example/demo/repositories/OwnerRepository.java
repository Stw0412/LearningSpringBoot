package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
