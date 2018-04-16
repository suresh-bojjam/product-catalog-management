package com.globomart.catalog.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.globomart.catalog.defs.SearchType;
import com.globomart.catalog.exceptions.GloboMartException;
import com.globomart.catalog.models.Product;

/**
 * BusinessLayer for CatalogService
 * 
 * @author Suresh Bojjam
 * 
 */
@Component
public interface CatalogService {

	public List<Product> listProducts();
	public Product addProduct(Product product);
	public void removeProduct(Long productId);
	public List<Product> searchProducsts(String queryString,SearchType searchType) throws GloboMartException;
	public List<Product> searchProducts(String queryString,SearchType searchType,int page_no,int page_size);
}