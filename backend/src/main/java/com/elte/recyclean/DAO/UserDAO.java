package com.elte.recyclean.DAO;

import java.util.List;

import com.elte.recyclean.entity.User;

public interface UserDAO {

	public List<User> getAllUsers();
	public User registerUser(User user);
	public User getUser(String userEmail, String userPass);
	public String deleteUser(long userId, String userEmail);
	public String updateUser(long userId, int userCredits);
}
