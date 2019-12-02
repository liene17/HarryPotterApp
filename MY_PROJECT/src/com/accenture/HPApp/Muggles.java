package com.accenture.HPApp;

import java.util.Random;

public class Muggles {
	private String name;
	private int tower;
	private String location;
	public boolean isWizard;
	private int attitudeTrait;
	private int happinessLevel;

	public Muggles(String name, String location, boolean isWizard) {
		this.name = name;
		this.location = location;
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

	public void setName(String name) {
		this.name = name;
	}

	public int getAttitudeTrait() {
		return attitudeTrait;
	}

	public void setAttitudeTrait(int attitudeTrait) {
		this.attitudeTrait = attitudeTrait;
	}

	public int getHappinessLevel() {
		return happinessLevel;
	}

	public void setHappinessLevel(int happinessLevel) {
		this.happinessLevel = happinessLevel;
	}

	public boolean isWizard() {
		return true;
	}

//	public String goTo(Muggles muggle2) {
//		if (!(this.location == muggle2.location)) {
//			this.location = muggle2.location;
//		} else {
//			System.out.println(this.name + "and" + muggle2.name
//					+ "are already on the same place.");
//		}
//		return this.location;
//	}

//	public String summon(Muggles muggle) {
//		muggle.goTo(this);
//		return muggle.location;
//	}

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
			tower = "No such tower available";
		}
		return tower;
	}

	private void doGoodTo(Muggles muggle) {
		muggle.setHappinessLevel(muggle.happinessLevel + 1);
		this.attitudeTrait++;
	}

	private String infoHappinessLevel() {
		String happinessInfo = (happinessLevel > 5) ? "" + this.name
				+ "is very happy"
				: (happinessLevel <= 5 && happinessLevel > 0) ? "" + this.name
						+ "is OK" : "" + this.name + "is feeling bad";
		return happinessInfo;
	}

	public void doBad(Muggles muggle) {
		muggle.setHappinessLevel(muggle.happinessLevel - 1);
		this.attitudeTrait--;

	}

	private String infoAttitudeTrait() {
		String attitudeInfo = (this.attitudeTrait > 5) ? "" + this.name
				+ "is a hero"
				: (this.attitudeTrait <= 5 && this.attitudeTrait > 0) ? ""
						+ this.name + "is a normal person" : "" + this.name
						+ "is a villain";
		return attitudeInfo;
	}

	public String inviteTo(Muggles muggle, String location) {
		return "";
	}

	public String info() {
		return name + " is at " + location + " and his attitude is "
				+ attitudeTrait;
	}
}
