package com.skilldistillery.jets;

public class FighterJet extends Jet implements CombatReady {

	public FighterJet(String model, double speed, int range, long price, String type) {
		super(model, speed, range, price, type);
	}

	@Override
	public void fight() {
		
	}
}
