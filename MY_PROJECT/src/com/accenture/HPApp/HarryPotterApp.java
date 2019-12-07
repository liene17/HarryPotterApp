package com.accenture.HPApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HarryPotterApp {
	static List<Object> allCharacters = new ArrayList<Object>();
	static Scanner scanner = new Scanner(System.in);
	public static final String notNumberMessage = "This is not a number! Please enter a number!";

	public static void main(String[] args) {
		Wizards harry = new Wizards("Harry Potter", "Hogwarts", 90, 15, true);
		Wizards drako = new Wizards("Drako Malfoy", "Diagon Ally", 77, 12, true);
		Muggles janka = new Muggles("Janka", "Plavnieki", 84, 19, false);
		allCharacters.add(harry);
		allCharacters.add(drako);
		allCharacters.add(janka);

//		harry.rename();
//		drako.rename();
//		janka.rename();
		System.out.println("Test");

		MainMenu mainMenu = new MainMenu(allCharacters);
		createByUser();
		mainMenu.menu();

	}

	public static void createByUser() {

		System.out.println("You have chosen to create a new character of Harry Potter App!");
		System.out.println("Please, enter the name of the character: ");
		String inputName = "";
		while (inputName.isEmpty()) {
			inputName = scanner.nextLine();
			if (inputName.isEmpty()) {
				System.out.println("There must be a name for the new character! Enter it: ");
			}
		}
		System.out.println("Enter the location " + inputName + " will be created in: ");
		String inputLocation = "";
		while (inputLocation.isEmpty()) {
			inputLocation = scanner.nextLine();
			if (inputLocation.isEmpty()) {
				System.out.println(inputName + " has to be standing somewhere. Enter the place: ");
			}
		}
		System.out.println(
				"Is " + inputName + " going to be a wizard or muggle? (type 'w' for wizard and 'm' for muggle)");
		String inputIsWizard = ".";

		while ((!(inputIsWizard.equals("w") || inputIsWizard.equals("m"))) || inputIsWizard.isEmpty()) {
			inputIsWizard = scanner.nextLine();
			if (inputIsWizard.isEmpty() || (inputIsWizard.contentEquals(".")
					|| (!(inputIsWizard.equals("w") || inputIsWizard.equals("m"))))) {
				System.out.println("Your wish is not clear! Please, tell, if " + inputName
						+ " is going to be a wizard or muggle? (type 'w' for wizard and 'm' for muggle)");
			}
		}
		boolean isWizard = inputIsWizard.equals("w") ? true : false;
		System.out.println("Nice choice!");
		int inputHealth = 0;
		do {
			System.out.println("How many health points should " + inputName + " have?");
			while (!scanner.hasNextInt()) {
				System.out.println(notNumberMessage);
				scanner.next();
			}
			inputHealth = scanner.nextInt();
			scanner.nextLine();
			if (inputHealth > 100) {
				System.out.println("Hey! Nobody's can be that healthy! Try choosing health less than 101 points.");
			} else if (inputHealth <= 50) {
				System.out.println("Has " + inputName + " fallen ill? Hmm, try entering number higher than 50...");
			}
		} while (!(inputHealth <= 100 && inputHealth > 50));
		System.out.println("Ok, great!");
		int inputDamage = 0;

		do {
			System.out.println("How many damage points should " + inputName + " have?");
			while (!scanner.hasNextInt()) {
				System.out.println(notNumberMessage);
				scanner.next();
			}
			inputDamage = scanner.nextInt();
			if (inputDamage >= 20) {
				System.out.println("Hey! Nobody's can be that strong! Try choosing damage less than 20 points.");
			} else if (inputDamage <= 10) {
				System.out.println("Do you really want " + inputName
						+ " to be that weak? Hmm, try entering number higher that 10...");
			}
		} while (!(inputDamage > 10 && inputDamage < 20));

		scanner.nextLine();

		if (isWizard) {
			Wizards creation = new Wizards(inputName, inputLocation, inputHealth, inputDamage, isWizard);
			String creationTower = creation.askSortingHat();
			System.out.println("Congratulations! " + inputName + " has been assigned to the " + creationTower);
			System.out.println("You have created " + inputName + " in " + inputLocation + " with " + inputHealth
					+ "HP and " + inputDamage + " damage power, who goes to " + creationTower + ". What an opponent!");
			System.out.println("-------------");
			allCharacters.add(creation);
		} else {
			Muggles creation = new Muggles(inputName, inputLocation, inputHealth, inputDamage, isWizard);
			String creationTower = creation.askSortingHat();
			System.out.println("Congratulations! " + inputName + " has been assigned to the " + creationTower);
			System.out.println("You have created " + inputName + " in " + inputLocation + " with " + inputHealth
					+ "HP and " + inputDamage + " damage power, who goes to " + creationTower + ". What an opponent!");
			System.out.println("-------------");
			allCharacters.add(creation);
		}
	}
}
