package com.structral.bridge;

public class Pentagon extends Shape {

	public Pentagon(Colors c) {
		super(c);
	}

	@Override
	public void appyColor() {

		System.out.println("Pentagon Color");
		color.applyColor();
	}

}
