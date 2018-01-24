package com.java201.order;

import java.util.Scanner;

import com.java201.customer.CustomerDaoImpl;
import com.java201.product.ProductDaoImpl;
import com.java201.stock.StockdaoImpl;

public class OrderProcessingSystem {

	Scanner scanner = new Scanner(System.in);

	public void exitFromProgram() {
		System.out.println("Exited from the program...");
		System.exit(0);
	}

	public void getUserInput() {
		int option;
		do {
			System.out.println("Order processing system menu options: ");
			System.out.println("1 - Customer" + "\n" + "2 - Product" + "\n" + "3 - Stock" + "\n" + "4 - Order" + "\n"
					+ "5 - exit from the program");
			System.out.println("Please choose your option: ");
			option = scanner.nextInt();
			scanner.nextLine();
			switch (option) {
			case 1: // Customer
				CustomerDaoImpl cImpl = new CustomerDaoImpl();
				cImpl.customerInputOptions();
				break;
			case 2: // Product
				ProductDaoImpl pImpl = new ProductDaoImpl();
				pImpl.productInputOptions();
				break;
			case 3: // Stock
				StockdaoImpl sImpl = new StockdaoImpl();
				sImpl.stockInputOptions();
				break;
			case 4: // Order
				OrderDaoImpl oImpl = new OrderDaoImpl();
				oImpl.orderInputOptions();
				break;
			case 5: // exit from the program
				exitFromProgram();
				break;
			default:
				System.out.println("Please enter a valid option.");
				break;
			}
		} while (option != 5);
	}

	public static void main(String[] args) {

		OrderProcessingSystem ops = new OrderProcessingSystem();
		ops.getUserInput();
	}
}
