package com.java201.stock;

public class Stock {
	private int productId;
	private int quantity;
	private int shopNo;

	/**
	 * @param productId
	 * @param quantity
	 * @param shopNo
	 */
	public Stock(int productId, int quantity, int shopNo) {
		super();
		this.productId = productId;
		this.quantity = quantity;
		this.shopNo = shopNo;
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
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the shopNo
	 */
	public int getShopNo() {
		return shopNo;
	}

	/**
	 * @param shopNo
	 *            the shopNo to set
	 */
	public void setShopNo(int shopNo) {
		this.shopNo = shopNo;
	}

}
