package com.elte.recyclean.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "offer")
public class Offer{

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private long Offer_Id;
		private String Offer_Name;
		private String Offer_Description;
		private int Offer_Credits;
		public long getOffer_Id() {
			return Offer_Id;
		}
		public void setOffer_Id(long offer_Id) {
			Offer_Id = offer_Id;
		}
		public String getOffer_Name() {
			return Offer_Name;
		}
		public void setOffer_Name(String offer_Name) {
			Offer_Name = offer_Name;
		}
		public String getOffer_Description() {
			return Offer_Description;
		}
		public void setOffer_Description(String offer_Description) {
			Offer_Description = offer_Description;
		}
		public int getOffer_Credits() {
			return Offer_Credits;
		}
		public void setOffer_Credits(int offer_Credits) {
			Offer_Credits = offer_Credits;
		}
		@Override
		public String toString() {
			return "Offer [Offer_Id=" + Offer_Id + ", Offer_Name=" + Offer_Name + ", Offer_Description="
					+ Offer_Description + ", Offer_Credits=" + Offer_Credits + "]";
		}
		public Offer(long offer_Id, String offer_Name, String offer_Description, int offer_Credits) {
			super();
			Offer_Id = offer_Id;
			Offer_Name = offer_Name;
			Offer_Description = offer_Description;
			Offer_Credits = offer_Credits;
		}
		
		

}
