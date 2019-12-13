package com.elte.recyclean.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User implements Serializable{

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private long user_id;
		private String username;
		private String userPass;
		private String userEmail;
		private String userAddress;
		private String userPhone;
		private int userCredits;
		private String lastUpdatedBy;
		
		public User(){
			super();
		}
		
		public User(String username, String userPass, String userEmail, String userAddress, String userPhone,
				String lastUpdatedBy) {
			this.username = username;
			this.userPass = userPass;
			this.userEmail = userEmail;
			this.userAddress = userAddress;
			this.userPhone = userPhone;
			this.lastUpdatedBy = lastUpdatedBy;
		}
		
		public long getUserId() {
			return user_id;
		}
		public void setUserId(long userId) {
			this.user_id = userId;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getUserPass() {
			return userPass;
		}
		public void setUserPass(String userPass) {
			this.userPass = userPass;
		}
		public String getUserEmail() {
			return userEmail;
		}
		public void setUserEmail(String userEmail) {
			this.userEmail = userEmail;
		}
		public String getUserPhone() {
			return userPhone;
		}
		public void setUserPhone(String userPhone) {
			this.userPhone = userPhone;
		}
		public int getUserCredits() {
			return userCredits;
		}
		public void setUserCredits(int userCredits) {
			this.userCredits = userCredits;
		}
		public String getLastUpdatedBy() {
			return lastUpdatedBy;
		}
		public void setLastUpdatedBy(String lastUpdatedBy) {
			this.lastUpdatedBy = lastUpdatedBy;
		}
		
		public String getUserAddress() {
			return userAddress;
		}

		public void setUserAddress(String userAddress) {
			this.userAddress = userAddress;
		}

		@Override
		public String toString() {
			return "User [userId=" + user_id + ", username=" + username + ", userPass=" + userPass + ", userEmail="
					+ userEmail + ", userAddress=" + userAddress + ", userPhone=" + userPhone + ", userCredits="
					+ userCredits + ", lastUpdatedBy=" + lastUpdatedBy +  "]";
		}
		
	}

