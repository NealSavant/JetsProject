package com.skilldistillery.jets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JetsApp {
	// f i e l d s
	private AirField airfield;
	private JetImpl placeJets;

	public static void main(String[] args) {
		JetsApp ja = new JetsApp();
		ja.run();
	}

	public void run() {
		System.out.println("Start");
		airfield = new AirField(); //create airfield	
		airfield.addStarters();//populate airfield

		
	}
	
}
