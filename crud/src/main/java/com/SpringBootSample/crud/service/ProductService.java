package com.SpringBootSample.crud.service;

import java.util.List;
import java.util.Optional;

//import com.SpringBootSample.crud.AddressResponse.AddressResponse;
import com.SpringBootSample.crud.model.Product;

public interface ProductService {
	
	List<Product> getProducts();
	
	Product saveProduct(Product product);
	Optional<Product> getProductById(int productid);
	void deleteProductById(int productid);
	

}
