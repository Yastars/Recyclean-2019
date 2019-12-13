package com.elte.recyclean.service;

import java.util.List;

import com.elte.recyclean.entity.UserWasteDetails;

public interface RecycleService {
	
	public List<UserWasteDetails> getWasteHistory(long userId);
	
}
