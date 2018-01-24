package com.inventorystock.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Implementation class for Enterprise Inventory Stock management using MYSQL
 * database.
 * 
 * @author Kotra Thirumala(M1035775)
 *
 */
public class InventoryDb {

	/**
	 * Define the MYSQL database driver.
	 */
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	/**
	 * MYSQL Database address.
	 */
	static final String SQL_URL = "jdbc:mysql://localhost:3306";

	/**
	 * Inventory database address
	 */
	static final String DB_URL = "jdbc:mysql://localhost:3306/Inventory";

	/**
	 * SELECT SQL command.
	 */
	static final String SELECT = "SELECT * FROM STOCK";

	/**
	 * INSERT SQL command
	 */
	static final String INSERT = "INSERT INTO STOCK(productId,productName, makeAndModelName, numberOfItems, itemPrice) VALUES(?, ?, ?, ?, ?)";

	/**
	 * UPDATE SQL command.
	 */
	static final String UPDATE = "UPDATE STOCK SET numberOfItems=? WHERE productId=?";

	/**
	 * Database credentials
	 */
	static final String USERNAME = "root";
	static final String PASSWORD = "root";

	Connection conn = null;
	Statement stmt = null;
	PreparedStatement psmt = null;

	Scanner scanner = new Scanner(System.in);

	List<StockDao> list = new ArrayList<StockDao>();

	private static int PRODUCTID = 100;

	/**
	 * Basic Display Menu
	 */
	private void displayMenu() {
		// method for display the menu here
		System.out.println("User menu options: ");
		System.out.println("1 - to add to inventory" + "\n" + "2 - to display inventory" + "\n" + "3 - to make purchase"
				+ "\n" + "4 - exit from the program");
	}

	/**
	 * Create Database Inventory
	 */
	private void createDatabase() {

		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Creating a new database...");
			conn = DriverManager.getConnection(SQL_URL, USERNAME, PASSWORD);

			String cDb = "CREATE DATABASE INVENTORY";
			stmt = conn.createStatement();
			stmt.executeUpdate(cDb);
			System.out.println("Database created successfully.");
			createTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Establish Database connection.
	 * 
	 * @return
	 */
	private Connection getConnection() {
		try {
			Class.forName(JDBC_DRIVER);
			return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Create a table in database Inventory.
	 */
	private void createTable() {
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			// create table
			String cTable = "CREATE TABLE Stock " + "(productId INTEGER not NULL, " + " productName VARCHAR(255), "
					+ " makeAndModelName VARCHAR(255), " + " numberOfItems INTEGER, " + "itemPrice DOUBLE not null,"
					+ " PRIMARY KEY ( productId ))";

			stmt.executeUpdate(cTable);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Table created successfully.");
	}

	/**
	 * Insert data into Table Stock.
	 * 
	 * @param stock
	 */
	private void insertData(StockDao stock) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(INSERT);
			psmt.setInt(1, stock.getProductId());
			psmt.setString(2, stock.getProductName());
			psmt.setString(3, stock.getMakeAndModelName());
			psmt.setInt(4, stock.getNumberOfItems());
			psmt.setDouble(5, stock.getItemPrice());
			psmt.executeUpdate();

		} catch (Exception e) {

			throw new RuntimeException(e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (psmt != null) {
					psmt.close();
				}

			} catch (Exception e2) {

				throw new RuntimeException(e2);
			}
		}
	}

	/**
	 * Display the Inventory.
	 */
	private void displayInventoryList() {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SELECT);
			ResultSet res = psmt.executeQuery();
			while (res.next()) {
				int productId = res.getInt("productId");
				String productName = res.getString("productName");
				String makeAndModelName = res.getString("makeAndModelName");
				int numberOfItems = res.getInt("numberOfItems");
				double itemPrice = res.getDouble("itemPrice");

				System.out.println(productId + " | " + productName + " | " + makeAndModelName + " | " + numberOfItems
						+ " | " + itemPrice + "\n");
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		displayMenu();
		getUserInput();
	}

	/**
	 * Update the inventory stock.
	 * 
	 * @param productId
	 * @param numberOfItems
	 */
	private void updateInventory(int productId, int numberOfItems) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(UPDATE);

			psmt.setInt(1, numberOfItems);
			psmt.setInt(2, productId);

			psmt.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	/**
	 * Get the input option from the user.
	 */
	private void getUserInput() {
		System.out.println("Please choose your option: ");
		System.out.println("Enter your option: ");
		int option = scanner.nextInt();
		scanner.nextLine();
		switch (option) {
		case 1: // add to inventory
			addInventoryMenu();
			break;
		case 2: // display inventory
			System.out.println("Display total inventory stock:");
			displayInventoryList();
			break;
		case 3: // make purchase
			makePurchase();
			break;
		case 4: // exit from the program
			exitFromProgram();
			break;
		default:
			System.out.println("Please enter a valid option.");
			break;
		}
	}

	/**
	 * Get the inventory item details and store them in database.
	 */
	private void addInventoryMenu() {
		System.out.println("Enter Product name: ");
		String productName = scanner.nextLine();
		
		System.out.println("Enter Make and Model: ");
		String makeAndModelName = scanner.nextLine();
		
		System.out.println("Enter Number of items: ");
		int numberOfItems = scanner.nextInt();
		
		System.out.println("Enter Price: ");
		double itemPrice = scanner.nextDouble();

		// Adding to the list
		insertData(new StockDao(PRODUCTID, productName, makeAndModelName, numberOfItems, itemPrice));
		PRODUCTID = PRODUCTID + 1;
		displayMenu();
		getUserInput();
	}

	/**
	 * Get the remaining inventory item details.
	 */
	private void displayProductOnPuchase() {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SELECT);
			ResultSet res = psmt.executeQuery();
			while (res.next()) {
				int productId = res.getInt("productId");
				String productName = res.getString("productName");
				String makeAndModelName = res.getString("makeAndModelName");

				System.out.println(productId + " | " + productName + " | " + makeAndModelName + "\n");
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Purchase an item.
	 */
	private void makePurchase() {
		displayProductOnPuchase();
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SELECT);
			ResultSet res = psmt.executeQuery();
			System.out.println("Select Item by giving product id.");
			int itemSelected = scanner.nextInt();
			while (res.next()) {
				int productId = res.getInt("productId");
				String productName = res.getString("productName");
				String makeAndModelName = res.getString("makeAndModelName");
				int numberOfItems = res.getInt("numberOfItems");
				double itemPrice = res.getDouble("itemPrice");

				if (productId == itemSelected) {
					System.out.println(productId + " | " + productName + " item is selected.");
					System.out.println("Enter the number of items");
					int requiredItems = scanner.nextInt();
					if (requiredItems <= numberOfItems && requiredItems != 0) {
						double totalPrice = requiredItems * itemPrice;
						generateBill(productId, productName, makeAndModelName, requiredItems, itemPrice, totalPrice);
						int remainingItems = (numberOfItems - requiredItems);
						updateInventory(itemSelected, remainingItems);
					} else {
						System.out.println("Inventory: Out of stock.");
					}
				}

			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		displayMenu();
		getUserInput();
	}

	/**
	 * Generate the bill for purchased item.
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
		System.out.println("Product Id | Product Name | Make and Model | Number of Items | Item price | Total Price");
		System.out.println(pid + " | " + pName + " | " + mam + " | " + noi + " | " + pr + " | " + tpr);
	}

	/**
	 * Exit from the program.
	 */
	private void exitFromProgram() {
		System.out.println("Exited from the program...");
		System.exit(0);
	}

	/**
	 * Main method for InventoryDb class.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		InventoryDb idb = new InventoryDb();
		idb.createDatabase();

		idb.displayMenu();
		idb.getUserInput();

	}

}
