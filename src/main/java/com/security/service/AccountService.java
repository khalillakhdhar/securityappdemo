package com.security.service;

import com.security.entities.AppRole;
import com.security.entities.AppUser;

public interface AccountService {
	public AppUser saveUser(AppUser user);
	public AppRole saveRole(AppRole role);
	public void addRoleToUser(String username,String roleName);
	public AppUser findUserByUsername(String username);
}
