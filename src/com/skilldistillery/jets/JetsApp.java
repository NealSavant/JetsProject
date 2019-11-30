package com.skilldistillery.jets;

import java.util.Scanner;

public class JetsApp {
	// f i e l d s
	private AirField airfield;
	private JetImpl placeJets;
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
		case 9:
			programOn = false;
			
			
		}
	}

}
