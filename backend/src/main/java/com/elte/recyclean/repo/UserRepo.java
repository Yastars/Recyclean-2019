package com.elte.recyclean.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.elte.recyclean.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

	@Query("select u from User u where u.userEmail= :userEmail and u.userPass= :userPass")
    Object getUserbyEmail(@Param("userEmail") String userEmail, @Param("userPass") String userPass);
	
	@Query("select u.user_id, u.userEmail, u.userCredits from User u where u.userEmail= :userEmail")
    Object getUserCredits(@Param("userEmail") String userEmail);

}
