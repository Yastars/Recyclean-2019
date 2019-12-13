package com.elte.recyclean.service;

import java.util.List;

import com.elte.recyclean.entity.User;

public interface UserService {

	public List<User> getAllUsers();
	public User registerUser(User user);
	public User getUser(String userEmail, String userPass);
	public String deleteUser(long userId, String userEmail);
	public String updateUser(long userId, int userCredits);

}
