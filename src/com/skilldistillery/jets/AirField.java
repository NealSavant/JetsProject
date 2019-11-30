package com.skilldistillery.jets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AirField {
	
	private List<Jet> jets;
	
	public AirField() {
		jets = new ArrayList<>();
		
	}
	
	public void addStarters(){
		try{
			jets.addAll(starterPlanes());
		}catch(NullPointerException e) {
			e.printStackTrace();
		}

	}
	
	
	//starter planes are added at start of program
	public List<Jet> starterPlanes() {
		List<Jet> jets = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("jets"))) {
			String line;
			br.readLine();// eat first line
			System.out.println("Reading file");
			while ((line = br.readLine()) != null) {

				// comma separated data file
				String[] jetAdd = line.split(", ");

				// populate string
				String jetModel = jetAdd[0];
				double jetSpeed = Double.parseDouble(jetAdd[1]);
				int jetRange = Integer.parseInt(jetAdd[2]);
				long jetPrice = new Long(jetAdd[3]);
				String jetType = jetAdd[4];
				// populate jet object
				if (jetType.equals("Carrier")) {
					Jet j = new CargoPlane(jetModel, jetSpeed, jetRange, jetPrice, jetType);
					jets.add(j);
					System.out.println(j.toString());
				} else if (jetType.equals("Fighter")) {
					Jet j = new FighterJet(jetModel, jetSpeed, jetRange, jetPrice, jetType);
					jets.add(j);
					System.out.println(j.toString());
				}

			}
		} catch (IOException e) {
			System.err.println(e);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		return jets;
	}
}
