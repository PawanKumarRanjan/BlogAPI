package com.pawan.blog.services;

import java.util.List;

import com.pawan.blog.payloads.PostDto;
import com.pawan.blog.payloads.PostResponse;

public interface PostService {
	
	PostDto createPost(PostDto postDto, Long postId, Long categoryId);
	
	PostDto updatePost(PostDto postDto, Long postId);
	
	void deletePost(Long postId);
	
	PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDirection);
	
	PostDto getPostById(Long postId);
	
	List<PostDto> getPostByCategory(Long categoryId);
	
	List<PostDto> getPostByUser(Long userId);
	
	List<PostDto> searchPosts(String keyword);

}
