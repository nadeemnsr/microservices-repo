package com.structral.bridge;

public abstract class Shape {

	protected Colors color;

	public Shape(Colors c) {
		this.color = c;
	}
	
	abstract public void appyColor();
}
