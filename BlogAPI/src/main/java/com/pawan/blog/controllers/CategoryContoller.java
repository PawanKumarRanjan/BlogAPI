package com.pawan.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pawan.blog.payloads.ApiResponse;
import com.pawan.blog.payloads.CategoryDto;
import com.pawan.blog.services.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/category")
public class CategoryContoller {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/create-category")
	public ResponseEntity<CategoryDto> createCategory(@Valid@RequestBody CategoryDto categoryDto)
	{
		CategoryDto createdCategory=this.categoryService.createCategory(categoryDto);
		
		return new ResponseEntity<CategoryDto>(createdCategory,HttpStatus.CREATED);
	}
	
	@PutMapping("/update-category/{catId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid@RequestBody CategoryDto categoryDto, @PathVariable Long catId)
	{
		CategoryDto updatedCategory=this.categoryService.updateCategory(categoryDto, catId);
		
		return new ResponseEntity<CategoryDto>(updatedCategory,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-category/{catId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Long catId)
	{
		this.categoryService.deleteCategory(catId);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("category is deleted successfully", true),HttpStatus.OK);
	}
	
	@GetMapping("/get-single-category/{catId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable Long catId)
	{
		return ResponseEntity.ok(this.categoryService.getCategory(catId));
	}
	
	@GetMapping("/get-all-category")
	public ResponseEntity<List<CategoryDto>> getAllCategory()
	{
		List<CategoryDto> categories=this.categoryService.getAllCategories();
		return ResponseEntity.ok(categories);
	}
	
}
