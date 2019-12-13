package com.elte.recyclean.DAO.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.elte.recyclean.DAO.CreditDAO;
import com.elte.recyclean.DAO.RecycleDAO;
import com.elte.recyclean.entity.Credit;
import com.elte.recyclean.entity.Product;
import com.elte.recyclean.entity.User;
import com.elte.recyclean.entity.UserWasteDetails;
import com.elte.recyclean.repo.ProductRepo;
import com.elte.recyclean.repo.UserRepo;
import com.elte.recyclean.repo.UserWasteRepo;


@Component
public class RecycleDAOImpl implements RecycleDAO {

	@Autowired
	private UserWasteRepo userWasteRepo;
	
	@Override
	public List<UserWasteDetails> getWasteHistory(long userId) {
		// TODO Auto-generated method stub
		try{		
			List<UserWasteDetails> wasteDetails=userWasteRepo.findAll();
			List<UserWasteDetails> userWasteDetails= new ArrayList<>();
			System.out.println(wasteDetails);
			Iterator<UserWasteDetails> itr=wasteDetails.iterator();
			
			while(itr.hasNext()){
				UserWasteDetails us= itr.next();
				if(us.getUser_id()==userId){
					if(!userWasteDetails.contains(us)){
					userWasteDetails.add(us);
					}
				}
			}
			if(userWasteDetails.size()>0){
			return userWasteDetails;
			}
			else{
				return null;
			}
		}
			catch(NoSuchElementException e) {
			System.out.println(e);
			return null;
		}
		
		catch(NullPointerException e) {
			System.out.println(e);
			return null;
		}
		
	}
}

