package com.musicstreaminig.api.services;

import java.util.List;

import com.musicstreaminig.api.payloads.CategoryDto;

public interface CategoryService {
	
	
	
	//CREATE
	
	CategoryDto createCategory(CategoryDto categoryDto);
	
	//UPDATE
	CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
	
	//DELETE by Id
	void deleteCateory(Integer categoryId);
	
	//GET
	CategoryDto getCategory(Integer categoryId);
	
	//GET ALL
	List<CategoryDto> getCategories();

}
