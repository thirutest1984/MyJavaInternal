package com.classassignments.corejava;

/** DAY: 1
 * 2. Check if given number is odd or even using conditional or ternary operator
 * @author M1035775
 *
 */

public class CheckEvenOrOdd {
	
	public static void main(String[] args) {

		int num = 15; // Given number

		// Using if conditional statement
		System.out.println("Using conditional statement.");
		if (num % 2 == 0) {
			System.out.println(num + " is an even number.");
		} else {
			System.out.println(num + " is an odd number.");
		}

		// Using ternary operator
		System.out.println("Using ternary operator.");
		String result = (num % 2 == 0) ? " is an even number." : " is an odd number.";
		System.out.println(num + result);

	}

}
