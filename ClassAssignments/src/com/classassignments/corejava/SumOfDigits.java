package com.classassignments.corejava;

/**
 * DAY: 2 #2. Write a method which accepts int as parameter, and returns sum of
 * all individual digits For eg. 853 output should be 16 i..e 3+5+8
 * 
 * @author M1035775 Kotra Thirumala
 *
 */

public class SumOfDigits {
	int digit, sum = 0; // Class variables

	// Addition of digits in a given number.
	public int sumDigitsInNumber(int num) { // Method declaration.
		while (num > 0) {
			digit = num % 10;
			sum = sum + digit;
			num = num / 10;
		}
		return sum; // Return the result
	}

	public static void main(String[] args) {
		SumOfDigits sod = new SumOfDigits(); // Class object
		int result = sod.sumDigitsInNumber(853); // Calling the method sumDigitsInNumber()
		System.out.println("Sum of the digits of the given number is: " + result); // Display the result

	}
}
