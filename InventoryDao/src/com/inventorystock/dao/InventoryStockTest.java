package com.inventorystock.dao;

import static org.junit.Assert.*;

import org.junit.Test;

public class InventoryStockTest {

	@Test
	public void testClassNameInventoryStockImpl() {
		InventoryStockImpl inv = new InventoryStockImpl();		
		String expected = "class com.inventorystock.dao.InventoryStockImpl";
		assertEquals(expected, String.valueOf(inv.getClass()));
	}
	
	@Test
	public void testClassNameInventoryStockImplFail() {
		InventoryStockImpl inv = new InventoryStockImpl();		
		String expected = "class com.inventorystock.dao.InventoryStockImpl";
		assertEquals(expected, inv.getClass());
	}

}
