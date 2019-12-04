package com.accenture.HPApp;

import java.util.Random;

public class Muggles {
	protected String name;
	protected String location;
	public boolean isWizard;
	protected int health;
	protected int damage;
	protected String tower;

	public Muggles(String name, String location, int health, int damage,
			boolean isWizard) {
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

	public boolean isWizard() {
		return true;
	}

	public void rename(String name) {
		setName(name);
	}

	public String goTo(Muggles muggle) {
		if (!(this.location.equals(muggle.location))) {
			this.location = muggle.location;
			System.out.println(this.name + " took a bus and went to "
					+ muggle.name + " in " + this.location);
		} else {
			System.out.println(this.name + " and " + muggle.name
					+ " are already in " + this.location);
		}
		return this.location;
	}

	public String summon(Muggles muggle) {
		muggle.goTo(this);
		return muggle.location;
	}

	public String sortRandomTower() {
		return "regular school.";
	}

	public String inviteTo(Muggles muggle, String location) {
		this.location = location;
		muggle.setLocation(location);
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
			System.out.println("This is fight is between " + this.name
					+ " and " + wizard.getName() + ".");
			// System.out.println(this);
			// System.out.println(wizard);
			while (this.isStillBrave() && wizard.isStillBrave()) {
				System.out.println(this.name + " attacked " + wizard.getName()
						+ " with a baseball bat.");
				wizard.receivedDamage(this.damage);
				// System.out.println(wizard);
				if (this.isStillBrave() && wizard.isStillBrave()) {
					System.out.println(wizard.getName() + " attacked "
							+ this.name + " with a nasty spell.");
					receivedDamage(wizard.getDamage());
					// System.out.println(toString());
				}
			}
			if (!isStillBrave()) {
				System.out.println("Fight is finished! " + this.name
						+ " health is below 20. " + this.name
						+ " is going to Old Riga to get a drink."
						+ wizard.getName() + " is victorious and has "
						+ wizard.getHealth() + " HP left.");
			} else {
				System.out
						.println("Fight is finished! "
								+ wizard.getName()
								+ " health is below 20."
								+ wizard.getName()
								+ "is running to Diagon Ally to get a butterbeer for recovery."
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
						+ " with a baseball bat.");
				muggle.receivedDamage(this.damage);
				// System.out.println(muggle);
				if (this.isStillBrave() && muggle.isStillBrave()) {
					System.out.println(muggle.getName() + " attacked "
							+ this.name + " with a fist on the eye.");
					receivedDamage(muggle.getDamage());
					// System.out.println(toString());
				}
			}
			if (!isStillBrave()) {
				System.out.println("Fight is finished! " + this.name
						+ "`s health is below 20. " + this.name
						+ " is going to Old RIga for recovery."
						+ muggle.getName() + " is victorious and has "
						+ muggle.getHealth() + " HP left.");
			} else {
				System.out
						.println("Fight is finished! "
								+ muggle.getName()
								+ "`s health is below 20 and is going to Old Riga to recovery. "
								+ this.name + " is victorious and has "
								+ this.health + " HP left.");
			}
		}
	}

	public void info() {
		System.out.println(this.name + " is at " + this.location);
	}

	@Override
	public String toString() {
		return "Muggles [name=" + name + ", health=" + health + ", damage="
				+ damage + "]";
	}
}