package com.globomart.catalog.models;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Product.class)
public class Product_ {
	public static volatile SingularAttribute<Product, String> productName;
	public static volatile SingularAttribute<Product, String> productDescription;
}