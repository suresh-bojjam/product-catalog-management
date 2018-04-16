package com.globomart.catalog.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"productId",
	"productName",
	"productDescription",
	"unitPrice",
	"vendorId",
	"category"
})

/**
 * 
 * @author suresh bojjam
 * Product class is used as both DTO and Entity
 * we can separate with the DTOMapper for Product to ProductDTO mapping
 */

@Entity
@Table(name = "Products")
public class Product {

	@JsonProperty("productId")
	@Column(name="product_id")
	@Id
	private Long productId;
	@JsonProperty("productName")
	@Column(name="product_name")
	@Size(min=2, max=20)
	private String productName;
	@JsonProperty("productDescription")
	@Column(name="product_description")
	@Size(min=2, max=20) 
	private String productDescription;
	@JsonProperty("unitPrice")
	@Column(name="unit_price")
	private Double unitPrice;
	@JsonProperty("vendorId")
	@Column(name="vendor_id")
	private String vendorId;
	@JsonProperty("category")
	@Column(name="category")
	private String category;

/*	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();*/

	/**
	 * 
	 */
	public Product(){

	}

	/**
	 * Copy Constructor
	 * @param product
	 */
	public Product(Product product) {
		this.setProductId(product.getProductId());
	}
	

	/**
	 * 
	 * @param productId
	 * @param productName
	 * @param productDescription
	 * @param unitPrice
	 * @param vendorId
	 * @param category
	 */
	public Product(Long productId,
			String productName,
			String productDescription,
			Double unitPrice,
			String vendorId,
			String category
			){

		this.productId=productId;
		this.productName=productName;
		this.productDescription=productDescription;
		this.unitPrice=unitPrice;
		this.vendorId=vendorId;
		this.category=category;
	}

	@JsonProperty("productId")
	public Long getProductId() {
		return productId;
	}

	@JsonProperty("productId")
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	@JsonProperty("productName")
	public String getProductName() {
		return productName;
	}

	@JsonProperty("productName")
	public void setProductName(String productName) {
		this.productName = productName;
	}

	@JsonProperty("productDescription")
	public String getProductDescription() {
		return productDescription;
	}

	@JsonProperty("productDescription")
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	@JsonProperty("unitPrice")
	public Double getUnitPrice() {
		return unitPrice;
	}

	@JsonProperty("unitPrice")
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	@JsonProperty("vendorId")
	public String getVendorId() {
		return vendorId;
	}

	@JsonProperty("vendorId")
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	@JsonProperty("category")
	public String getCategory() {
		return category;
	}

	@JsonProperty("category")
	public void setCategory(String category) {
		this.category = category;
	}

/*	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}*/
}