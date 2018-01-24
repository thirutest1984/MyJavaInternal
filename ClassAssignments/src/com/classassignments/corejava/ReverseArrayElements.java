package com.classassignments.corejava;

/** DAY: 1
 * 1. Reverse elements in an array, and print
 * For eg, for a given array 34,82,92,13,89 output should be 89,13,92,82,34
 * @author M1035775 Kotra Thirumala
 *
 */

public class ReverseArrayElements {
	public static void main(String[] args) {

		int sourceArr[] = new int[5]; // Original array
		int destArr[] = new int[5]; // Revered array

		// Declare the array elements
		sourceArr[0] = 34;
		sourceArr[1] = 82;
		sourceArr[2] = 92;
		sourceArr[3] = 13;
		sourceArr[4] = 89;

		// Display the Original array elements
		System.out.print("Original array is: ");
		for (int i = 0; i < sourceArr.length; i++) {
			System.out.print(sourceArr[i] + " ");
		}

		System.out.println(); // Just for a new line

		// Logic for reverse the array elements
		for (int j = sourceArr.length - 1; j >= 0; j--) {
			destArr[j] = sourceArr[sourceArr.length - 1 - j];
		}

		// Display the reversed array elements
		System.out.print("Reversed array is: ");
		for (int i = 0; i < sourceArr.length; i++) {
			System.out.print(destArr[i] + " ");
		}

	}

}

