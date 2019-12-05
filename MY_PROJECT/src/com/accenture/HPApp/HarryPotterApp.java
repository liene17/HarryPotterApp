package com.accenture.HPApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HarryPotterApp {
	static List<Object> allCharacters = new ArrayList<Object>();

	public static void main(String[] args) {
		Wizards harry = new Wizards("Harry Potter", "Hogwarts", 60, 15, true);
		Wizards drako = new Wizards("Drako Malfoy", "Diagon Ally", 77, 12, true);
		Muggles janka = new Muggles("Janka", "Plavnieki", 33, 19, false);

		allCharacters.add(harry);
		allCharacters.add(drako);
		allCharacters.add(janka);
//		Menu();
//		janka.fight(drako);
//		drako.fight(harry);
//		harry.fight(janka);
		harry.fight(drako);

		// harry.info();
		// drako.info();
//		 janka.info();

//		System.out.println(createByUser());
//		System.out.println(wizardWeapons());

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
			System.out.println("Please enter a number from 1 to " + allCharacters.size());
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

	public static String[] optionList() {
		String[] options = new String[] { "Rename character", "Move character to a different location",
				"Summon another character to this characters location",
				"Invite another character to go to a new location together",
				"See where the character spent the schooltime at", "Fight another character",
				"See full info of the character" };
		return options;
	}

	public static String muggleWeapons() {
		String[] options = new String[] { " with a baseball bat.", " with a fist.", " with a right hook.",
				" with a left hook.", " with a Molotov coctail.", " with a pocket knife.", " with a Japanese sword.",
				" with an A-91." };
		Random r = new Random();
		String printout = "";
		int random = r.nextInt((options.length - 1) + 1) + 0;
		for (int i = 0; i < options.length; i++) {
			if (i == random)
				printout = options[i];
		}
		return printout;
	}

	public static String wizardWeapons() {
		String[] options = new String[] { " with a nasty spell.", " with a jelly-fingers curse.",
				" with a jelly-legs Jinx.", " with a leg-locker curse.", " with a pimple jinx.",
				" with a stinging hex.", " with a tickling charm.", " with repelling charm." };
		Random r = new Random();
		String printout = "";
		int random = r.nextInt((options.length - 1) + 1) + 0;
		for (int i = 0; i < options.length; i++) {
			if (i == random)
				printout = options[i];
		}
		return printout;
	}

	public static Muggles createByUser() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("You have chosen to create a new character of Harry Potter App!");
		System.out.println("Please, enter the name of the character: ");
		String inputName = scanner.nextLine();
		System.out.println("Please, enter the tower: ");

		int inputTower = scanner.nextInt(); // how will we know, which tower
// to choose?
		/*
		 * after creation automatically assigned to a tower and then let them choose
		 * another one, if they want to, letting them to state, whether they like the
		 * randomly assigned tower or not
		 */
		System.out.println("Enter the location " + inputName + " will be created in: ");
		String inputLocation = scanner.nextLine();
		System.out.println(
				"Is " + inputName + " going to be a wizard or muggle? (type 'w' for wizard and 'm' for muggle)");
		String inputIsWizard = "";
		while (!(inputIsWizard.equals("w") || inputIsWizard.equals("m"))) { // vai
																			// seit
																			// nepieciesama
																			// equalso
																			// metode?
			if (!(inputIsWizard == "")) {
				System.out.println("Your wish is not clear! Please, tell, if " + inputName
						+ " is going to be a wizard or muggle? (type 'w' for wizard and 'm' for muggle)");
			}
			inputIsWizard = scanner.nextLine();
		}
		boolean isWizard = inputIsWizard.equals("w") ? true : false;
		System.out.println("Nice choice! How many health points should " + inputName + " have?");
		int inputHealth = scanner.nextInt();
		if (inputHealth > 100) {
			System.out.println("Hey! Nobody's can be that healthy! Try choosing health less than 100 points.");
			inputHealth = scanner.nextInt();
		} else if (inputHealth < 50) {
			System.out.println("Has " + inputName + " fallen ill? Hmm, try entering number higher that 50...");
			inputHealth = scanner.nextInt();
		}
		System.out.println("Ok, great! How many damage point should " + inputName + " have?");
		int inputDamage = scanner.nextInt();
		if (inputDamage > 20) {
			System.out.println("Hey! Nobody's can be that strong! Try choosing damage less than 20 points.");
			inputHealth = scanner.nextInt();
		} else if (inputDamage < 10) {
			System.out.println(
					"Do you really want " + inputName + " to be that weak? Hmm, try entering number higher that 10...");
			inputHealth = scanner.nextInt();
		}
		System.out.println("Ok, good! And how many damage points should " + inputName + " have?");
		scanner.close();
		Muggles creation = new Muggles(inputName, inputLocation, inputHealth, inputDamage, isWizard);
		String creationTower = creation.sortRandomTower();
		System.out.println("Congratulations! " + inputName + " has been assigned to the " + creationTower);
		System.out.println("You have created " + inputName + " in " + inputLocation + " with " + inputHealth + "HP and "
				+ inputDamage + " damage power, who goes to " + creationTower + ". What an opponent!");
		return creation;
	}
}