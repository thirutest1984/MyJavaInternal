package com.java201.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.java201.order.OrderProcessingSystem;

public class CustomerDaoImpl implements CustomerDao {

	Connection connection = null;
	Scanner scanner = new Scanner(System.in);

	public void getCustomer() {
		System.out.println("Enter the Customer ID: ");
		int customerId = scanner.nextInt();

		scanner.nextLine();

		System.out.println("Enter the Customer name: ");
		String customerName = scanner.nextLine();

		System.out.println("Enter the Customer address: ");
		String customerAddress = scanner.nextLine();

		System.out.println("Enter the Customer phone number: ");
		int customerPhone = scanner.nextInt();

		addCustomer(new Customer(customerId, customerName, customerAddress, customerPhone));
	}

	public void updateCustomer() {
		System.out.println("Enter the Customer ID: ");
		int customerId = scanner.nextInt();

		scanner.nextLine();

		System.out.println("Enter the Customer name: ");
		String customerName = scanner.nextLine();

		System.out.println("Enter the Customer address: ");
		String customerAddress = scanner.nextLine();

		System.out.println("Enter the Customer phone number: ");
		int customerPhone = scanner.nextInt();

		editCustomer(new Customer(customerId, customerName, customerAddress, customerPhone));
	}

	@Override
	public void addCustomer(Customer customer) {
		connection = establishDbConnection.getConnection();
		// System.out.println("database connection established.");
		try {
			PreparedStatement pStmt = connection.prepareStatement("insert into customer values (?,?,?,?)");
			pStmt.setInt(1, customer.getCustomerId());
			pStmt.setString(2, customer.getCustomerName());
			pStmt.setString(3, customer.getAddress());
			pStmt.setInt(4, customer.getPhone());
			pStmt.executeUpdate();
			System.out.println("Customer details are inserted into the table successfully.");
			pStmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void editCustomer(Customer customer) {
		connection = establishDbConnection.getConnection();

		try {
			PreparedStatement pStmt = connection
					.prepareStatement("update customer set customerName=?, address=?, phone=? where customerId=?");
			pStmt.setString(1, customer.getCustomerName());
			pStmt.setString(2, customer.getAddress());
			pStmt.setInt(3, customer.getPhone());
			pStmt.setInt(4, customer.getCustomerId());
			pStmt.executeUpdate();
			System.out.println("Customer details are updated successfully.");
			pStmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCustomer() {
		connection = establishDbConnection.getConnection();
		System.out.println("Enter the Customer ID: ");
		int customerId = scanner.nextInt();

		try {
			Statement stmt = connection.createStatement();
			String sql = "delete from customer where customerId= " + customerId;
			stmt.executeUpdate(sql);
			System.out.println("Customer details are deleted successfully.");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void goBackToMainMenu() {
		System.out.println("Exited from the customer module.");
		OrderProcessingSystem opsm = new OrderProcessingSystem();
		opsm.getUserInput();
	}

	public void customerInputOptions() {
		int entryOption;
		do {
		System.out.println("Customer module menu options are: ");
		System.out.println("1 - Add a Customer" + "\n" + "2 - Edit a Customer" + "\n" + "3 - Delete a Customer"+ "\n" + "4 - Exit from Customer module");
		System.out.println("Enter your option: ");
		entryOption = scanner.nextInt();
		scanner.nextLine();
		switch (entryOption) {
		case 1: // add customer
			getCustomer();
			break;
		case 2: // update customer
			updateCustomer();
			break;
		case 3: // delete customer
			deleteCustomer();
			break;
		case 4: // exit from customer module
			goBackToMainMenu();
			break;			
		default:
			System.out.println("Please enter a valid option.");
			break;
		}
		} while(entryOption != 4);
	}
}
