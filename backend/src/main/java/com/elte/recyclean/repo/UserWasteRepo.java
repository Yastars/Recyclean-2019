package com.elte.recyclean.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.elte.recyclean.entity.UserWasteDetails;

@Repository
public interface UserWasteRepo extends JpaRepository<UserWasteDetails, Long> {
//	@Query("select u.user_id, u.prod_name, u.prod_id from user_waste_details u where u.user_id= :user_id")
//    Object getWasteHist(@Param("user_id") long user_id);
	
}
