package com.skilldistillery.jets;

public class Jet {
	private String model;
	private double speed;
	private int range;
	private long price;
	private String type;

	public Jet(String model, double speed, int range, long price, String type) {
	}

	public void fly() {
	}

	
	
	
	
	
	
	
	
	
	
	
//
// G E T T E R S  / S E T T E R S
//
	public double getSpeedInMach() {
		return 0.0;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	};
}
