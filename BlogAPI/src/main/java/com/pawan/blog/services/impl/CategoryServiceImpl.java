package com.pawan.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pawan.blog.entities.Category;
import com.pawan.blog.exceptions.ResourceNotFoundException;
import com.pawan.blog.payloads.CategoryDto;
import com.pawan.blog.repositories.CategoryRepo;
import com.pawan.blog.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category cat=this.modelMapper.map(categoryDto, Category.class);
		Category addedCat=this.categoryRepo.save(cat);
		
		return this.modelMapper.map(addedCat, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Long categoryId) {
		Category cat=this.categoryRepo.findById(categoryId)
				.orElseThrow(()-> new ResourceNotFoundException("Category","category id",categoryId));
		
		cat.setCategoryTitle(categoryDto.getCategoryTitle());
		cat.setCategoryDescription(categoryDto.getCategoryDescription());
		
		Category updatedCat=this.categoryRepo.save(cat);
		
		return this.modelMapper.map(updatedCat, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Long categoryId) {
		Category cat=this.categoryRepo.findById(categoryId)
				.orElseThrow(()-> new ResourceNotFoundException("Category", "category id", categoryId));
		this.categoryRepo.delete(cat);
	}

	@Override
	public CategoryDto getCategory(Long categoryId) {
		
		Category cat=this.categoryRepo.findById(categoryId)
				.orElseThrow(()-> new ResourceNotFoundException("Category", "category id", categoryId));
		return this.modelMapper.map(cat, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategories() {
		List<Category> categories=this.categoryRepo.findAll();
		List<CategoryDto>catDtos=categories.stream().map((cat)->this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		
		return catDtos;
	}

}
