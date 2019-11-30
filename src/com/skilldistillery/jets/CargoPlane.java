package com.skilldistillery.jets;

public class CargoPlane extends Jet implements CargoCarrier {
	public CargoPlane(String model, double speed, int range, long price, String type) {
		super(model, speed, range, price, type);
		
	}
	
	@Override
	public void loadCargo() {
		
	}
}
