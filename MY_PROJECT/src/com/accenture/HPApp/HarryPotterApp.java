package com.accenture.HPApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HarryPotterApp {
	static List<Object> allCharacters = new ArrayList<Object>();
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		Wizards harry = new Wizards("Harry Potter", "Hogwarts", 60, 15, true);
		Wizards drako = new Wizards("Drako Malfoy", "Diagon Ally", 77, 12, true);
		Muggles janka = new Muggles("Janka", "Plavnieki", 33, 19, false);
		allCharacters.add(harry);
		allCharacters.add(drako);
		allCharacters.add(janka);

		MainMenu mainMenu = new MainMenu(allCharacters);
//		mainMenu.Menu();
		createByUser();
		mainMenu.printListNames("");

//		janka.fight(drako);
//		drako.fight(harry);
//		harry.fight(janka);
//		harry.fight(drako);

//		 harry.info();
		// drako.info();
//		 janka.info();

		

	}

	public static void createByUser() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("You have chosen to create a new character of Harry Potter App!");
		System.out.println("Please, enter the name of the character: ");
		String inputName = scanner.nextLine();
		System.out.println("Enter the location " + inputName + " will be created in: ");
		String inputLocation = scanner.nextLine();
		System.out.println(
				"Is " + inputName + " going to be a wizard or muggle? (type 'w' for wizard and 'm' for muggle)");
		String inputIsWizard = ".";
		while (!(inputIsWizard.equals("w") || inputIsWizard.equals("m"))) {
			if (inputIsWizard.isEmpty()) {
				System.out.println("Your wish is not clear! Please, tell, if " + inputName
						+ " is going to be a wizard or muggle? (type 'w' for wizard and 'm' for muggle)");
			}
			inputIsWizard = scanner.nextLine();
		}
		boolean isWizard = inputIsWizard.equals("w") ? true : false;
		System.out.println("Nice choice! How many health points should " + inputName + " have?");
		int inputHealth = 0;
		while (!(inputHealth < 100 && inputHealth > 50)) {
			inputHealth = scanner.nextInt();
			if (inputHealth > 100) {
				System.out.println("Hey! Nobody's can be that healthy! Try choosing health less than 100 points.");
			} else if (inputHealth < 50) {
				System.out.println("Has " + inputName + " fallen ill? Hmm, try entering number higher than 50...");
			}
		}
		System.out.println("Ok, great! How many damage points should " + inputName + " have?");
		int inputDamage = 0;
		while (!(inputDamage > 10 && inputDamage < 20)) {
			inputDamage = scanner.nextInt();
			if (inputDamage > 20) {
				System.out.println("Hey! Nobody's can be that strong! Try choosing damage less than 20 points.");
			} else if (inputDamage < 10) {
				System.out.println("Do you really want " + inputName
						+ " to be that weak? Hmm, try entering number higher that 10...");
			}
		}
		scanner.close();
		if (isWizard) {
			Wizards creation = new Wizards(inputName, inputLocation, inputHealth, inputDamage, isWizard);
			String creationTower = creation.askSortingHat();
			System.out.println("Congratulations! " + inputName + " has been assigned to the " + creationTower);
			System.out.println("You have created " + inputName + " in " + inputLocation + " with " + inputHealth + "HP and "
					+ inputDamage + " damage power, who goes to " + creationTower + ". What an opponent!");
			allCharacters.add(creation);
		} else {
			Muggles creation = new Muggles(inputName, inputLocation, inputHealth, inputDamage, isWizard);
			String creationTower = creation.askSortingHat();
			System.out.println("Congratulations! " + inputName + " has been assigned to the " + creationTower);
			System.out.println("You have created " + inputName + " in " + inputLocation + " with " + inputHealth + "HP and "
					+ inputDamage + " damage power, who goes to " + creationTower + ". What an opponent!");
			allCharacters.add(creation);
		}
	}
}
