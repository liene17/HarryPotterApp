package com.accenture.HPApp;

import java.util.Random;

public class Wizards extends Muggles {
	public Wizards(String name, String location, int health, int damage,
			boolean isWizard) {
		super(name, location, health, damage, isWizard);
	}

	@Override
	public String goTo(Muggles muggle) {
		if (!(this.location.equals(muggle.location))) {
			this.location = muggle.location;
			System.out.println(this.name + " magically teleported to "
					+ muggle.name + " in " + this.location);
		} else {
			System.out.println(this.name + " and " + muggle.name
					+ " both are already in " + this.location);
		}
		return this.location;
	}

	@Override
	public String sortRandomTower() {
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
			tower = "Muggles go to regular school.";
		}
		this.tower = tower;
		return tower;
	}

	@Override
	public void fight(Object opponent) {
		if (opponent instanceof Wizards) {
			Wizards wizard = (Wizards) opponent;
			System.out.println("This is fight is between " + this.name
					+ " and " + wizard.getName() + ".");
			// System.out.println(this);
			// System.out.println(wizard);
			while (this.isStillBrave() && wizard.isStillBrave()) {
				System.out.println(this.name + " attacked " + wizard.getName()
						+ " with a nasty spell.");
				wizard.receivedDamage(this.damage);
				// System.out.println(wizard);
				if (this.isStillBrave() && wizard.isStillBrave()) {
					System.out.println(wizard.getName() + " attacked "
							+ this.name + " with an equally nasty spell.");
					receivedDamage(wizard.getDamage());
					// System.out.println(toString());
				}
			}
			if (!isStillBrave()) {
				System.out
						.println("Fight is finished! "
								+ this.name
								+ " health is below 20. "
								+ this.name
								+ " is going to Diagon Ally to get a butterbeer for recovery. "
								+ wizard.getName() + " is victorious and has "
								+ wizard.getHealth() + " HP left.");
			} else {
				System.out
						.println("Fight is finished! "
								+ wizard.getName()
								+ " health is below 20 and is running to Diagon Ally to get a butterbeer for recovery. "
								+ this.name + " is victorious and has "
								+ this.health + " HP left.");
			}
		} else {
			Muggles muggle = (Muggles) opponent;
			System.out.println("This is fight is between " + this.name
					+ " and " + muggle.getName() + ".");
			// System.out.println(this);
			// System.out.println(muggle);
			while (this.isStillBrave() && muggle.isStillBrave()) {
				System.out.println(this.name + " attacked " + muggle.getName()
						+ " with a nasty spell.");
				muggle.receivedDamage(this.damage);
				// System.out.println(muggle);
				if (this.isStillBrave() && muggle.isStillBrave()) {
					System.out.println(muggle.getName() + " attacked "
							+ this.name + " with a baseball bat");
					receivedDamage(muggle.getDamage());
					// System.out.println(toString());
				}
			}
			if (!isStillBrave()) {
				System.out
						.println("Fight is finished! "
								+ this.name
								+ "`s health is below 20 and is running to Diagon Ally to get a butterbeer for recovery. "
								+ muggle.getName() + " is victorious and has "
								+ muggle.getHealth() + " HP left.");
			} else {
				System.out
						.println("Fight is finished! "
								+ muggle.getName()
								+ " health is below 20 and is going to Old Riga to recovery. "
								+ this.name + " is victorious and has "
								+ this.health + " HP left.");
			}
		}
	}

	@Override
	public String toString() {
		return "Wizards [name=" + name + ", health=" + health + ", damage="
				+ damage + "]";
	}
}
