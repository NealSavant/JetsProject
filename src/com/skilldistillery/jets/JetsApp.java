package com.skilldistillery.jets;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class JetsApp {
	// f i e l d s
	private AirField airfield;
	private List<Jet> jets;
	public boolean programOn;
	public Scanner userInput;

	// m e t h o d s
	public static void main(String[] args) {
		JetsApp ja = new JetsApp();
		ja.run();
	}

	public void run() {
		System.out.println("Start");
		programOn = true;
		airfield = new AirField(); // create airfield
		airfield.addStarters();// populate airfield
		mainMenu(); // main menu initiated

	}

	public void mainMenu() {

		while (programOn) {
			userInput = new Scanner(System.in);
			System.out.println("--- Main Menu ---");
			System.out.println("Input Number to choose options");
			System.out.println("1. List fleet");
			System.out.println("2. Fly all jets");
			System.out.println("3. View Fastest Jet");
			System.out.println("4. View jet with longest range");
			System.out.println("5. Load all Cargo Jets");
			System.out.println("6. Dogfight!!!");
			System.out.println("7. Add a jet to Fleet");
			System.out.println("8. Remove a jet from Fleet");
			System.out.println("9. Quit");
			int choice = userInput.nextInt();
			menuChoice(choice);
		}
	}

	public void menuChoice(int choice) {

		switch (choice) {
		case 1:
			airfield.listJets();
			break;
		case 2:
			flyJets();
			break;
		case 3:
			viewFastestJet();
			break;
		case 4:
			viewLongestRangeJet();
			break;
		case 5:
			loadCargoPlanes();
			break;
		case 7:
			addCustomJet();
			break;
		case 9:
			programOn = false;
			break;
		}
	}

	public void flyJets() {
		jets = new ArrayList<>(); // create array list
		jets.addAll(airfield.getJets()); // get jets from airfield
		System.out.println("\t-- Flying All Jets --");
		for (Jet jet : jets) {
			jet.fly();
		}
		System.out.println();
	}

	public void viewFastestJet() {
		jets = new ArrayList<>();
		jets.addAll(airfield.getJets());
		double fastestSpeed = 0.0;
		int indexOfFastestJet = 0;
		for (int i = 0; i < jets.size(); i++) {
			if (jets.get(i).getSpeed() > fastestSpeed) {
				fastestSpeed = jets.get(i).getSpeed();
				indexOfFastestJet = i;
			}
		}
		System.out.println("\t-- Fastest Jet in the fleet -- ");
		System.out.println(jets.get(indexOfFastestJet).toString() + "\n");
	}

	public void viewLongestRangeJet() {
		jets = new ArrayList<>();
		jets.addAll(airfield.getJets());
		double longestRange = 0.0;
		int indexOfLongestRangeJet = 0;
		for (int i = 0; i < jets.size(); i++) {
			if (jets.get(i).getRange() > longestRange) {
				longestRange = jets.get(i).getRange();
				indexOfLongestRangeJet = i;
			}
		}
		System.out.println("\t-- Jet with longest range in the fleet -- ");
		System.out.println(jets.get(indexOfLongestRangeJet).toString() + "\n");
	}

	public void loadCargoPlanes() {
		List<CargoPlane> planes = new ArrayList<>(); // create array list
		planes.addAll(airfield.getCargoPlanes()); // get jets from airfield
		System.out.println("\t-- Loading Cargo Carriers --");
		for (CargoPlane jet : planes) {
			if (jet.getType().equals("Carrier") && jet.getCargoStatus() == false) {
				jet.loadCargo();
			}
		}
		System.out.println();
	}

	public void addCustomJet() {
		userInput = new Scanner(System.in);
		//variables
		String model = null;
		double speed = 0.0;
		int range = 0;
		long price = 0;
		String type = null;
		
		System.out.println("What is the model name?");
		model = userInput.nextLine();
		boolean validSpeed = false;
		while (!validSpeed) {
			System.out.println("What is the speed in mph?");
			try {
				speed = userInput.nextDouble();
				validSpeed = true;
			} catch (InputMismatchException e) {
				System.out.println("Not a double.");
				userInput.nextLine();
			}
		}
		
		boolean validRange = false;
		while(!validRange) {
			System.out.println("What is the flying range in miles?");
			try {
				range = userInput.nextInt();
				validRange = true;
			}
			catch(InputMismatchException e) {
				System.out.println("Not an integer.");
				userInput.nextLine();
			}
		}
		
		boolean validPrice = false;
		while(!validPrice) {
			System.out.println("What is the price?");
			try {
				price = userInput.nextLong();
				validPrice = true;
			}
			catch(InputMismatchException e) {
				System.out.println("Not a long value.");
				userInput.nextLine();
			}
		}
		boolean isValid = false;
		while(!isValid) {
			System.out.println("Is it a Carrier or Fighter?");
			type = userInput.next();
			
			if(type.equals("Carrier") || type.equals("Fighter")) {
				isValid = true;
			} else {
				userInput.nextLine();
			}
			
		}
		
		JetImpl newJet = new JetImpl(model, speed, range, price, type);
		airfield.addjet(newJet);
	}

}
