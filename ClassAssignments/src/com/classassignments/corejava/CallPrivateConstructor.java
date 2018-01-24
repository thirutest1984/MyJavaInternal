package com.classassignments.corejava;

/**
 * DAY: 4 1. Create a private constructor, and invoke it from another
 * constructor of same class?
 * 
 * @author M1035775 Kotra Thirumala
 *
 */

public class CallPrivateConstructor {

	private CallPrivateConstructor() { // private constructor
		System.out.println("Private constructor.");
	}

	public CallPrivateConstructor(String str) {
		this(); // Calling the private constructor inside a constructor
		System.out.println("Called private constructor here.");
	}

	public static void main(String[] args) {

		new CallPrivateConstructor("string"); // Calling the Constructor

	}

}
