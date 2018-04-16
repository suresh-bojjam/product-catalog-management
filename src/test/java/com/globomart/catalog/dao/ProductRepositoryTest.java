package com.globomart.catalog.dao;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.globomart.catalog.defs.Category;
import com.globomart.catalog.models.Product;
import com.globomart.catalog.service.impl.CatalogServiceImpl;
import com.globomart.catalog.utils.JsonUtils;

@RunWith(SpringRunner.class)
public class ProductRepositoryTest {

	private CatalogServiceImpl service;

	private ProductRepository repository;

	@Before
	public void setUp() {
		repository = mock(ProductRepository.class);
		service = new CatalogServiceImpl(repository);
	}


	@Test
	public void testBeans() {
		assertNotNull(repository);
		assertNotNull(service);
	}

	@Test
	public void addProductTest() throws Exception{
		try {
			Product product=new Product();
			product.setProductId(new Long(1234));
			product.setProductName("Book");
			product.setProductDescription("Java Programming");
			product.setUnitPrice(new Double(1000));
			product.setVendorId("100");
			product.setCategory(Category.BOOKS.toString());
			Product products=repository.save(product);
			if(products==null){
				System.out.println("Products NULL");
			}else {
				System.out.println(products.getProductName());
			}
			Optional<Product> product2=repository.findById(product.getProductId());
			if(product2.isPresent()) {
				System.out.println(JsonUtils.readValueAsString(product2.get()));
			}else {
				System.out.println("not present");
			}
		} catch (JsonProcessingException e) {
			System.out.println("Exception: "+e.getMessage());
			throw e;
		}
	}

	@Test
	public void insertTestData() {
		RestTemplate restClient=new RestTemplate();
		Product p;
		int i=1;
		while(i<=10) {
			p=new Product();
			p.setProductId(getRandomIntegerBetweenRange(1000,2000));
			p.setProductName("Book");
			p.setProductDescription("oracle java7");
			p.setCategory("Book");
			p.setUnitPrice(new Double(2500));
			p.setVendorId("101");
			HttpEntity<Product> httpEntity=new HttpEntity<Product>(p);
			restClient.exchange("http://localhost:8080/v1/add", HttpMethod.POST,httpEntity, Product.class);
			i++;
		}
	}

	private static long getRandomIntegerBetweenRange(int min, int max){
		long x = (int)(Math.random()*((max-min)+1))+min;
		return x;
	}
}