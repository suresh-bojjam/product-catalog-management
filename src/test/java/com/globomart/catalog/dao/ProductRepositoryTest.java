package com.globomart.catalog.dao;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;
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
		loadData().forEach((product)->{
			try {
				restClient.exchange("http://localhost:8080/v1/add", 
						HttpMethod.POST,
						new HttpEntity<Product>(product), 
						Product.class);	
			} catch (Exception e) {
				e.printStackTrace();
			}				
		});
	}
	
	private static List<Product> loadData() {
		List<Product> products=new ArrayList<>();
		products.add(new Product(new Long(1001),
				"TVS Apache",
				"TVS bike",
				new Double(2000000),
				"BIKE",
				"101"));
		
		products.add(new Product(new Long(1002),
				"Bajaj Domiar",
				"Bajaj bike",
				new Double(2500000),
				"BIKE",
				"102"));

		products.add(new Product(new Long(1003),
				"Hero bicycle",
				"bicycle",
				new Double(8000),
				"BICYCLE",
				"103"));

		products.add(new Product(new Long(1004),
				"Honda Citi",
				"Honda Car",
				new Double(1600000),
				"CAR",
				"104"));
		
		products.add(new Product(new Long(1005),
				"MUSTANG GT",
				"GT Car",
				new Double(3500000),
				"CAR",
				"105"));
		
		products.add(new Product(new Long(1006),
				"Honda bicycle",
				"bicycle",
				new Double(8000),
				"BICYCLE",
				"106"));
		return products;
	}

	private static long getRandomIntegerBetweenRange(int min, int max){
		long x = (int)(Math.random()*((max-min)+1))+min;
		return x;
	}
}