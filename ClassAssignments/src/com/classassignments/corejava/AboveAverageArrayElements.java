package com.classassignments.corejava;

/**
 * DAY: 1 3. Display all elements in an array, which are greater than average
 * value
 * 
 * @author M1035775 Kotra Thirumala
 *
 */

public class AboveAverageArrayElements {
	public static void main(String[] args) {

		int sourceArr[] = new int[5]; // Original array
		int sum = 0;

		// Declare the array elements
		sourceArr[0] = 34;
		sourceArr[1] = 82;
		sourceArr[2] = 92;
		sourceArr[3] = 13;
		sourceArr[4] = 89;

		// Display the Original array elements and calculate the sum of the array
		// elements
		System.out.print("Original array elements are: ");
		for (int i = 0; i < sourceArr.length; i++) {
			System.out.print(sourceArr[i] + " ");
			sum = sum + sourceArr[i];
		}
		System.out.println();
		// Calculate the average of the array elements
		float avg = sum / sourceArr.length;
		System.out.println("Average of the Original array elements is: " + avg); // Display the average value
		System.out.print("Array elements which are greater than the average are: ");
		for (int i = 0; i < sourceArr.length; i++) { // Compare the array elements with average value
			if (sourceArr[i] > avg) {
				System.out.print(sourceArr[i] + " ");
			}
		}

	}

}
