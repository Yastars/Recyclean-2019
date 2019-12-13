package com.elte.recyclean.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elte.recyclean.DAO.RecycleDAO;
import com.elte.recyclean.entity.UserWasteDetails;
import com.elte.recyclean.service.RecycleService;

@Service
public class RecycleServiceImpl implements RecycleService {

	@Autowired
	private RecycleDAO recycleDAO;

	@Override
	public List<UserWasteDetails> getWasteHistory(long userId) {
		// TODO Auto-generated method stub
		return recycleDAO.getWasteHistory(userId);
	}	
		
}
