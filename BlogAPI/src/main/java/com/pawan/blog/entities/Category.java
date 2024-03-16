package com.pawan.blog.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="categories")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoryId;
	
	@Column(name="title")
	private String categoryTitle;
	
	@Column(name="description")
	private String categoryDescription;
	
	@OneToMany(mappedBy="category", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Post> post=new ArrayList<>();

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

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}

	public Category(Long categoryId, String categoryTitle, String categoryDescription, List<Post> post) {
		super();
		this.categoryId = categoryId;
		this.categoryTitle = categoryTitle;
		this.categoryDescription = categoryDescription;
		this.post = post;
	}
	
	public Category()
	{
		
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryTitle=" + categoryTitle + ", categoryDescription="
				+ categoryDescription + ", post=" + post + "]";
	}

}
