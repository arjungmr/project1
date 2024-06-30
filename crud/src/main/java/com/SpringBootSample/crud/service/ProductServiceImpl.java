package com.SpringBootSample.crud.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.SpringBootSample.crud.ProductRepo.ProductRepo;
import com.SpringBootSample.crud.model.AddressResponse;
import com.SpringBootSample.crud.model.Product;
import com.SpringBootSample.crud.model.ProductDto;

@Service

public class ProductServiceImpl {

	@Autowired
	private ProductRepo productrepo;
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private RestTemplate restTemplate;

	public List<Product> getProducts() {
		return productrepo.findAll();
	}

	public Product saveProducts(Product product) {
		return productrepo.save(product);
	}

	public Optional<Product> getProductById(int productid) {
		return productrepo.findById(productid);
	}

	public void deleteProductById(int productid) {
		productrepo.deleteById(productid);
	}

	public ProductDto getProductAddressDetlsById(int productid) {

		AddressResponse addressresponse = new AddressResponse();
		Product product = productrepo.findById(productid).get();
		ProductDto productDto = modelMapper.map(product, ProductDto.class);
		AddressResponse addressResponse = restTemplate
				.getForObject("http://localhost:8083/address/addressid/{productid}", AddressResponse.class, productid);
		// Address
		// address=restTemplate.getForObject("http://localhost:8083/address/addressdetails/"+productid,
		// Address.class);

		// return product;
		// Product product=productdata;
		productDto.setAddressResponse(addressResponse);
		// productDto.setAddressResponse(addressResponse);
		// product.setAddress(address);
		return productDto;
	}

	public ResponseEntity<Product> updateProductsById(int productid, Product productdetails) {

		Product productupdate = productrepo.findById(productid).get();
		productupdate.setProductid(productdetails.getProductid());
		productupdate.setProductname(productdetails.getProductname());
		productupdate.setPrice(productdetails.getPrice());

		Product updateProduct = productrepo.save(productupdate);
		return ResponseEntity.ok(updateProduct);
	}

	/*
	*//*
		 * public ResponseEntity<Product> updateProductsById(int productid, Product
		 * productdetails) { Product productupdate=
		 * productrepo.findById(productid).get();
		 * productupdate.setProductid(productdetails.getProductid());
		 * productupdate.setProductname(productdetails.getProductname());
		 * productupdate.setPrice(productdetails.getPrice());
		 * 
		 * Product updateProduct=productrepo.save(productupdate); return
		 * ResponseEntity.ok(updateProduct); }
		 */

}
