package com.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.entities.AppUser;



public interface UserRepository extends JpaRepository<AppUser, String> {
	public AppUser findByUsername(String username);
}