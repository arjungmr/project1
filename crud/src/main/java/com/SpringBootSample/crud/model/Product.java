package com.SpringBootSample.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;







@Entity
@Table(name="Product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int productid;
	@Column
	private  String productname;
	@Column
	private double price;
	//@OneToOne
	//@JoinColumn(name="id")
	//private AddressResponse addressResponse;
	

	public Product(int productid, String productname, double price ) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.price = price;
		
	}


	/*public AddressResponse getAddressResponse() {
		return addressResponse;
	}


	public void setAddressResponse(AddressResponse addressResponse) {
		this.addressResponse = addressResponse;
	}*/


	public Product()
	{
		
	}
	
	
	public int getProductid() {
		return productid;
	}
	
	public void setProductid(int productid) {
		this.productid = productid;
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

}
