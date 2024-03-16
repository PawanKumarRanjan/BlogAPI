package com.pawan.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pawan.blog.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Long> {

}
