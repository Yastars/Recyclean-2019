package com.elte.recyclean.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product implements Serializable{

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private long Prod_Id;
		private String Prod_Name;
		private String Prod_Image;
		private String Prod_BarCode;
		private String Prod_SM_Name;
		private int Prod_Credits;
		private String Last_Updated_By;

		
		public Product(){
			super();
		}
		
		public Product(String Prod_Name) {
			this.Prod_Name = Prod_Name;
		}

		public void setProd_Id(long prod_Id) {
			Prod_Id = prod_Id;
		}

		public void setProd_Name(String prod_Name) {
			Prod_Name = prod_Name;
		}

		public void setProd_Image(String prod_Image) {
			Prod_Image = prod_Image;
		}

		public void setProd_BarCode(String prod_BarCode) {
			Prod_BarCode = prod_BarCode;
		}

		public void setProd_SM_Name(String prod_SM_Name) {
			Prod_SM_Name = prod_SM_Name;
		}

		public Product(String prod_Name, String prod_Image, String prod_BarCode, String prod_SM_Name,
				String last_Updated_By, int Prod_Credits) {
			super();
			this.Prod_Name = prod_Name;
			this.Prod_Image = prod_Image;
			this.Prod_BarCode = prod_BarCode;
			this.Prod_SM_Name = prod_SM_Name;
			this.Last_Updated_By = last_Updated_By;
			this.Prod_Credits = Prod_Credits;
		}

		public long getProd_Id() {
			return Prod_Id;
		}

		public String getProd_Name() {
			return Prod_Name;
		}

		public String getProd_Image() {
			return Prod_Image;
		}

		public String getProd_BarCode() {
			return Prod_BarCode;
		}

		public String getProd_SM_Name() {
			return Prod_SM_Name;
		}

		public String getLast_Updated_By() {
			return Last_Updated_By;
		}

		public void setLast_Updated_By(String last_Updated_By) {
			this.Last_Updated_By = last_Updated_By;
		}

		public int getProd_Credits() {
			return Prod_Credits;
		}

		public void setProd_Credits(int prod_Credits) {
			this.Prod_Credits = prod_Credits;
		}

		@Override
		public String toString() {
			return "Product [Prod_Id=" + Prod_Id + ", Prod_Name=" + Prod_Name + ", Prod_Image=" + Prod_Image
					+ ", Prod_BarCode=" + Prod_BarCode + ", Prod_SM_Name=" + Prod_SM_Name + ", Last_Updated_By="
					+ Last_Updated_By + ", Prod_Credits=" + Prod_Credits + "]";
		}

		
				
	}

