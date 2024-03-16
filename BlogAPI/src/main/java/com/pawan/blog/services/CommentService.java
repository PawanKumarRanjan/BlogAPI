package com.pawan.blog.services;

import com.pawan.blog.payloads.CommentDto;

public interface CommentService {
	
	CommentDto createComment(CommentDto commentDto, Long postId);// by default method are public in an interface
	
	void deleteComment(Long commentId);
}
