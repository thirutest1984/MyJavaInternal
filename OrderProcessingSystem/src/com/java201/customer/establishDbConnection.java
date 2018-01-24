package com.java201.customer;

import java.sql.Connection;
import java.sql.DriverManager;

public class establishDbConnection {

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
	static final String DB_URL = "jdbc:mysql://localhost:3306/ORDERPROCESS";

	/**
	 * Database credentials
	 */
	static final String USERNAME = "root";
	static final String PASSWORD = "root";

	/**
	 * Establish Database connection.
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		try {
			Class.forName(JDBC_DRIVER);
			return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
