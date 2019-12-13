package com.elte.recyclean.entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Credit {

	private long[] productIds;
	private String user_Email;
	private long user_Id;
	
	public long[] getProductIds() {
		return productIds;
	}
	public void setProductIds(long[] productIds) {
		this.productIds = productIds;
	}
	
	public String getUser_Email() {
		return user_Email;
	}
	public void setUser_Email(String user_Email) {
		this.user_Email = user_Email;
	}
	
	public long getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(long user_Id) {
		this.user_Id = user_Id;
	}
	
	@Override
	public String toString() {
		return "Credit [productIds=" + productIds + ", user_Email=" + user_Email + ",user_Id="+user_Id+"]";
	}

}
