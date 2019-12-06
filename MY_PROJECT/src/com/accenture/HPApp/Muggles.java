package com.accenture.HPApp;

import java.util.Random;
import java.util.Scanner;

public class Muggles {
	protected String name;
	protected String location;
	public boolean isWizard;
	protected int health;
	protected int damage;
	protected String studyPlace = "a place not known to general public.";

	Scanner scanner = new Scanner(System.in);

	public Muggles(String name, String location, int health, int damage, boolean isWizard) {
		this.name = name;
		this.location = location;
		if (health > 100) {
			health = 100;
		} else if (health < 1) {
			health = 1;
		}
		this.health = health;
		if (damage > 100) {
			damage = 100;
		} else if (damage < 1) {
			damage = 1;
		}
		this.damage = damage;
		this.isWizard = isWizard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getHealth() {
		return health;
	}

	private void setHealth(int health) {
		this.health = health;
	}

	protected int getDamage() {
		return damage;
	}

	private void setDamage(int damage) {
		this.damage = damage;
	}

	public String getStudyplace() {
		return studyPlace;
	}

	public boolean isWizard() {
		return true;
	}

	public void rename(String name) {
		name = scanner.nextLine();
		System.out.println(this.name + " is now called " + name);
		setName(name);
	}

	public String goTo(Object characterObject) {
		Muggles character = (Muggles) characterObject;
		if (!(this.location.equals(character.location))) {
			this.location = character.location;
			System.out.println(this.name + " took a bus and went to " + character.name + " in " + this.location);
		} else {
			System.out.println(this.name + " and " + character.name + " are already in " + this.location);
		}
		return this.location;
	}

	public String summon(Object characterObject) {
		Muggles character = (Muggles) characterObject;
		character.goTo(this);
		return character.location;
	}

	public String askSortingHat() {
		return "regular school.";
	}

	public String inviteTo(Object characterObject, String location) {
		Muggles character = (Muggles) characterObject;
		this.location = location;
		character.setLocation(location);
		System.out.println("Now both " + this.name + " and " + character.getName() + " are in " + this.location + ".");
		return this.location;
	}

	public boolean isStillBrave() {
		if (this.health > 20) {
			return true;
		} else {
			return false;
		}
	}

	public void receivedDamage(int damage) {
		if (isStillBrave() && damage > 0) {
			if (this.health - damage > 0) {
				this.health -= damage;
				isStillBrave();
			} else {
				this.health = 0;
				isStillBrave();
			}
		} else {
			System.out.println("The planned damage is not valid.");
		}
	}

	public void fight(Object opponent) {
		if (opponent instanceof Wizards) {
			Wizards wizard = (Wizards) opponent;
			System.out.println("This is fight is between " + this.name + " and " + wizard.getName() + ".");
			while (this.isStillBrave() && wizard.isStillBrave()) {
				System.out.println(this.name + " attacked " + wizard.getName() + "with a " + Weapons.getMuggleWeapon());
				wizard.receivedDamage(this.damage);
				if (this.isStillBrave() && wizard.isStillBrave()) {
					System.out.println(
							wizard.getName() + " attacked " + this.name + "with a " + Weapons.getWizardWeapon());
					receivedDamage(wizard.getDamage());
				}
			}
			if (!isStillBrave()) {
				System.out.println("Fight is finished! " + this.name + " health is below 20. " + this.name
						+ " is going to Old Riga to get a drink." + wizard.getName() + " is victorious and has "
						+ wizard.getHealth() + " HP left.");
			} else {
				System.out.println("Fight is finished! " + wizard.getName() + " health is below 20." + wizard.getName()
						+ "is running to Diagon Ally to get a butterbeer for recovery." + this.name
						+ " is victorious and has " + this.health + " HP left.");
			}
		} else {
			Muggles muggle = (Muggles) opponent;
			System.out.println("This is fight is between " + this.name + " and " + muggle.getName() + ".");
			while (this.isStillBrave() && muggle.isStillBrave()) {
				System.out.println(this.name + " attacked " + muggle.getName() + "with a " + Weapons.getWizardWeapon());
				muggle.receivedDamage(this.damage);
				if (this.isStillBrave() && muggle.isStillBrave()) {
					System.out.println(
							muggle.getName() + " attacked " + this.name + "with a " + Weapons.getMuggleWeapon());
					receivedDamage(muggle.getDamage());
				}
			}
			if (!isStillBrave()) {
				System.out.println("Fight is finished! " + this.name + "`s health is below 20. " + this.name
						+ " is going to Old RIga for recovery." + muggle.getName() + " is victorious and has "
						+ muggle.getHealth() + " HP left.");
			} else {
				System.out.println("Fight is finished! " + muggle.getName()
						+ "`s health is below 20 and is going to Old Riga to recovery. " + this.name
						+ " is victorious and has " + this.health + " HP left.");
			}
		}
	}

	public void info() {
		System.out.println(
				this.name + " is at " + this.location + " and is a muggle. " + this.name + " has " + this.health
						+ " health and can make " + this.damage + " during a fight. " + this.name + " studies at " + this.studyPlace);
	}
}