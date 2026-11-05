package com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.entity.Autor;

public interface AutorRepository extends JpaRepository<Autor, Integer> {

	
}
