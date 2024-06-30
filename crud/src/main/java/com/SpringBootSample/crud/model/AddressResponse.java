package com.SpringBootSample.crud.model;

import javax.persistence.Column;

public class AddressResponse {
	
     private int id;
	
     private String addressName;
     
     public AddressResponse()
     {
    	 
     }
	 public AddressResponse(int id, String addressName) {
		super();
		this.id = id;
		this.addressName = addressName;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getAddressName() {
		return addressName;
	}


	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}


	

}
