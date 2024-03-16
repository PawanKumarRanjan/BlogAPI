package com.pawan.blog.services;

import java.util.List;

import com.pawan.blog.payloads.CategoryDto;

public interface CategoryService {
	
	CategoryDto createCategory(CategoryDto categoryDto);
	
	CategoryDto updateCategory(CategoryDto categoryDto, Long categoryId);
	
	void deleteCategory(Long categoryId);
	
	CategoryDto getCategory(Long categoryId);
	
	List<CategoryDto> getAllCategories();

}
