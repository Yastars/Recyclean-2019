package com.elte.recyclean.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elte.recyclean.DAO.UserDAO;
import com.elte.recyclean.entity.User;
import com.elte.recyclean.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userDAO.getAllUsers();
	}

	@Override
	public User registerUser(User user) {
		// TODO Auto-generated method stub
		return userDAO.registerUser(user);
	}

	@Override
	public User getUser(String userEmail, String userPass){
		// TODO Auto-generated method stub
		return userDAO.getUser(userEmail, userPass);
	}

	@Override
	public String deleteUser(long userId, String userEmail) {
		// TODO Auto-generated method stub
		return userDAO.deleteUser(userId, userEmail);
	}

	@Override
	public String updateUser(long userId,int userCredits) {
		// TODO Auto-generated method stub
		return userDAO.updateUser(userId,userCredits);
	}

}
