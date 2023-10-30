package com.musicstreaminig.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musicstreaminig.api.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{
	
	

}
