package com.pawan.blog.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "city")
    private String city;

    @Column(name = "email", unique = true)
    //@Email(message="Email address is not valid")
    private String email;
    
    @Column(name = "password")
    private String password;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "about")
    private String about;
    
    @OneToMany(mappedBy="user", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Post> post=new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}

	public User(Long id, String name, String city, String email, String password, String phone_number, String about,
			List<Post> post) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.email = email;
		this.password = password;
		this.phone_number = phone_number;
		this.about = about;
		this.post = post;
	}
    
    public User()
    {
    	
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", city=" + city + ", email=" + email + ", password=" + password
				+ ", phone_number=" + phone_number + ", about=" + about + ", post=" + post + "]";
	}

}
