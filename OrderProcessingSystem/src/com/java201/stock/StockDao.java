package com.java201.stock;

public interface StockDao {
	public void addStock(Stock stock);

	public void modifyStock(int productId);

	public void selectStockItem(int productId);
}
