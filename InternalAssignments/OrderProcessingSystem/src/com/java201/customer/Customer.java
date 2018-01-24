package com.java201.customer;

public class Customer {
	private int customerId;
	private String customerName;
	private String address;
	private int phone;

	/**
	 * @param customerId
	 * @param customerName
	 * @param address
	 * @param phone
	 */
	public Customer(int customerId, String customerName, String address, int phone) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.address = address;
		this.phone = phone;
	}

	/**
	 * @return the customerId
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId
	 *            the customerId to set
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName
	 *            the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the phone
	 */
	public int getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(int phone) {
		this.phone = phone;
	}

}
