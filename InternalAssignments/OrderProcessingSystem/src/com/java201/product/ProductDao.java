package com.java201.product;

public interface ProductDao {
	public void addProduct(Product product);

	public void modifyProduct(Product product);

	public void selectProduct(int productId);
}
