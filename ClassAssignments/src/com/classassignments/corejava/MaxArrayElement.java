package com.classassignments.corejava;

/**
 * Day: 2 1. find max element in an array
 * 
 * @author M1035775 Kotra Thirumala
 *
 */

public class MaxArrayElement {
	public static void main(String[] args) {

		int arr[] = { 7, 23, 43, 44, 66, 32 }; // Array declaration
		int max = 0; // Class variable

		for (int i = 0; i < arr.length; i++) { // Logic for find maximum number
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		System.out.println("The maximum element in the given array is: " + max);

	}

}
