package com.pawan.blog.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pawan.blog.config.AppConstants;
import com.pawan.blog.payloads.ApiResponse;
import com.pawan.blog.payloads.PostDto;
import com.pawan.blog.payloads.PostResponse;
import com.pawan.blog.services.FileService;
import com.pawan.blog.services.PostService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/post")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private FileService fileService;
	
	@Value("${project.image}")
	private String path;
	
	@PostMapping("/user/{userId}/category/{categoryId}")
	public ResponseEntity<PostDto> createPost(
			@Valid@RequestBody PostDto postDto,
			@PathVariable Long userId,
			@PathVariable Long categoryId
			)
	{
		PostDto createPost=this.postService.createPost(postDto, userId, categoryId);
		return new ResponseEntity<PostDto>(createPost,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Long userId )
	{
		List<PostDto> posts=this.postService.getPostByUser(userId);
		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
	}
	
	@GetMapping("/category/{categoryId}")
	public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Long categoryId )
	{
		List<PostDto> posts=this.postService.getPostByCategory(categoryId);
		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
	}
	
	@GetMapping("/posts")
	public ResponseEntity<PostResponse> getAllPost(
			@RequestParam(value="pageNumber", defaultValue=AppConstants.PAGE_NUMBER, required=false) Integer pageNumber,
			@RequestParam(value="pageSize", defaultValue=AppConstants.PAGE_SIZE, required=false)Integer pageSize,
			@RequestParam(value="sortBy", defaultValue=AppConstants.SORT_BY_ID, required=false)String sortBy,
			@RequestParam(value="sortDirection", defaultValue=AppConstants.SORT_BY_DIRECTION, required=false)String sortDirection)
	{
		PostResponse postResponse=this.postService.getAllPost(pageNumber,pageSize,sortBy,sortDirection);
		return new ResponseEntity<PostResponse>(postResponse,HttpStatus.OK);
	}
	
	@GetMapping("/{postId}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Long postId)
	{
		PostDto postDto=this.postService.getPostById(postId);
		return new ResponseEntity<PostDto>(postDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-post/{postId}")
	public ApiResponse deletePost(@PathVariable Long postId)
	{
		this.postService.deletePost(postId);
		return new ApiResponse("Post is successfully deleted",true);
	}
	
	@PutMapping("/update-post/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Long postId)
	{
		PostDto updatedPost=this.postService.updatePost(postDto,postId);
		return new ResponseEntity<PostDto>(updatedPost, HttpStatus.OK);
	}
	
	@GetMapping("/search/{keywords}")
	public ResponseEntity<List<PostDto>> searchPostByTitle(@PathVariable("keywords") String keywords)
	{
		List<PostDto> result=this.postService.searchPosts(keywords);
		return new ResponseEntity<List<PostDto>>(result, HttpStatus.OK);
	}
	
	@PostMapping("/image/upload/{postId}")
	public ResponseEntity<PostDto> uploadPostImage(
			@RequestParam("image") MultipartFile image,
			@PathVariable Long postId) throws IOException
	{
		PostDto postDto=this.postService.getPostById(postId);
		String fileName=this.fileService.uploadImage(path, image);
		postDto.setImageName(fileName);
		PostDto updatedPost=this.postService.updatePost(postDto, postId);
		return new ResponseEntity<PostDto>(updatedPost,HttpStatus.OK);
	}
	
	@GetMapping(value="/image/{imageName}", produces=MediaType.IMAGE_JPEG_VALUE)
	public void downloadImage(
			@PathVariable("imageName")String imageName,
			HttpServletResponse response) throws IOException
	{
		InputStream resource = this.fileService.getResource(path, imageName);
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(resource, response.getOutputStream());
	}
}
