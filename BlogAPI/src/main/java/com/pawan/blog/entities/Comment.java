package com.pawan.blog.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="comments")
public class Comment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String content;
	
	@ManyToOne
	private Post post;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Comment(Long id, String content, Post post) {
		super();
		this.id = id;
		this.content = content;
		this.post = post;
	}
	
	public Comment()
	{
		
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", post=" + post + "]";
	}
	
}
