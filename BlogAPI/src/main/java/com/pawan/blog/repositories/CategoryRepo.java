package com.pawan.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pawan.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category,Long> {

}
