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
import com.elte.recyclean.entity.Credit;
import com.elte.recyclean.entity.Product;
import com.elte.recyclean.entity.User;
import com.elte.recyclean.entity.UserWasteDetails;
import com.elte.recyclean.repo.ProductRepo;
import com.elte.recyclean.repo.UserRepo;
import com.elte.recyclean.repo.UserWasteRepo;


@Component
public class CreditDAOImpl implements CreditDAO {

	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private UserWasteRepo wasteRepo;
	
	@Override
	public String updateCredits(Credit credit) {
		// TODO Auto-generated method stub
		int creditsToAdd=0;
		int totalCredits=0;
		try{
			//System.out.println(userRepo.getUserCredits(credit.getUser_Email()));
			//User user= userRepo.getUserCredits(credit.getUser_Email());	
			
			Optional<User> userOpt=userRepo.findById(credit.getUser_Id());
			User user = userOpt.get();
			System.out.println(user.toString());
			
			List<Long> prodIds = new ArrayList<Long>();
		      for(Long id:credit.getProductIds()) {
		         prodIds.add(id);
		      }
		    System.out.println(prodIds); 
			
			List<Product> prods=productRepo.findAllById(prodIds);
			Iterator<Product> itr = prods.iterator();

			while(itr.hasNext()){
				Product prod= itr.next();
				System.out.println(prod.toString());
				creditsToAdd=creditsToAdd+prod.getProd_Credits();
				
				UserWasteDetails userWaste= new UserWasteDetails("Admin", prod.getProd_Id(), prod.getProd_Name(), user.getUserId());
				wasteRepo.save(userWaste);
			}
		
			if(user!=null){
				totalCredits=user.getUserCredits()+creditsToAdd;
				user.setUserCredits(totalCredits);
				userRepo.save(user);
			}
		}
		catch(NoSuchElementException e) {
			System.out.println(e);
			return "Error updating user credits";
		}
		
		catch(NullPointerException e) {
			System.out.println(e);
			return "Null Pointer Exception";
		}
		return "Credits Added: "+creditsToAdd +"\n Total User Credits : "+totalCredits;
	}

	@Override
	public String getCredits(long user_Id) {
		// TODO Auto-generated method stub
		int credits=0;
		try{
			//System.out.println(userRepo.getUserCredits(credit.getUser_Email()));
			//User user= userRepo.getUserCredits(credit.getUser_Email());	
			
			Optional<User> userOpt=userRepo.findById(user_Id);
			User user = userOpt.get();
			
			if(user!=null){
				 credits=user.getUserCredits();
				
			}
		}
		catch(NoSuchElementException e) {
			System.out.println(e);
			return "No user exist with such id";
		}
		
		catch(NullPointerException e) {
			System.out.println(e);
			return "No user exist with such id";
		}
		return "Credit Balance : "+credits;
		
	}

	@Override
	public String redeemCredits(long user_Id, int credits) {
		// TODO Auto-generated method stub
		int remainingCred=0;
		try{
			//System.out.println(userRepo.getUserCredits(credit.getUser_Email()));
			//User user= userRepo.getUserCredits(credit.getUser_Email());	
			
			Optional<User> userOpt=userRepo.findById(user_Id);
			User user = userOpt.get();
			
			if(user!=null){
				if(credits<=user.getUserCredits()){
				 remainingCred=user.getUserCredits()-credits;
				 user.setUserCredits(remainingCred);
				 userRepo.save(user);
				}
				else{
					return "Credit balance is very less to be redeemed. Current Balance : "+user.getUserCredits();
				}
			}
		}
		catch(NoSuchElementException e) {
			System.out.println(e);
			return "No user exist with such id";
		}
		
		catch(NullPointerException e) {
			System.out.println(e);
			return "No user exist with such id";
		}
		return "Credits Redemmed successfully. Remaining balance :"+ remainingCred;
		
	}
	}
