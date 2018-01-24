package com.java201.product;

public class Product {
	private int productId;
	private float productPrice;
	private String productType;

	/**
	 * @param productId
	 * @param productPrice
	 * @param productType
	 */
	public Product(int productId, float productPrice, String productType) {
		super();
		this.productId = productId;
		this.productPrice = productPrice;
		this.productType = productType;
	}

	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * @param productId
	 *            the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}

	/**
	 * @return the productPrice
	 */
	public float getProductPrice() {
		return productPrice;
	}

	/**
	 * @param productPrice
	 *            the productPrice to set
	 */
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	/**
	 * @return the productType
	 */
	public String getProductType() {
		return productType;
	}

	/**
	 * @param productType
	 *            the productType to set
	 */
	public void setProductType(String productType) {
		this.productType = productType;
	}
}
