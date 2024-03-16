package com.pawan.blog.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class CategoryDto {
	
	private Long categoryId;
	
	@NotEmpty
	@Size(max=100, message="Title must not exceed than 100 characters")
	private String categoryTitle;
	
	@NotEmpty
	private String categoryDescription;

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryTitle() {
		return categoryTitle;
	}

	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public CategoryDto(Long categoryId,
			@NotEmpty @Size(max = 100, message = "Title must not exceed than 100 characters") String categoryTitle,
			@NotEmpty String categoryDescription) {
		super();
		this.categoryId = categoryId;
		this.categoryTitle = categoryTitle;
		this.categoryDescription = categoryDescription;
	}
	
	public CategoryDto()
	{
		
	}

	@Override
	public String toString() {
		return "CategoryDto [categoryId=" + categoryId + ", categoryTitle=" + categoryTitle + ", categoryDescription="
				+ categoryDescription + "]";
	}
	
}
