package com.java201.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.java201.customer.establishDbConnection;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

public class OrderDaoImpl implements OrderDao {

	Connection connection = null;
	Scanner scanner = new Scanner(System.in);

	public void getOrderdetails() throws SQLException {
		System.out.println("Enter the Order Id: ");
		int orderId = scanner.nextInt();

		System.out.println("Enter the Customer ID: ");
		int customerId = scanner.nextInt();

		scanner.nextLine();

		System.out.println("Enter the Customer name: ");
		String customerName = scanner.nextLine();

		System.out.println("Enter the product ID: ");
		int productId = scanner.nextInt();

		System.out.println("Enter the Amount: ");
		float amount = scanner.nextFloat();
		scanner.nextLine();

		System.out.println("Order date is: ");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String orderDate = dtf.format(now);
		System.out.println(orderDate);

		insertOrderDetails(new Order(orderId, customerId, customerName, productId, amount, orderDate));
	}

	public void insertOrderDetails(Order order) throws SQLException {
		connection = establishDbConnection.getConnection();
		try {
			String insertSql = "insert into ordertable(orderId,customerId,customerName,productId,amount,orderDate) values (?,?,?,?,?,?)";
			PreparedStatement pStmtOrder = connection.prepareStatement(insertSql);
			pStmtOrder.setInt(1, order.getOrderId());
			pStmtOrder.setInt(2, order.getCustomerId());
			pStmtOrder.setString(3, order.getCustomerName());
			pStmtOrder.setInt(4, order.getProductId());
			pStmtOrder.setFloat(5, order.getAmount());
			pStmtOrder.setString(6, order.getOrderDate());
			pStmtOrder.executeUpdate();
			System.out.println("Order created successfully.");
			pStmtOrder.close();
		} catch (MySQLIntegrityConstraintViolationException e) {
			System.out.println("Order failed!. Please create the order with available products.");
			System.exit(0);
		}
	}

	public void updateStockAfterOrder(int productId, int quantity) {
		connection = establishDbConnection.getConnection();

		try {
			String sql = "update stock set quantity = ? where productId = ?";
			PreparedStatement pStmt = connection.prepareStatement(sql);
			pStmt.setInt(1, quantity);
			pStmt.setInt(2, productId);
			pStmt.executeUpdate();
			System.out.println("Stock details are updated into the table successfully.");
			pStmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void retrieveOrderDetails() {
		connection = establishDbConnection.getConnection();

		System.out.println("Enter the orderId for the order details: ");
		int retrieveOrder = scanner.nextInt();

		try {
			String sql = "select orderId, customerId, customerName, productId, amount, orderdate from ordertable where orderId= "
					+ retrieveOrder;
			PreparedStatement pStmt = connection.prepareStatement(sql);
			ResultSet res = pStmt.executeQuery();
			while (res.next()) {
				int orderId = res.getInt("orderId");
				int customerId = res.getInt("customerId");
				String customername = res.getString("customerName");
				int productId = res.getInt("productId");
				float amount = res.getFloat("amount");
				String orderdate = res.getString("orderdate");
				System.out.println("***************** Order information details **************************");
				System.out.println("OrderId " + " | " + " CustomerId " + " | " + " Customer Name " + " | "
						+ " Product Id " + " | " + " Amount " + " | " + " Order date " + " \n ");
				System.out.println(orderId + " | " + customerId + " | " + customername + " | " + productId + " | "
						+ amount + " | " + orderdate + "\n");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateOrder() {
		System.out.println("Enter the order ID: ");
		int orderId = scanner.nextInt();

		editOrder(orderId);

	}

	@Override
	public void createOrder() {
		connection = establishDbConnection.getConnection();

		try {
			PreparedStatement pStmt = connection.prepareStatement("select * from stock");
			ResultSet res = pStmt.executeQuery();

			System.out.println("Enter the product Id for order: ");
			int productIdSelected = scanner.nextInt();

			while (res.next()) {
				int productIdForUpdate = res.getInt("productId");
				int quantity = res.getInt("quantity");
				int shopNo = res.getInt("shopNo");

				if (productIdForUpdate == productIdSelected) {
					System.out.println("Enter the required quantity of items: ");
					int requiredItems = scanner.nextInt();
					if (requiredItems <= quantity && requiredItems != 0) {
						getOrderdetails();
						int remainingItems = (quantity - requiredItems);
						updateStockAfterOrder(productIdSelected, remainingItems);
						retrieveOrderDetails();

					} else {
						System.out.println("Product: Out of stock.");
					}
				} else {
					System.out.println("Invalid product. Please see the product table for a available product.");
				}

			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public void editOrder(int orderId) {

		System.out.println("Enter the Customer ID: ");
		int customerId = scanner.nextInt();

		scanner.nextLine();

		System.out.println("Enter the Customer name: ");
		String customerName = scanner.nextLine();

		System.out.println("Enter the product ID: ");
		int productId = scanner.nextInt();

		System.out.println("Enter the Amount: ");
		float amount = scanner.nextFloat();
		scanner.nextLine();

		System.out.println("Order date is: ");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String orderDate = dtf.format(now);
		System.out.println(orderDate);

		connection = establishDbConnection.getConnection();
		System.out.println("database connection established.");

		try {
			String sql = "update ordertable set customerId = ?, customerName = ?, productId = ?, amount = ?, orderDate = ? where orderId = ?";
			PreparedStatement pStmt = connection.prepareStatement(sql);
			pStmt.setInt(1, customerId);
			pStmt.setString(2, customerName);
			pStmt.setInt(3, productId);
			pStmt.setFloat(4, amount);
			pStmt.setString(5, orderDate);
			pStmt.setInt(6, orderId);
			pStmt.executeUpdate();
			System.out.println("Order details are updated successfully.");
			pStmt.close();
			retrieveOrderDetails();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void orderInputOptions() {
		int entryOption;
		do {
			System.out.println("Order module menu options are: ");
			System.out.println("1 - Create an Order" + "\n" + "2 - Modify an Order" + "\n" + "3 - Exit from Order");
			System.out.println("Enter your option: ");
			entryOption = scanner.nextInt();
			scanner.nextLine();
			switch (entryOption) {
			case 1: // create an order
				createOrder();
				break;
			case 2: // update order
				updateOrder();
				break;
			default:
				System.out.println("Please enter a valid option.");
				break;
			}
		} while (entryOption != 3);
	}
}
