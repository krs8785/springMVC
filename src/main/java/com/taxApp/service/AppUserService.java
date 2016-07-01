package com.taxApp.service;

import com.taxApp.model.AppUser;

public interface AppUserService {
	public long insertAppUser(AppUser _user);
	public AppUser findUserByEmail(String email);
	public AppUser findUserByEmailAndPassword(String email,String password);
	public AppUser findUserById(int id);
}
