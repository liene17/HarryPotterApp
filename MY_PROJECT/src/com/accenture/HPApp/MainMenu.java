package com.accenture.HPApp;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MainMenu {

	Scanner scanner = new Scanner(System.in);
	List<Object> allCharacters;

	String[] options = new String[] { "Rename character", "Go to another characters' location",
			"Summon another character to this characters location",
			"Invite another character to go to a new location together",
			"See where the character spent the schooltime at", "Fight another character",
			"See full info of the character" };

	public MainMenu(List<Object> allCharacters) {
		this.allCharacters = allCharacters;
	}

	public void menu() {
		printListNames("");
		int chosenCharacterIndex = chooseCharacter(-1);
		Object selectedCharacter = characterSelection(chosenCharacterIndex);
		seeOptions();
		int selectedAction = chooseAction();
		doMethod(selectedCharacter, selectedAction, chosenCharacterIndex);
		doAgain(selectedCharacter,chosenCharacterIndex);
	}

	public int printListNames(String name) {
		int callerID = 0;
		System.out.println("Please choose a character: ");
		for (int i = 0; i < allCharacters.size(); i++) {
			Muggles muggle = (Muggles) allCharacters.get(i);
			if (name.equals(muggle.getName())) {
				callerID = i;
				continue;
			}
			System.out.println("Press " + (i + 1) + " for " + muggle.getName());
		}
		return callerID;
	}

	public int chooseCharacter(int callerID) {
		int characterChoiceIndex = 0;
		do {
			System.out.println("Please enter one of the suggested numbers: ");
			while (!scanner.hasNextInt()) {
				System.out.println("This is not a number!");
				scanner.next();
			}
			characterChoiceIndex = scanner.nextInt();
		} while ((characterChoiceIndex < 1 || characterChoiceIndex > allCharacters.size())
				|| characterChoiceIndex == callerID + 1);

		Muggles printName = (Muggles) allCharacters.get(characterChoiceIndex - 1);
		System.out.println("You chose " + printName.getName());
		return characterChoiceIndex - 1;
	}

	public Object characterSelection(int charIndex) {
		return allCharacters.get(charIndex);
	}

	public void seeOptions() {
		System.out.println("What would you like to do?");
		for (int i = 0; i < this.options.length; i++) {
			System.out.println("Press " + (i + 1) + " for " + this.options[i]);
		}
	}

	public int chooseAction() {
		int chosenOption = 0;
		int length = this.options.length;
		do {
			System.out.println("Please enter a number from 1 to " + length);
			while (!scanner.hasNextInt()) {
				System.out.println("This is not a number!");
				System.out.println(scanner.next());
			}
			chosenOption = scanner.nextInt();
		} while (chosenOption < 1 || chosenOption > length);

		for (int i = 0; i < length; i++) {
			if (chosenOption - 1 == i) {
				System.out.println("You chose: " + this.options[i] + ".");
			}
		}
		return chosenOption;
	}

	public void doMethod(Object character, int chosenOption, int chosenCharacterIndex) {
		if (character instanceof Wizards) {
			Wizards wizard = (Wizards) character;
			switch (chosenOption) {
			case 1:
				System.out.println("Enter the new name for " + wizard.getName() + ": ");
				String newName = scanner.next();
				wizard.rename(newName);
				break;
			case 2:
				System.out.println("To which character you want to go to?");
				printListNames(wizard.getName());
				Object selectedCharacter = characterSelection(chooseCharacter(chosenCharacterIndex));
				wizard.goTo(selectedCharacter);
				break;
			case 3:
				System.out.println("Which character do you want to summon?");
				printListNames(wizard.getName());
				Object selectedChar = characterSelection(chooseCharacter(chosenCharacterIndex));
				wizard.summon(selectedChar);
				break;
			case 4:
				System.out.println("Which character do you want to invite to visit a new place together?");
				printListNames(wizard.getName());
				Object invitedCharacter = characterSelection(chooseCharacter(chosenCharacterIndex));
				System.out.println("Enter the new name for the new location: ");
				String newLocation = scanner.next();
				wizard.inviteTo(invitedCharacter, newLocation);
				break;
			case 5:
				System.out.println(wizard.getName() + " did the studies at " + wizard.getStudyplace());
				System.out.println("Would you like to ask the Sorting hat if " + wizard.getName()
						+ " can be placed in a tower at Hogwarts?");
				int input = 0;
				while (!(input == 1 || input == 2)) {
					System.out.println("Press 1 for yes");
					System.out.println("Press 2 for no");
					input = scanner.nextInt();
				}
				if (input == 1) {
					System.out.println(
							wizard.getName() + " is studying at Hogwarts and is assigned to " + wizard.askSortingHat());
				} else {
					System.out.println("The information about " + wizard.getName() + " will keep being a mystery.");
				}
				break;

			case 6:
				System.out.println("Which character would you like to fight?");
				printListNames(wizard.getName());
				Object charToFight = characterSelection(chooseCharacter(chosenCharacterIndex));
				wizard.fight(charToFight);
				break;
			case 7:
				wizard.info();
				break;
			default:
				System.out.println("Error detector!");
			}
		} else {
			Muggles muggle = (Muggles) character;
			switch (chosenOption) {
			case 1:
				System.out.println("Enter the new name for " + muggle.getName() + ": ");
				String newName = scanner.nextLine();
				muggle.rename(newName);
				break;
			case 2:
				System.out.println("To which character you want to go to?");
				printListNames(muggle.getName());
				Object selectedCharacter = characterSelection(chooseCharacter(chosenCharacterIndex));
				muggle.goTo(selectedCharacter);
				break;
			case 3:
				System.out.println("Which character do you want to call over?");
				printListNames(muggle.getName());
				Object selectedChar = characterSelection(chooseCharacter(chosenCharacterIndex));
				muggle.summon(selectedChar);
				break;
			case 4:
				System.out.println("Which character do you want to invite to visit a new place together?");
				printListNames(muggle.getName());
				Object invitedCharacter = characterSelection(chooseCharacter(chosenCharacterIndex));
				System.out.println("Enter the new name for the new location: ");
				String newLocation = scanner.next();
				muggle.inviteTo(invitedCharacter, newLocation);
				break;
			case 5:
				System.out.println(muggle.getName() + " did the studies at " + muggle.getStudyplace());
				System.out.println("Would you like to ask the Sorting hat if " + muggle.getName()
						+ " can be placed in a tower at Hogwarts?");
				int input = 0;
				while (!(input == 1 || input == 2)) {
					System.out.println("Press 1 for yes");
					System.out.println("Press 2 for no");
					input = scanner.nextInt();
				}
				if (input == 1) {
					System.out.println(muggle.getName() + " is a muggle and cannot attend Hogwarts. " + muggle.getName()
							+ " is assigned to study at " + muggle.askSortingHat());
				} else {
					System.out.println("The information about " + muggle.getName() + " will keep being a mystery.");
				}
				break;

			case 6:
				System.out.println("Which character would you like to fight?");
				printListNames(muggle.getName());
				Object charToFight = characterSelection(chooseCharacter(chosenCharacterIndex));
				muggle.fight(charToFight);
				break;
			case 7:
				muggle.info();
				break;
			default:
				System.out.println("Error detector!");
			}
		}
	}
	public void doAgain(Object character, int chosenCharacterIndex) {
		System.out.println("Do you want to do another action?");
		int input =0;
		while (!(input >= 1 && input <= 4)) {
			System.out.println("Press 1 for choosing another action on this character");
			System.out.println("Press 2 for choosing another character");
			System.out.println("Press 3 for creating a new character");
			System.out.println("Press 4 for ending programme");
			
			input = scanner.nextInt();
		}
		switch (input) {
		case 1:
			seeOptions();
			int selectedAction = chooseAction();
			doMethod(character, selectedAction, chosenCharacterIndex);
			doAgain(character, selectedAction);
			break;
		case 2:
			menu();
			break;
		case 3:
			HarryPotterApp.createByUser();
			menu();
			break;
		case 4:
			System.out.println("Thank you for using the Harry Potter App! Have a magical day!");
			break;
		default: 
		}
	}
}
