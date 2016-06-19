package com.taxApp.service;

import com.taxApp.model.AppUser;

public interface AppUserService {
	public int insertAppUser(AppUser _user);
	public AppUser findUserByEmail(String email);
	public AppUser findUserById(int id);
}
