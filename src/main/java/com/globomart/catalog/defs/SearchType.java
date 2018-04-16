package com.globomart.catalog.defs;

/**
 * @author suresh bojjam
 *
 */
public enum SearchType {
	
	BY_PRODUCT_ID("by_product_id"),
	BY_PRODUCT_NAME("by_product_name"),
	BY_PRODUCT_CATEGORY("by_product_category"),
	BY_PRODUCT_DESCRIPTION("by_product_descr");
	
	private String searchCriteria;
	
	SearchType(String searchCriteria){
		this.searchCriteria=searchCriteria;
	}
}