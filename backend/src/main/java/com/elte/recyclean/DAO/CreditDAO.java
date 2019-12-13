package com.elte.recyclean.DAO;

import com.elte.recyclean.entity.Credit;

public interface CreditDAO {
	public String updateCredits(Credit credit);
	public String getCredits(long user_Id);
	public String redeemCredits(long user_Id, int credits);

	}
