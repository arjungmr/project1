package com.SpringBootSample.crud;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.SpringBootSample.crud.ProductRepo.ProductRepo;
import com.SpringBootSample.crud.model.Product;
import com.SpringBootSample.crud.service.ProductServiceImpl;

@SpringBootTest
public class TestCrud {
	
	@Mock
	ProductRepo productrepo;
	
	@InjectMocks
	ProductServiceImpl productserviceimpl;
	
	@Test
	@Order(1)
	public void test_getproducts()
	{
		List<Product> myproducts;
		
		myproducts=new ArrayList<Product>();
		myproducts.add(new Product(1,"LapTop",10000));
	    myproducts.add(new Product(2,"TV",20000));
		
		when(productrepo.findAll()).thenReturn(myproducts);
		assertEquals(2,productserviceimpl.getProducts().size());
		
		
	}

}
