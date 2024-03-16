package com.pawan.blog.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UserDto {
	
	private Long id;
	
	@NotEmpty		//Blank & Not Null
	@Size(min = 3, message = "Username must be min of 3 characters")
	private String name;
	
	@NotEmpty(message = "City cannot be empty")
	private String city;
	
	@NotEmpty(message = "Email cannot be empty")
	@Email(message="Email address is not valid")
	private String email;
	
	@NotEmpty
	@Size(min = 6, max=10, message = "Password must be min of 6 and max of 10 characters")
	private String password;
	
	@NotEmpty(message = "Phone number cannot be empty")
	@Size(min = 10, max=10, message = "Phone number must be of 10 numbers")
	private String phone_number;
	
	@NotEmpty(message = "About cannot be empty")
	private String about;

	
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

	public UserDto(Long id, @NotEmpty @Size(min = 3, message = "Username must be min of 3 characters") String name,
			@NotEmpty(message = "City cannot be empty") String city,
			@NotEmpty(message = "Email cannot be empty") @Email(message = "Email address is not valid") String email,
			@NotEmpty @Size(min = 6, max = 10, message = "Password must be min of 6 and max of 10 characters") String password,
			@NotEmpty(message = "Phone number cannot be empty") @Size(min = 10, max = 10, message = "Phone number must be of 10 numbers") String phone_number,
			@NotEmpty(message = "About cannot be empty") String about) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.email = email;
		this.password = password;
		this.phone_number = phone_number;
		this.about = about;
	}
	
	
	public UserDto()
	{
		
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", name=" + name + ", city=" + city + ", email=" + email + ", password=" + password
				+ ", phone_number=" + phone_number + ", about=" + about + "]";
	}
	
}
