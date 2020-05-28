package com.structral.bridge;

public class Triangle extends Shape {

	
	public Triangle(Colors c) {
		super(c);
	}

	@Override
	public void appyColor() {

		System.out.println("Trangle Class");
		color.applyColor();
	}

	
	
	}
