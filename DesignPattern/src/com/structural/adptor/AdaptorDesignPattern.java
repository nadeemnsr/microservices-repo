package com.structural.adptor;

public class AdaptorDesignPattern {

	public static void main(String[] args) {

		testClassAdaptor();
		testObjectAdaptor();
	}

	private static void testObjectAdaptor() {

		SocketAdaptor socketAdaptor = new SocketObjectAdaptorImpl();

		Volt v3 = getVolt(socketAdaptor, 3);
		Volt v20 = getVolt(socketAdaptor, 12);
		Volt v120 = getVolt(socketAdaptor, 120);
		System.out.println("v3 volts using Class "+v3.getVolt());
		System.out.println("v20 volts using Class "+v20.getVolt());
		System.out.println("v120 volts using Class " +v120.getVolt());
	}

	private static void testClassAdaptor() {

		SocketAdaptor socketAdaptor = new SocketObjectAdaptorImpl();

		Volt v3 = getVolt(socketAdaptor, 3);
		Volt v20 = getVolt(socketAdaptor, 20);
		Volt v120 = getVolt(socketAdaptor, 120);
		System.out.println("v3 volts using Object "+v3.getVolt());
		System.out.println("v20 volts using Object "+v20.getVolt());
		System.out.println("v120 volts using Object "+v120.getVolt());
	}

	private static Volt getVolt(SocketAdaptor sockAdapter, int i) {
		switch (i) {
		case 3:
			return sockAdapter.get3Volt();
		case 12:
			return sockAdapter.get12Volt();
		case 120:
			return sockAdapter.get120Volt();
		default:
			return sockAdapter.get120Volt();
		}
	}
}
