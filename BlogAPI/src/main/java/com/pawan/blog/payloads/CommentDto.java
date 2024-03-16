package com.pawan.blog.payloads;

public class CommentDto {
	
	private Long id;
	
	private String content;

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

	public CommentDto(Long id, String content) {
		super();
		this.id = id;
		this.content = content;
	}
	
	public CommentDto()
	{
		
	}

	@Override
	public String toString() {
		return "CommentDto [id=" + id + ", content=" + content + "]";
	}

}
