package com.accenture.HPApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HarryPotterApp {
	static List<Object> allCharacters = new ArrayList<Object>();

	public static void main(String[] args) {
		Wizards harry = new Wizards("Harry Potter", "school", 34, 15, true);
		Wizards drako = new Wizards("Drako Malfoy", "diagonally", 77, 12, true);
		Muggles janka = new Muggles("Janka", "Plavnieki", 77, 19, false);

		allCharacters.add(harry);
		allCharacters.add(drako);
		allCharacters.add(janka);

		janka.fight(drako);
		harry.fight(janka);
		drako.fight(harry);
		// Menu();//
		harry.info();
		// drako.info();
		// janka.info();
		//
		// harry.goTo(drako);
		// harry.goTo(drako);
		// drako.summon(janka);
		//
		// harry.info();
		// drako.info();
		// janka.info();
	}

	public static void Menu() {
		printListNames();
		int chosenCharacter = chooseCharacter();
		characterSelection(chosenCharacter);
	}

	public static void printListNames() {
		System.out.println("Please choose a character: ");
		for (int i = 0; i < allCharacters.size(); i++) {
			Muggles muggle = (Muggles) allCharacters.get(i);
			System.out.println("Press " + (i + 1) + " for " + muggle.getName());
		}
	}

	public static int chooseCharacter() {
		Scanner scanner = new Scanner(System.in);
		int characterChoice = 0;
		do {
			System.out.println("Please enter a number from 1 to "
					+ allCharacters.size());
			while (!scanner.hasNextInt()) {
				System.out.println("This is not a number!");
				scanner.next();
			}
			characterChoice = scanner.nextInt();
		} while (characterChoice < 1 || characterChoice > allCharacters.size());

		Muggles printName = (Muggles) allCharacters.get(characterChoice - 1);
		System.out.println("You chose " + printName.getName());
		scanner.close();
		return characterChoice - 1;
	}

	public static void characterSelection(int charIndex) {
		if (allCharacters.get(charIndex) instanceof Wizards) {
			Wizards character = (Wizards) allCharacters.get(charIndex);
			processWizard(character);
		} else {
			Muggles character = (Muggles) allCharacters.get(charIndex);
			processMuggle(character);
		}
	}

	public static void processWizard(Wizards wizard) {
	}

	public static void processMuggle(Muggles muggle) {
	}

	public static void seeOptions() {
		System.out.println("What would you like to do?");
	}
	// for (int i = 0; i<list.size(); i++) {
		// if (list.get(i) instanceof Wizards) {
	// Wizards wizard = (Wizards) list.get(i);
	// System.out.println("Press " + i + " for " + wizard.getName());
	// } else {
	// Muggles muggle = (Muggles) list.get(i);
	// System.out.println("Press " + i + " for " + muggle.getName());
	// }
	// public static Muggles createByUser() {
	// Scanner scanner = new Scanner(System.in);
	// System.out
	// .println("You have chosen to create a new character of Harry Potter App!");
	// System.out.println("Please, enter the name of the character: ");
	// String inputName = scanner.nextLine();
	// System.out.println("Please, enter the tower: ");
	// int inputTower = scanner.nextInt();
	// System.out.println("Enter the location " + inputName
	// + " will be created in: ");
	// String inputLocation = scanner.nextLine();
	// System.out
	// .println("Is "
	// + inputName
	// +
	// " going to be a wizard or muggle? (type 'w' for wizard and 'm' for muggle)");
	// String inputIsWizard = "";
	// while (!(inputIsWizard == "w" || inputIsWizard == "m")) {
	// if (!(inputIsWizard == "")) {
	// System.out
	// .println("Your wish is not clear! Please, tell, if "
	// + inputName
	// +
	// " is going to be a wizard or muggle? (type 'w' for wizard and 'm' for muggle)");
	// }
	// inputIsWizard = scanner.nextLine();
	// }
	// boolean isWizard = inputIsWizard == "w" ? true : false;
	// scanner.close();
	// Muggles creation = new Muggles(inputName, inputTower, inputLocation,
	// isWizard);
	// return creation;}

}

