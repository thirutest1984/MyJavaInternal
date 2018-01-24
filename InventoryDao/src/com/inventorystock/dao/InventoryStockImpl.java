package com.inventorystock.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Implementation class for Enterprise Inventory Stock management using DAO
 * 
 * @author (M1035775) Kotra Thirumala
 *
 */

public class InventoryStockImpl {

	/**
	 * Scanner class for getting inputs from the user
	 */
	Scanner scanner = new Scanner(System.in);

	/**
	 * Creating an ArrayList
	 */
	List<InventoryStockDao> listInventory = new ArrayList<InventoryStockDao>();

	private static int PRODUCTID = 100;

	/**
	 * Method for displaying the menu options for the user
	 */
	private void displayMenu() {
		System.out.println("User menu options: ");
		System.out.println("1 - to add to inventory" + "\n" + "2 - to display inventory" + "\n" + "3 - to make purchase"
				+ "\n" + "4 - exit from the program");
	}

	/**
	 * Method for getting input from the user
	 */
	private void getUserInput() {
		System.out.println("Please choose your option: ");
		int option = scanner.nextInt();
		scanner.nextLine();
		switch (option) {
		case 1:
			// Add to inventory case
			System.out.println("Add items to the inventory.");
			addInventoryMenu();
			break;
		case 2:
			// Display the inventory case
			System.out.println("Display the inventory stock: ");
			displayInventory();
			break;
		case 3:
			// Purchase an item case
			makePurchase();
			break;
		case 4:
			// Exit from the program case
			exitFromProgram();
			break;
		default:
			System.out.println("Please enter the valid option.");
			break;
		}
	}

	/**
	 * Method for getting inventory item details and store them in the ArrayList
	 */
	private void addInventoryMenu() {
		System.out.println("Enter the Product name: ");
		String productName = scanner.nextLine();

		System.out.println("Enter the Make and Model: ");
		String makeAndModelName = scanner.nextLine();

		System.out.println("Enter the Number of items: ");
		int numberOfItems = scanner.nextInt();

		System.out.println("Enter the Item Price: ");
		double itemPrice = scanner.nextDouble();

		// Adding the inventory items to the ArrayList
		listInventory.add(new InventoryStockDao(PRODUCTID, productName, makeAndModelName, numberOfItems, itemPrice));
		PRODUCTID = PRODUCTID + 1;
		displayMenu();
		getUserInput();
	}

	/**
	 * Method for getting all product inventory details and inventory list
	 * 
	 * @return listInventory
	 */
	private List<InventoryStockDao> getAllProducts() {
		return listInventory;
	}

	/**
	 * Method for display the Inventory stock items in the list
	 */
	private void displayInventory() {
		for (InventoryStockDao inventoryStockDao : getAllProducts()) {
			System.out.println(inventoryStockDao.getProductId() + " | " + inventoryStockDao.getProductName() + " | "
					+ inventoryStockDao.getMakeAndModelName() + " | " + inventoryStockDao.getNumberOfItems() + " | "
					+ inventoryStockDao.getItemPrice() + "\n");
		}
		displayMenu();
		getUserInput();
	}

	/**
	 * Method for display the available products with product id during the purchase
	 */
	private void displayProductOnPuchase() {
		for (InventoryStockDao inventoryStockDao : getAllProducts()) {
			System.out.println(inventoryStockDao.getProductId() + " | " + inventoryStockDao.getProductName() + " | "
					+ inventoryStockDao.getMakeAndModelName() + "\n");
		}
	}

	/**
	 * Method for make purchase an item
	 */
	private void makePurchase() {
		displayProductOnPuchase();
		System.out.println("Select the Item by entering the product id.");
		int item = scanner.nextInt();
		for (InventoryStockDao inventoryStockDao : getAllProducts()) {
			if (inventoryStockDao.getProductId() == item) {
				System.out.println(inventoryStockDao.getProductId() + " " + inventoryStockDao.getProductName()
						+ " item is selected for purchase.");
				System.out.println("Enter the number of items: ");
				int requiredItems = scanner.nextInt();
				if (requiredItems <= inventoryStockDao.getNumberOfItems() && requiredItems != 0) {
					double totalPrice = requiredItems * inventoryStockDao.getItemPrice();
					generateBill(inventoryStockDao.getProductId(), inventoryStockDao.getProductName(),
							inventoryStockDao.getMakeAndModelName(), requiredItems, inventoryStockDao.getItemPrice(),
							totalPrice);
					int remainingItems = (inventoryStockDao.getNumberOfItems() - requiredItems);

					inventoryStockDao.setNumberOfItems(remainingItems);
				} else {
					System.out.println("Inventory: Out of stock.");
				}
			}
		}
		displayMenu();
		getUserInput();
	}

	/**
	 * Method for generating the bill for the purchased items
	 * 
	 * @param pid
	 * @param pName
	 * @param mam
	 * @param noi
	 * @param pr
	 * @param tpr
	 */
	private void generateBill(int pid, String pName, String mam, int noi, double pr, double tpr) {
		System.out.println("*************************************Purchased Bill*************************************");
		System.out
				.println("| Product Id | Product Name | Make and Model | Number of Items | Item price | Total Price |");
		System.out.println("| " + pid + " | " + pName + " | " + mam + " | " + noi + " | " + pr + " | " + tpr + " |");
	}

	/**
	 * Method for exit from the program
	 */
	private void exitFromProgram() {
		System.out.println("Exited from the program.");
		scanner.close();
		System.exit(0);
	}

	/**
	 * Main method for the InventoryStockImpl class
	 */
	public static void main(String[] args) {
		// Creating the class object
		InventoryStockImpl inventoryStockObj = new InventoryStockImpl();
		inventoryStockObj.displayMenu();
		inventoryStockObj.getUserInput();
	}
}
