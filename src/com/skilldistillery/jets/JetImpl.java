package com.skilldistillery.jets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JetImpl extends Jet {
	public JetImpl(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
	
public List<Jet> addPlanes(){
		List<Jet> jets = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader("jets.txt"))){
			String line;
			//read file
			while((line = br.readLine()) != null) {
				//comma separated data file
				String[] jetAdd = line.split(", ");
				//populate string
				String jetModel = jetAdd[0];
				double jetSpeed = Double.parseDouble(jetAdd[1]);
				int jetRange = Integer.parseInt(jetAdd[2]);
				long jetPrice = Long.parseLong(jetAdd[3]);
				//populate jet object
				Jet j = new Jet(jetModel, jetSpeed, jetRange, jetPrice);
				jets.add(j);
			}
		} catch(IOException e) {
			System.err.println(e);
		}
		
		
		return jets;
	}

}
