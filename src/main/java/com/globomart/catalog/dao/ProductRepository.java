package com.globomart.catalog.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.globomart.catalog.defs.SearchType;
import com.globomart.catalog.exceptions.GloboMartException;
import com.globomart.catalog.models.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product,Long>, JpaSpecificationExecutor<Product>{
	
	//public List<Product> searchProducsts(String queryString,SearchType searchType) throws GloboMartException;
	//public List<Product> searchProducts(String queryString,SearchType searchType,int page_no,int page_size);
	
}
