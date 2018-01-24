package com.classassignments.corejava;

/**
 * DAY: 1 4. Multiply two matrices, and print the result as array
 * 
 * @author M1035775 Kotra Thirumala
 *
 */

public class MultiplyMatrice {
	public static void main(String[] args) {

		int firstMatrix[][] = { { 1, 2 }, { 2, 3 } }; // First matrix
		int secondMatrix[][] = { { 5, 6 }, { 4, 7 } }; // second matrix
		int resultMatrix[][] = new int[2][2];

		// Display the first matrix
		System.out.println("First matrix is: ");
		for (int i = 0; i < firstMatrix.length; i++) {
			for (int j = 0; j < firstMatrix[0].length; j++)
				System.out.print(firstMatrix[i][j] + " ");
			System.out.println();
		}

		// Display the second matrix
		System.out.println("Second matrix is: ");
		for (int i = 0; i < secondMatrix.length; i++) {
			for (int j = 0; j < secondMatrix[0].length; j++)
				System.out.print(secondMatrix[i][j] + " ");
			System.out.println();
		}

		// Matrices multiplication logic
		for (int i = 0; i < resultMatrix.length; i++) {
			for (int j = 0; j < resultMatrix[0].length; j++) {
				for (int k = 0; k < resultMatrix.length; k++) {
					resultMatrix[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
				}
			}
		}

		// Display the matrix multiplication result
		System.out.println("Matrix multiplication result is: ");
		for (int i = 0; i < resultMatrix.length; i++) {
			for (int j = 0; j < resultMatrix[0].length; j++) {
				System.out.print(resultMatrix[i][j] + " ");
			}
			System.out.println();
		}

	}

}
