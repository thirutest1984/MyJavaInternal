package com.classassignments.corejava;

/**
 * DAY: 2 #3. Use method recursion to print all fibonacci numbers less than 500
 * 
 * @author M1035775 Kotra Thirumala
 *
 */

public class FibonacciNumbersRecursion {

	// Class variables
	static int num1 = 0, num2 = 1;
	static int count = 0;
	int sum = 0;

	// Recursion method
	public void fibonacciRecursion(int count) {
		sum = num1 + num2;
		num1 = num2;
		num2 = sum;
		if (sum <= 500) {
			System.out.print(" " + sum);
		} else {
			return;
		}
		fibonacciRecursion(count + 1); // Calling the same method: Recursion

	}

	public static void main(String[] args) {

		FibonacciNumbersRecursion fnr = new FibonacciNumbersRecursion();
		System.out.print("Fibonacci numbers below 500 are: " + num1 + " " + num2);
		fnr.fibonacciRecursion(count);

	}

}
