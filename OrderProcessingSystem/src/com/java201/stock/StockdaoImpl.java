package com.java201.stock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.java201.customer.establishDbConnection;
import com.java201.order.OrderProcessingSystem;

public class StockdaoImpl implements StockDao {

	Connection connection = null;
	Scanner scanner = new Scanner(System.in);

	public void getStock() {
		System.out.println("Enter the product ID: ");
		int productId = scanner.nextInt();

		scanner.nextLine();

		System.out.println("Enter the product quantity: ");
		int quantity = scanner.nextInt();

		scanner.nextLine();

		System.out.println("Enter the shop no: ");
		int shopNo = scanner.nextInt();

		addStock(new Stock(productId, quantity, shopNo));
	}

	public void updateStock() {
		System.out.println("Enter the product ID: ");
		int productId = scanner.nextInt();

		modifyStock(productId);

	}

	public void retrieveStockItem() {
		System.out.println("Enter the product ID: ");
		int productId = scanner.nextInt();

		selectStockItem(productId);
	}

	@Override
	public void addStock(Stock stock) {

		connection = establishDbConnection.getConnection();
		System.out.println("database connection established.");
		try {
			PreparedStatement pStmt = connection.prepareStatement("insert into stock values (?,?,?)");
			pStmt.setInt(1, stock.getProductId());
			pStmt.setInt(2, stock.getQuantity());
			pStmt.setInt(3, stock.getShopNo());
			pStmt.executeUpdate();
			System.out.println("Stock details are inserted into the table successfully.");
			pStmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modifyStock(int productId) {

		System.out.println("Enter the product quantity: ");
		int quantity = scanner.nextInt();

		scanner.nextLine();

		System.out.println("Enter the shop no: ");
		int shopNo = scanner.nextInt();

		connection = establishDbConnection.getConnection();
		System.out.println("database connection established.");

		try {
			String sql = "update stock set quantity = ?, shopNo = ? where productId = ?";
			PreparedStatement pStmt = connection.prepareStatement(sql);
			pStmt.setInt(1, quantity);
			pStmt.setInt(2, shopNo);
			pStmt.setInt(3, productId);
			pStmt.executeUpdate();
			System.out.println("Stock details are updated into the table successfully.");
			pStmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void selectStockItem(int productId) {
		connection = establishDbConnection.getConnection();

		try {
			String sql = "select quantity, shopNo from stock where productId= " + productId;
			PreparedStatement pStmt = connection.prepareStatement(sql);
			ResultSet res = pStmt.executeQuery();
			while (res.next()) {
				int quantity = res.getInt("quantity");
				int shopNo = res.getInt("shopNo");

				System.out.println(productId + " | " + quantity + " | " + shopNo + "\n");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void goBackToMainMenu() {
		System.out.println("Exited from the stock module.");
		OrderProcessingSystem opsm = new OrderProcessingSystem();
		opsm.getUserInput();
	}

	public void stockInputOptions() {
		int entryOption;
		do {
			System.out.println("Stock module menu options are: ");
			System.out.println("1 - Add Stock" + "\n" + "2 - Modify a Stock" + "\n" + "3 - Select a Stock" + "\n"
					+ "4 - Exit from Stock module");
			System.out.println("Enter your option: ");
			entryOption = scanner.nextInt();
			scanner.nextLine();
			switch (entryOption) {
			case 1: // add stock
				getStock();
				break;
			case 2: // update stock
				updateStock();
				break;
			case 3: // retrieve stock
				retrieveStockItem();
				break;
			case 4: // exit from stock
				goBackToMainMenu();
				break;
			default:
				System.out.println("Please enter a valid option.");
				break;
			}
		} while (entryOption != 4);
	}
}
