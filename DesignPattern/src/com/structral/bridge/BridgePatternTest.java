package com.structral.bridge;

public class BridgePatternTest {

	public static void main(String[] args) {
		Shape tri = new Triangle(new RedColor());
		tri.appyColor();
		Shape pen = new Triangle(new RedColor());
		pen.appyColor();
		Shape tri1 = new Pentagon(new GreenColor());
		tri1.appyColor();
		Shape pen1 = new Pentagon(new GreenColor());
		pen1.appyColor();
	//	shape.
	}

}
