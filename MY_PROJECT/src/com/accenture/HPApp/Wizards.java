package com.accenture.HPApp;

import java.util.Random;

public class Wizards extends Muggles {
	public Wizards(String name, String location, int health, int damage, boolean isWizard) {
		super(name, location, health, damage, isWizard);
	}

	@Override
	public String goTo(Object characterObject) {
		Muggles character = (Muggles) characterObject;
		if (!(this.location.equals(character.location))) {
			this.location = character.location;
			System.out.println(this.name + " magically teleported to " + character.name + " in " + this.location);
		} else {
			System.out.println(this.name + " and " + character.name + " both are already in " + this.location);
		}
		return this.location;
	}

	@Override
	public String askSortingHat() {
		String tower = "";
		Random r = new Random();
		int test = r.nextInt((4 - 1) + 1) + 1;
		switch (test) {
		case 1:
			tower = "Gryffindor";
			break;
		case 2:
			tower = "Ravenclaw";
			break;
		case 3:
			tower = "Hufflepuff";
			break;
		case 4:
			tower = "Slytherin";
			break;
		default:
			tower = "regular school.";
		}
		this.studyPlace = tower;
		return tower;
	}

	@Override
	public void fight(Object opponent) {
		if (opponent instanceof Wizards) {
			Wizards wizard = (Wizards) opponent;
			if (this.location.equals(wizard.getLocation())) {
				System.out.println("This fight is between " + this.name + " and " + wizard.getName() + ".");
				while (this.isStillBrave() && wizard.isStillBrave()) {
					System.out.println(
							this.name + " attacked " + wizard.getName() + " with a " + Weapons.getWizardWeapon());
					wizard.receivedDamage(this.damage);
					if (this.isStillBrave() && wizard.isStillBrave()) {
						System.out.println(
								wizard.getName() + " attacked " + this.name + " with a " + Weapons.getWizardWeapon());
						receivedDamage(wizard.getDamage());
					}
				}
				if (!isStillBrave()) {
					System.out.println("Fight is finished! " + this.name + " health is below 20. " + this.name
							+ "s' health is below 20 and is running to Diagon Ally to get a butterbeer for recovery. "
							+ wizard.getName() + " is victorious and has " + wizard.getHealth() + " HP left.");
				} else {
					System.out.println("Fight is finished! " + wizard.getName()
							+ "s' health is below 20 and is running to Diagon Ally to get a butterbeer for recovery. "
							+ this.name + " is victorious and has " + this.health + " HP left.");
				}
			} else {
				System.out.println(
						this.name + " and " + wizard.getName() + " are not in a same place so they cannot fight. ");
				System.out.println("Since " + this.name + " is eager for a fight, " + this.name + " will go to the "
						+ wizard.getName() + " location.");
				goTo(wizard);
				fight(wizard);
			}
		} else {
			Muggles muggle = (Muggles) opponent;
			if (this.location.equals(muggle.getLocation())) {
				System.out.println("This fight is between " + this.name + " and " + muggle.getName() + ".");
				while (this.isStillBrave() && muggle.isStillBrave()) {
					System.out.println(
							this.name + " attacked " + muggle.getName() + " with a " + Weapons.getWizardWeapon());
					muggle.receivedDamage(this.damage);
					if (this.isStillBrave() && muggle.isStillBrave()) {
						System.out.println(
								muggle.getName() + " attacked " + this.name + " with a " + Weapons.getMuggleWeapon());
						receivedDamage(muggle.getDamage());
					}
				}
				if (!isStillBrave()) {
					System.out.println("Fight is finished! " + this.name
							+ "s' health is below 20 and is running to Diagon Ally to get a butterbeer for recovery "
							+ muggle.getName() + " is victorious and has " + muggle.getHealth() + " HP left.");
				} else {
					System.out.println("Fight is finished! " + muggle.getName()
							+ "s' health is below 20 and is going to Old Riga to get a regular beet for recovery. "
							+ this.name + " is victorious and has " + this.health + " HP left.");
				}
			} else {
				System.out.println(
						this.name + " and " + muggle.getName() + " are not in a same place so they cannot fight. ");
				System.out.println("Since " + this.name + " is eager for a fight, " + this.name + " will go to the "
						+ muggle.getName() + " location.");
				goTo(muggle);
				fight(muggle);
			}
		}
	}

	@Override
	public void info() {
		System.out.println(this.name + " is at " + this.location + " and is a wizard. " + this.name + " has "
				+ this.health + " health and can make " + this.damage + " during a fight. " + this.name + " studies at "
				+ this.studyPlace);
	}
}
