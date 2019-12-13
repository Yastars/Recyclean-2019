package com.elte.recyclean.DAO.impl;

import java.sql.SQLDataException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import com.elte.recyclean.DAO.UserDAO;
import com.elte.recyclean.entity.User;
import com.elte.recyclean.repo.UserRepo;

@Component
public class UserDAOImpl implements UserDAO {

	@Autowired
	private UserRepo userRepo;

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public User registerUser(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	@Override
	public User getUser(String userEmail, String userPass) throws NullPointerException{
		// TODO Auto-generated method stub
		//User user = userRepo.findById(userEmail);
		try{
		Object obj= userRepo.getUserbyEmail(userEmail, userPass);
		System.out.println("User got by email id is :"+ obj.getClass().toString());			
		if(obj!=null){
			User user = (User)obj;
			 return userRepo.getOne(user.getUserId());
		}
		} 
		catch(NullPointerException e){
			System.out.println(e.toString());
			}
		return null;
		}

	@Override
	public String deleteUser(long userId, String userEmail) throws EmptyResultDataAccessException{
		// TODO Auto-generated method stub
		String output;
		try{
		userRepo.deleteById(userId);
		output="User deleted successfully.";
		}
		catch (Exception e){
			System.out.println(e);
			output="Error in deleting user. User doesnot exist";
		}
		return output;
	}

	@Override
	public String updateUser(long userId, int userCredits) throws NoSuchElementException{
		String output="";
		try{
		Optional<User> userOpt=userRepo.findById(userId);
		User user = userOpt.get();
		user.setUserCredits(userCredits);
	
		if (userOpt.isPresent()) {
			user=userRepo.save(user);
			output= "User updated Successfully. "+user.toString();
		} 
		}
		catch(NoSuchElementException e) {
			System.out.println(e);
			output= "Details for user doesnot exist !!! "+e.toString();
		}
		return output;
	}
	}

	
