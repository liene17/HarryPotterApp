package com.accenture.HPApp;

public class Muggles {
	private String name;
	private int age; 
	private String location;
	public boolean isWizard;
	private int attitudeTrait;

	public Muggles(String name, int age, String location, boolean isWizard) {
		this.name = name;
		this.location = location;
		this.isWizard = isWizard;
		this.age = age; 
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	public boolean isWizard() {
		return true;
	}

	public String goTo(Muggles muggle) {
		if (!(this.location == muggle.location)) {
			this.location = muggle.location;
		} else {
			System.out.println(this.name + "and" + muggle.name
					+ "are already on the same place.");
		}
		return this.location;
	}

	public String summon(Muggles muggle) {
		muggle.goTo(this);
		return muggle.location;
	}

	private void doGood(Muggles muggle) {
		attitudeTrait = attitudeTrait + 1;
		System.out.println(muggle + " looks happy!");
	}

	public void doBad(Muggles muggle) {
		attitudeTrait = attitudeTrait - 1;
		System.out.println(muggle + " looks sad. :(");
	}

	public String invitieTo(Muggles muggle, String location) {
		return "";
	}

	public String info() {
		return "";
	}
}
