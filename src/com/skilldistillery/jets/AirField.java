package com.skilldistillery.jets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AirField {

	private List<Jet> jets;
	private List<CargoPlane> planes;
	
	public AirField() {
		jets = new ArrayList<>();

	}

	public void addStarters() {
		jets.addAll(starterPlanes());

	}

	public void listJets() {
		for (Jet jet : jets) {
			System.out.println(jet.toString());
		}
	}

	public List<CargoPlane> getCargoPlanes() {
		planes = new ArrayList<>();
		for(int i = 0; i < jets.size(); i++) {
			if(jets.get(i).getType().equals("Carrier")) {
				planes.add((CargoPlane) jets.get(i));
			}
		}
		return planes;
	}

	public List<Jet> getJets() {
		return this.jets;
	}

	// starter planes are added at start of program
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
				} else if (jetType.equals("Fighter")) {
					Jet j = new FighterJet(jetModel, jetSpeed, jetRange, jetPrice, jetType);
					jets.add(j);
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
