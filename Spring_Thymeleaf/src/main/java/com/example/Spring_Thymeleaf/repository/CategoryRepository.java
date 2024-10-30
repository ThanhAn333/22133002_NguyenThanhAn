package com.example.Spring_Thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Spring_Thymeleaf.entity.Category;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	Optional<Category> findByName(String name);
    Page<Category> findByNameContaining(String name, Pageable pageable);
}
