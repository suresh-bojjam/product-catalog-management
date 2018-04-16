package com.globomart.catalog.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.globomart.catalog.defs.SearchType;
import com.globomart.catalog.exceptions.GloboMartException;
import com.globomart.catalog.models.Hello;
import com.globomart.catalog.models.Product;
import com.globomart.catalog.service.CatalogService;

/** 
 * @author suresh bojjam
 */
@RestController
@RequestMapping("/v1")
public class CatalogController {
	
	@Autowired
	private CatalogService catalogService;
	
	@RequestMapping(value = "/hello",method=RequestMethod.GET)
	public Hello message() {
		return new Hello("Happy Programming...!");
	}
	
	@RequestMapping(value="/exception",method=RequestMethod.GET)
	public void error() {
		throw new GloboMartException("ExceptionMessage",HttpStatus.BAD_REQUEST.value(),1000);
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Product addProduct(@RequestBody @Valid Product product) {
		return catalogService.addProduct(product);
	}
	
	@RequestMapping(value="/remove/{id}",method=RequestMethod.DELETE)
	public void removeProduct(@PathVariable(value="id") Long productId) {
		catalogService.removeProduct(productId);
	}
	
	
	@RequestMapping(value="/search",method=RequestMethod.GET)
	public List<Product> findProducts(@RequestParam("searchWith") String searchWith){
		return catalogService.searchProducsts(searchWith, SearchType.BY_PRODUCT_NAME);
	}
}