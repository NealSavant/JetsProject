package com.skilldistillery.jets;

public class CargoPlane extends Jet implements CargoCarrier {
	public CargoPlane(String model, double speed, int range, long price, String type) {
		super(model, speed, range, price, type);
		
	}
	
	@Override
	public String toString() {
		return "Cargo Plane [Model= " + getModel() + ", Speed= " + getSpeed() + ", Range= " + getRange()
				+ ", Price= " + getPrice();
	}


	@Override
	public void loadCargo() {
		
	}
}
