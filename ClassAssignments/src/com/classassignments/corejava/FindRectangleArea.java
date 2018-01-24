package com.classassignments.corejava;

/**
 * DAY: 3 #2. Create a Rectangle class, which has width and height. Have a
 * method in main class, which accepts two Rectangle objects, return an object
 * which has maximum area?
 * 
 * @author M1035775
 *
 */

class Rectangle {

	double width, height;

	public Rectangle(double w, double h) { // Constructor
		width = w;
		height = h;
	}

}

public class FindRectangleArea {

	public Rectangle findMaxArea(Rectangle r1, Rectangle r2) {
		double areaR1 = calculateArea(r1.width, r1.height);
		double areaR2 = calculateArea(r2.width, r2.height);

		System.out.println("Area of Rectangle1: " + areaR1);
		System.out.println("Area of Rectangle2: " + areaR2);

		if (areaR1 > areaR2) { // compare the rectangle areas
			return r1;
		} else {
			return r2;
		}
	}

	public double calculateArea(double width, double height) { // Calculate the rectangle area
		double area = width * height;
		return area;
	}

	public static void main(String[] args) {
		FindRectangleArea f = new FindRectangleArea();
		// find the max area rectangle
		Rectangle getMaxObject = f.findMaxArea(new Rectangle(2, 4), new Rectangle(30, 40));
		System.out.println(
				"The maximum area Rectangle is: " + "width: " + getMaxObject.width + " height: " + getMaxObject.height);

	}

}
