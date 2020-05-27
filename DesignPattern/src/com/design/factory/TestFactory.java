package com.design.factory;

import com.design.factory.object.ComputerFactory;

public class TestFactory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Computer c1 = ComputerFactory.getFactoryClass(ComputerType.PC, "zero", "102", "red", true);
		System.out.println("Pc :" + c1);
		Computer c2 = ComputerFactory.getFactoryClass(ComputerType.SERVER, "one", "120", "bleack", false);
		System.out.println("Server :" + c2);
	}

}
