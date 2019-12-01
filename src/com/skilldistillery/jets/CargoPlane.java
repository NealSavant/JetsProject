package com.skilldistillery.jets;

public class CargoPlane extends Jet implements CargoCarrier {
	private boolean cargoLoaded;

	public CargoPlane(String model, double speed, int range, long price, String type) {
		super(model, speed, range, price, type);
		this.cargoLoaded = false;

	}

	@Override
	public String toString() {
		return "Cargo Plane [Model= " + getModel() + ", Speed= " + getSpeed() + ", Range= " + getRange() + ", Price= "
				+ getPrice() + "]";
	}

	@Override
	public void loadCargo() {
		this.cargoLoaded = true;
		System.out.println("Cargo loaded onto " + this.getModel());
	}

	public boolean getCargoStatus() {
		return cargoLoaded;
	}

}
