package com.pawan.blog.payloads;

import java.util.List;

public class PostResponse {
	
	private List<PostDto> content;
	private int pageNumber;
	private int pageSize;
	private Long totalElements;
	private int totalPages;
	private boolean lastPage;
	
	
	public List<PostDto> getContent() {
		return content;
	}
	public void setContent(List<PostDto> content) {
		this.content = content;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public Long getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(Long totalElements) {
		this.totalElements = totalElements;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public boolean isLastPage() {
		return lastPage;
	}
	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}
	public PostResponse(List<PostDto> content, int pageNumber, int pageSize, Long totalElements, int totalPages,
			boolean lastPage) {
		super();
		this.content = content;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.totalElements = totalElements;
		this.totalPages = totalPages;
		this.lastPage = lastPage;
	}
	
	public PostResponse()
	{
		
	}
	@Override
	public String toString() {
		return "PostResponse [content=" + content + ", pageNumber=" + pageNumber + ", pageSize=" + pageSize
				+ ", totalElements=" + totalElements + ", totalPages=" + totalPages + ", lastPage=" + lastPage + "]";
	}
	
}
