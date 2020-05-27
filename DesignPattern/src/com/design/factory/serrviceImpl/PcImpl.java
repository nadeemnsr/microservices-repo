package com.design.factory.serrviceImpl;

import com.design.factory.Computer;

public class PcImpl implements Computer {

	String hdd;
	String ram;
	String color;
	boolean isEnabled;

	private PcImpl() {
	}

	public PcImpl(String hdd, String ram, String color, boolean isEnabled) {
		super();
		this.hdd = hdd;
		this.ram = ram;
		this.color = color;
		this.isEnabled = isEnabled;
	}

	@Override
	public String hdd() {
		// TODO Auto-generated method stub
		return hdd;
	}

	@Override
	public String ram() {
		// TODO Auto-generated method stub
		return ram;
	}

	@Override
	public String color() {
		// TODO Auto-generated method stub
		return color;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		return "PcImpl [hdd=" + hdd + ", ram=" + ram + ", color=" + color + ", isEnabled=" + isEnabled + "]";
	}
	

}
