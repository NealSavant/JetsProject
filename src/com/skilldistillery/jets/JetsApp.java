package com.skilldistillery.jets;

import java.util.ArrayList;
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
			System.out.println("\t-- Flying All Jets --");
			flyJets();
			System.out.println();
			break;
		case 3:
			viewFastestJet();
			break;
		case 4:
			viewLongestRangeJet();
			break;
		case 9:
			programOn = false;
			break;
		}
	}

	public void flyJets() {
		jets = new ArrayList<>(); // create array list
		jets.addAll(airfield.getJets()); // get jets from airfield
		for (Jet jet : jets) {
			jet.fly();
		}
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

}
