package com.SpringBootSample.crud.ProductRepo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.SpringBootSample.crud.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{
	
	
	//@Query(nativeQuery=true,value="select Address.id,Address.addressName Product.productid,Product.productname,Product.price from Address join Product on Address.id=Product=productid where productid=productid" )
	//public Product getProductAddressById(int productid);
	
		
	

}
