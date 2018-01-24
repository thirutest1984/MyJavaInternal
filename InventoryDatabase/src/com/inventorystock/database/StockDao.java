package com.inventorystock.database;

/**
 * Creating a Stock DAO class for the an Electronic items store management.
 * 
 * @author M1035775 Kotra Thirumala
 *
 */

public class StockDao {

	/**
	 * Defining the required class variables.
	 */

	private String productName;
	private String makeAndModelName;
	private int numberOfItems;
	private double itemPrice;
	private int productId;

	/**
	 * Constructor for InventoryStock class
	 * 
	 * @param productId
	 * @param productName
	 * @param makeAndModelName
	 * @param numberOfItems
	 * @param itemPrice
	 */

	public StockDao(int productId, String productName, String makeAndModelName, int numberOfItems, double itemPrice) {
		this.productName = productName;
		this.makeAndModelName = makeAndModelName;
		this.numberOfItems = numberOfItems;
		this.itemPrice = itemPrice;
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getMakeAndModelName() {
		return makeAndModelName;
	}

	public void setMakeAndModelName(String makeAndModelName) {
		this.makeAndModelName = makeAndModelName;
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

}
