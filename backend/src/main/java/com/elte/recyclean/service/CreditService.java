package com.elte.recyclean.service;

import java.util.List;

import com.elte.recyclean.entity.Credit;

public interface CreditService {
	
	public String updateCredits(Credit credit);
	public String getCredits(long user_Id);
	public String redeemCredits(long user_Id, int credits);
	
}
