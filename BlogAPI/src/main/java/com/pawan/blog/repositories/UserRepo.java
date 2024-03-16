package com.pawan.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pawan.blog.entities.User;

public interface UserRepo extends JpaRepository<User,Long>{

}
