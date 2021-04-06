package com.productview.sample.productview.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Productview {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;

	private String productManufacturer;
	private String productType;
	private String productAvailability;
	private String productPrice;

	public Productview(int productId, String productType) {
		super();
		this.productId = productId;
		this.productType = productType;
	}

	public Productview(int productId, String productManufacturer, String productAvailability, String productPrice,
			String productType) {
		super();
		this.productId = productId;
		this.productManufacturer = productManufacturer;
		this.productType = productType;
		this.productAvailability = productAvailability;
		this.productPrice = productPrice;
	}

	public Productview() {

	}

	@Override
	public String toString() {
		return "Productview{" + "productId=" + productId + ", productManufacturer='" + productManufacturer + '\''
				+ ", productType='" + productType + '\'' + ", productAvailability='" + productAvailability + '\''
				+ ", productPrice='" + productPrice + '\'' + '}';
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductManufacturer() {
		return productManufacturer;
	}

	public void setProductManufacturer(String productManufacturer) {
		this.productManufacturer = productManufacturer;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductAvailability() {
		return productAvailability;
	}

	public void setProductAvailability(String productAvailability) {
		this.productAvailability = productAvailability;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
}
