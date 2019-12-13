package com.elte.recyclean.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_waste_details")
public class UserWasteDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long Waste_Id;
	private String Last_Updated_By;
	private long prod_id;
	private String prod_name;
	private long user_id;
	

	public UserWasteDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserWasteDetails(String last_Updated_By, long prod_id, String prod_name, long user_id) {
		super();
		this.Last_Updated_By = last_Updated_By;
		this.prod_id = prod_id;
		this.prod_name = prod_name;
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "UserWaste [Waste_Id=" + Waste_Id + ", Last_Updated_By=" + Last_Updated_By + ", prod_id=" + prod_id
				+ ", prod_name=" + prod_name + ", user_id=" + user_id +"]";
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getLast_Updated_By() {
		return Last_Updated_By;
	}

	public void setLast_Updated_By(String last_Updated_By) {
		Last_Updated_By = last_Updated_By;
	}

	public long getWaste_Id() {
		return Waste_Id;
	}

	public void setWaste_Id(long waste_Id) {
		Waste_Id = waste_Id;
	}

	public long getProd_id() {
		return prod_id;
	}

	public void setProd_id(long prod_id) {
		this.prod_id = prod_id;
	}

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

}
