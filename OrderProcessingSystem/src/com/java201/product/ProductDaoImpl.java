package com.java201.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.java201.customer.CustomerDaoImpl;
import com.java201.customer.establishDbConnection;
import com.java201.order.OrderProcessingSystem;

public class ProductDaoImpl implements ProductDao {

	Connection connection = null;
	Scanner scanner = new Scanner(System.in);

	public void getProduct() {
		System.out.println("Enter the product ID: ");
		int productId = scanner.nextInt();

		scanner.nextLine();

		System.out.println("Enter the product price: ");
		float productPrice = scanner.nextFloat();

		scanner.nextLine();

		System.out.println("Enter the product type: ");
		String productType = scanner.nextLine();

		addProduct(new Product(productId, productPrice, productType));
	}

	public void updateProduct() {
		System.out.println("Enter the product ID: ");
		int productId = scanner.nextInt();

		scanner.nextLine();

		System.out.println("Enter the product price: ");
		float productPrice = scanner.nextFloat();

		scanner.nextLine();

		System.out.println("Enter the product type: ");
		String productType = scanner.nextLine();

		modifyProduct(new Product(productId, productPrice, productType));

	}

	public void retrieveProduct() {
		System.out.println("Enter the product ID: ");
		int productId = scanner.nextInt();

		selectProduct(productId);
	}

	@Override
	public void addProduct(Product product) {

		connection = establishDbConnection.getConnection();
		System.out.println("database connection established.");
		try {
			PreparedStatement pStmt = connection.prepareStatement("insert into product values (?,?,?)");
			pStmt.setInt(1, product.getProductId());
			pStmt.setFloat(2, product.getProductPrice());
			pStmt.setString(3, product.getProductType());
			pStmt.executeUpdate();
			System.out.println("Product details are inserted into the table successfully.");
			pStmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void modifyProduct(Product product) {
		connection = establishDbConnection.getConnection();

		try {
			PreparedStatement pStmt = connection
					.prepareStatement("update product set productPrice=?, productType=? where productId=?");
			pStmt.setFloat(1, product.getProductPrice());
			pStmt.setString(2, product.getProductType());
			pStmt.setInt(3, product.getProductId());
			pStmt.executeUpdate();
			System.out.println("Product details are updated successfully.");
			pStmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void selectProduct(int productId) {
		connection = establishDbConnection.getConnection();

		try {
			String sql = "select productPrice, productType from product where productId= " + productId;
			PreparedStatement pStmt = connection.prepareStatement(sql);
			ResultSet res = pStmt.executeQuery();
			while (res.next()) {
				float prodPrice = res.getFloat("productPrice");
				String prodType = res.getString("productType");

				System.out.println(productId + " | " + prodPrice + " | " + prodType + "\n");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void goBackToMainMenu() {
		System.out.println("Exited from the product module.");
		OrderProcessingSystem opsm = new OrderProcessingSystem();
		opsm.getUserInput();
	}

	public void productInputOptions() {
		int entryOption;
		do {
			System.out.println("Product module menu options are: ");
			System.out.println("1 - Add a Product" + "\n" + "2 - Modify a Product" + "\n" + "3 - Select a Product"
					+ "\n" + "4 - Exit from Product module");
			System.out.println("Enter your option: ");
			entryOption = scanner.nextInt();
			scanner.nextLine();
			switch (entryOption) {
			case 1: // add product
				getProduct();
				break;
			case 2: // update product
				updateProduct();
				break;
			case 3: // retrieve product
				retrieveProduct();
				break;
			case 4: // exit from customer module
				goBackToMainMenu();
				break;
			default:
				System.out.println("Please enter a valid option.");
				break;
			}
		} while (entryOption != 4);
	}
}
