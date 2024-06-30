package com.SpringBootSample.crud.model;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class ProductDto {
	
	
	private int productid;
	private  String productname;
	
	private double price;
	
	private AddressResponse addressResponse;

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}
	public ProductDto()
	{
		
	}

	public ProductDto(int productid, String productname, double price, AddressResponse addressResponse) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.price = price;
		this.addressResponse = addressResponse;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public AddressResponse getAddressResponse() {
		return addressResponse;
	}

	public void setAddressResponse(AddressResponse addressResponse) {
		this.addressResponse = addressResponse;
	}

	
}
