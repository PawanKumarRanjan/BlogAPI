package com.pawan.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pawan.blog.payloads.ApiResponse;
import com.pawan.blog.payloads.CommentDto;
import com.pawan.blog.services.CommentService;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@PostMapping("/add-comment/post/{postId}")
	public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto,@PathVariable Long postId)
	{
		CommentDto createdComment=this.commentService.createComment(commentDto, postId);
		return new ResponseEntity<CommentDto>(createdComment, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-comment/{commentId}")
	public ResponseEntity<ApiResponse> deleteComment(@PathVariable Long commentId)
	{
		this.commentService.deleteComment(commentId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Comment deleted successfully", true), HttpStatus.OK);
	}

}
