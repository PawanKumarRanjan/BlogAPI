package com.pawan.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pawan.blog.entities.Category;
import com.pawan.blog.entities.Post;
import com.pawan.blog.entities.User;

public interface PostRepo extends JpaRepository<Post,Long>{
	
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
	List<Post> findByTitleContaining(String title);

}
