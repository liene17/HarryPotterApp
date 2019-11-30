package com.accenture.HPApp;

public class Muggles {
	private String name;
	private String location;
	private int health;
	private boolean isWizard;

	public Muggles(String name, String location, int health, boolean isWizard) {
		this.name = name;
		this.location = location;
		this.health = health;
		this.isWizard = isWizard;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public int getHealth() {
		return health;
	}

	public boolean isWizard() {
		return true;
	}

	public void summon(Muggles muggle) {

	}

	private int makeDamage() {
		return 10;
	}

	public int restoreHealth(int health) {
		return 15;
	}

	public void fight(Muggles muggle) {

	}

	public String invitieTo(Muggles muggle, String location) {
		return "school";
	}

	public String info() {
		return "";
	}
}
