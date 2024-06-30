package com.SpringBootSample.crud.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.SpringBootSample.crud.model.Address;
import com.SpringBootSample.crud.model.AddressResponse;
import com.SpringBootSample.crud.model.Product;
import com.SpringBootSample.crud.model.ProductDto;
//import com.SpringBootSample.crud.model.Product;
import com.SpringBootSample.crud.service.ProductServiceImpl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductServiceImpl productserviceimpl;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/products")
	public List<Product> getproductdetails()
	{
		return productserviceimpl.getProducts();
	}
	
	@PostMapping("/saveproduct")
	public Product createProduct(@RequestBody Product product)
	{
		return productserviceimpl.saveProducts(product);
	}
	@GetMapping("/Products/{productid}")
	public Optional<Product> getProductDetailsById(@PathVariable int productid)
	{
		return productserviceimpl.getProductById(productid);
	}
	@DeleteMapping("/delproduct/{productid}")
	public void removeProductById(@PathVariable int productid)
	{
		productserviceimpl.deleteProductById(productid);
	}
	
	@RequestMapping(value="/productaddress")
	@CircuitBreaker(name = "PRODUCT-SERVICE", fallbackMethod = "getDefValue")
	public String getProductList()
	{
		
		HttpHeaders headers=new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity=new HttpEntity<String>(headers);
	    return restTemplate.exchange("http://localhost:8083/address/addressdetails",HttpMethod.GET,entity,String.class).getBody();
		
	}
	
	@GetMapping("/proaddress/{productid}")
	public ProductDto getProductAddressDetailsById(@PathVariable int productid)
	{
		
		return productserviceimpl.getProductAddressDetlsById(productid);
	/*	//Address address=new Address();
		Product product= productserviceimpl.getProductById(productid).get();
		ProductDto productDto=modelMapper.map(product, ProductDto.class);
		AddressResponse addressResponse=restTemplate.getForObject("http://localhost:8083/address/addressdetails/{productid}", AddressResponse.class,productid);
		//Address address=restTemplate.getForObject("http://localhost:8083/address/addressdetails/"+productid, Address.class);
		
		//Product product=productdata;
		//productDto.setAddressResponse(addressResponse);
		productDto.setAddressResponse(addressResponse);
		//product.setAddress(address);
	       return productDto;*/
	}
	
	
	public String getDefValue(Exception e)
	{
		return "default address getting from address service";
	}
	
	@PutMapping("/updateProduct/{productid}")
      public ResponseEntity<Product> updateProductById(@PathVariable int productid,@RequestBody Product productdetails)
      {
    	  return productserviceimpl.updateProductsById(productid,productdetails);
      }
}
