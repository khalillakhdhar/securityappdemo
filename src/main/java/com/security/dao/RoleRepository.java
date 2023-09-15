package com.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.entities.AppRole;



public interface RoleRepository extends JpaRepository<AppRole, String> {
	public AppRole findByRoleName(String roleName);
}