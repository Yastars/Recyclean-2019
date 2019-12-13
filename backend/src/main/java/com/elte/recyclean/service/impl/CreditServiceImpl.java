package com.elte.recyclean.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elte.recyclean.DAO.CreditDAO;
import com.elte.recyclean.entity.Credit;
import com.elte.recyclean.service.CreditService;

@Service
public class CreditServiceImpl implements CreditService {

	@Autowired
	private CreditDAO creditDAO;

	@Override
	public String updateCredits(Credit credit) {
		// TODO Auto-generated method stub
		return creditDAO.updateCredits(credit);
	}

	@Override
	public String getCredits(long user_Id) {
		// TODO Auto-generated method stub
		return creditDAO.getCredits(user_Id);
	}

	@Override
	public String redeemCredits(long user_Id, int credits) {
		// TODO Auto-generated method stub
		return creditDAO.redeemCredits(user_Id, credits);
	}	
		
}
