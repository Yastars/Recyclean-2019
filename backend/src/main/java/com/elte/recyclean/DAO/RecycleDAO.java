package com.elte.recyclean.DAO;

import java.util.List;

import com.elte.recyclean.entity.UserWasteDetails;

public interface RecycleDAO {
	public List<UserWasteDetails> getWasteHistory(long userId);

	}
