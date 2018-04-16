package com.globomart.catalog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.globomart.catalog.dao.ProductRepository;
import com.globomart.catalog.dao.ProductSpecification;
import com.globomart.catalog.defs.SearchType;
import com.globomart.catalog.exceptions.GloboMartException;
import com.globomart.catalog.models.Product;
import com.globomart.catalog.service.CatalogService;

@Component
@Service
public class CatalogServiceImpl implements CatalogService{

	private ProductRepository productRepo;
	
	public CatalogServiceImpl() {
		
	}
	
	public CatalogServiceImpl(ProductRepository productRepo) {
		this.productRepo=productRepo;
	}
	
	public ProductRepository getProductRepo() {
		return productRepo;
	}


	@Autowired
	public void setProductRepo(ProductRepository productRepo) {
		this.productRepo = productRepo;
	}


	@Override
	public Product addProduct(Product product) {
		productRepo.save(product);
		return product;
	}

	@Override
	public void removeProduct(Long productId) {
		productRepo.deleteById(productId);
	}

	@Override
	public List<Product> searchProducsts(String queryString, SearchType searchType) throws GloboMartException {
		List<Product> products=null;
		if(SearchType.BY_PRODUCT_NAME.equals(searchType)) {
			products=productRepo.findAll(ProductSpecification.productNameIsLike(queryString));
		}else if(SearchType.BY_PRODUCT_DESCRIPTION.equals(searchType)){
			products=productRepo.findAll(ProductSpecification.productDescIsLike(queryString));
		}
		return products;
	}

	@Override
	public Page<Product> searchProducts(String queryString, SearchType searchType, int page_no, int page_size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> listProducts() {
		return productRepo.findAll();
	}
}