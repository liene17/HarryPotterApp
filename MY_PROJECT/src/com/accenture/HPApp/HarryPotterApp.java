package com.accenture.HPApp;

import java.util.Scanner;

public class HarryPotterApp {

	public static void main(String[] args) {

		Muggles harry = new Muggles("Harry Potter", "school", true);
		Muggles drako = new Muggles("Drako Malfoy","diagonally", true);
		Muggles janka = new Muggles("Janka","Plavnieki", false);
		
		 
		System.out.println(harry.info());
		System.out.println(drako.info());
		System.out.println(janka.info()); 
		
		System.out.println(harry.getAttitudeTrait());
		
		
		

	}

//	public static Muggles createByUser() {
//		Scanner scanner = new Scanner(System.in);
//		System.out
//				.println("You have chosen to create a new character of Harry Potter App!");
//		System.out.println("Please, enter the name of the character: ");
//		String inputName = scanner.nextLine();
//		System.out.println("Please, enter the tower: ");
//		int inputTower = scanner.nextInt();
//		System.out.println("Enter the location " + inputName
//				+ " will be created in: ");
//		String inputLocation = scanner.nextLine();
//		System.out
//				.println("Is "
//						+ inputName
//						+ " going to be a wizard or muggle? (type 'w' for wizard and 'm' for muggle)");
//		String inputIsWizard = "";
//		while (!(inputIsWizard == "w" || inputIsWizard == "m")) {
//			if (!(inputIsWizard == "")) {
//				System.out
//						.println("Your wish is not clear! Please, tell, if "
//								+ inputName
//								+ " is going to be a wizard or muggle? (type 'w' for wizard and 'm' for muggle)");
//			}
//			inputIsWizard = scanner.nextLine();
//		}
//		boolean isWizard = inputIsWizard == "w" ? true : false;
//		scanner.close();
//		Muggles creation = new Muggles(inputName, inputTower, inputLocation,
//				isWizard);
//		return creation;

//	}
}