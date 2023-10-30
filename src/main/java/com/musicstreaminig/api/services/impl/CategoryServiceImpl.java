package com.musicstreaminig.api.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musicstreaminig.api.entities.Category;
import com.musicstreaminig.api.exceptions.ResourceNotFoundException;
import com.musicstreaminig.api.payloads.CategoryDto;
import com.musicstreaminig.api.repositories.CategoryRepo;
import com.musicstreaminig.api.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		
	Category cat = 	this.modelMapper.map(categoryDto, Category.class);
	Category addedCat =	this.categoryRepo.save(cat);
		
		return this.modelMapper.map(addedCat, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {


		Category cat = this.categoryRepo.findById(categoryId)
				.orElseThrow( ()-> new ResourceNotFoundException("Category", "Category Id", categoryId));
		
		cat.setCategoryTitle(categoryDto.getCategoryTitle());
		cat.setCategoryDescription(categoryDto.getCategoryDescription());
		
		Category updatedCat =   this.categoryRepo.save(cat);
		return this.modelMapper.map(updatedCat, CategoryDto.class);
		
	}

	@Override
	public void deleteCateory(Integer categoryId) {
		Category cat = this.categoryRepo.findById(categoryId)
				.orElseThrow(() ->new ResourceNotFoundException("Category", "Category Id", categoryId));
		this.categoryRepo.delete(cat);
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {


		Category cat = this.categoryRepo.findById(categoryId)
				.orElseThrow(()-> new ResourceNotFoundException("cCategory", "Category Id", categoryId));
		
		
		return this.modelMapper.map(cat, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getCategories() {


	List<Category> categories =	this.categoryRepo.findAll();
	List<CategoryDto> catDtos =  categories.stream().map((cat) -> this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		return catDtos;
	}

}
