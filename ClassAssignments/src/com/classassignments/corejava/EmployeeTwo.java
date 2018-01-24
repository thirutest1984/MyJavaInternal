package com.classassignments.corejava;

/**
 * DAY: 4 #2. Create a class Employee, which has employee name, salary,
 * department name Create two dimensional array of Employee objects, each row
 * has Employee object of specific department Display Employee details of
 * employee earning max salary in each department
 * 
 * @author M1035775
 *
 */

class EmployeeDept { // Employee class
	private String eName;
	private double eSalary;
	private String deptName;

	public EmployeeDept(String eName, double eSalary, String dName) { // Constructor
		this.eName = eName;
		this.eSalary = eSalary;
		this.deptName = dName;
	}

	public String geteName() {
		return eName;
	}

	public double geteSalary() {
		return eSalary;
	}

	public String getDeptName() {
		return deptName;
	}

}

public class EmployeeTwo {
	double currSalary = 0, maxSalary = 0; // Variables
	String currDName, maxDName, maxEName;

	public enum dept {
		HRD, ADMIN
	} // department names as enum constants

	private void maxSalary(EmployeeDept[][] emp, String dept) { // logic for getting the maximum salary employee
		for (int i = 0; i < emp.length; i++) {
			for (int j = 0; j < emp[i].length; j++) {
				if ((emp[i][j].getDeptName().equals(dept)) && (emp[i][j].geteSalary() > maxSalary)) {
					maxSalary = emp[i][j].geteSalary();
					maxDName = emp[i][j].getDeptName();
					maxEName = emp[i][j].geteName();
				}
			}
		}
		System.out.println("Employee details of earning max salary in : " + maxDName);
		System.out.println(maxEName + " | " + maxSalary + " | " + maxDName);
		maxSalary = 0; // making maxSalary=0 after iteration
	}

	public static void main(String[] args) {
		EmployeeDept emp1 = new EmployeeDept("John", 10000, "ADMIN");
		EmployeeDept emp2 = new EmployeeDept("Peter", 15000, "HRD");
		EmployeeDept emp3 = new EmployeeDept("Benjimen", 25000, "ADMIN");
		EmployeeDept emp4 = new EmployeeDept("William", 20000, "HRD");
		EmployeeDept emp5 = new EmployeeDept("Frank", 25000, "HRD");


		EmployeeDept[][] employee = { { emp1 }, { emp2 }, { emp3 }, { emp4 }, { emp5 } }; // Employee objects 2D array
		EmployeeTwo empTwo = new EmployeeTwo();

		for (dept d : dept.values()) { // iterate departments
			empTwo.maxSalary(employee, d.toString());
		}

	}

}