package com.design.factory.object;

import com.design.factory.Computer;
import com.design.factory.ComputerType;
import com.design.factory.serrviceImpl.PcImpl;
import com.design.factory.serrviceImpl.Server;

public class ComputerFactory {

	private ComputerFactory() {
	}

	public static Computer getFactoryClass(ComputerType type, String hdd, String ram, String color, boolean isEnabled) {
		switch (type) {

		case PC:
			return new PcImpl(hdd, ram, color, isEnabled);
		case SERVER:
			return new Server(hdd, ram, color, isEnabled);
		default:
			throw new RuntimeException("");
		}
	}

}
