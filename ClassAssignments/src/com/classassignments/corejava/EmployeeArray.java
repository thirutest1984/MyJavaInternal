package com.classassignments.corejava;

/** DAY: 3
 * #1. Create a class Employee, which has employee name, salary 
 * Create array of Employee objects
 * List all employees, whose salary is greater than average salary?
 * 
 * @author M1035775 Kotra Thirumala
 */
import java.util.Scanner;

class Employee {

	String eName;
	long salary;
	Scanner scanner = new Scanner(System.in);


	void addEmpData() { // Inserting data

		System.out.println("Enter the emp name: ");
		eName = scanner.nextLine();

		System.out.println("Enter the emp salary: ");
		salary = scanner.nextLong();
	}

}

public class EmployeeArray {

	public static void main(String[] args) {

		Employee[] empArray = new Employee[3]; // Employee array
		for (int i = 0; i < empArray.length; i++)
			empArray[i] = new Employee(); // allocates memory

		for (int i = 0; i < empArray.length; i++) {
			empArray[i].addEmpData();
		}

		long sum = 0;
		for (int i = 0; i < empArray.length; i++) {
			sum = sum + empArray[i].salary;
		}
		// Calculate the average salary
		float avg = sum / empArray.length;
		System.out.println("Average salary of the Employee is: " + avg); // Display the average value
		System.out.print("Employee details whose salary is greater than average salary: ");
		for (int i = 0; i < empArray.length; i++) { // Compare the array elements with the average salary value
			if (empArray[i].salary > avg) {
				System.out.println(empArray[i].eName + " " + empArray[i].salary);
			}
		}
	}

}
