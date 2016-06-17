package com.taxApp.service;

import com.taxApp.model.appUser;

public interface appUserService {
	public int insertAppUser(appUser _user);
	public appUser findUserByEmail(String email);
	public appUser findUserById(int id);
}
