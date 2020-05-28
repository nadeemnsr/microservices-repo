package com.structural.adptor;

public class SocketClassAdaptorImpl extends Socket implements SocketAdaptor {

	@Override
	public Volt get120Volt() {
		return getVolt();
	}

	@Override
	public Volt get3Volt() {
		Volt v = getVolt();
		return convertVolt(v, 10);
	}

	private Volt convertVolt(Volt v, int i) {
		return new Volt(v.getVolt() / i);
	}

	@Override
	public Volt get12Volt() {
		Volt v = getVolt();
		return convertVolt(v, 10);
	}

}
