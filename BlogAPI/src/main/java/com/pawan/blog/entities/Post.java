package com.pawan.blog.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="post")
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long postId;
	
	@Column(name="post_title")
	private String title;
	
	@Column(name="post_content")
	private String content;
	
	@Column(name="post_image")
	private String imageName;
	
	@Column(name="post_date")
	private Date addedDate;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToMany(mappedBy="post", cascade=CascadeType.ALL)
	private Set<Comment> comments= new HashSet<>();

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Post(Long postId, String title, String content, String imageName, Date addedDate, Category category,
			User user, Set<Comment> comments) {
		super();
		this.postId = postId;
		this.title = title;
		this.content = content;
		this.imageName = imageName;
		this.addedDate = addedDate;
		this.category = category;
		this.user = user;
		this.comments = comments;
	}

	
	public Post()
	{
		
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", title=" + title + ", content=" + content + ", imageName=" + imageName
				+ ", addedDate=" + addedDate + ", category=" + category + ", user=" + user + ", comments=" + comments
				+ "]";
	}
	
}
