package com.accenture.HPApp;

import java.util.Random;

public class Weapons {
	static Random r = new Random();
	static String[] muggleWeapons = new String[] { " baseball bat.", " fist.", " right hook.", " left hook.",
			" Molotov coctail.", " pocket knife.", " Japanese sword.", " A-91." };

	static String[] wizardWeapons = new String[] { " nasty spell.", " jelly-fingers curse.", " jelly-legs Jinx.",
			" leg-locker curse.", " pimple jinx.", " stinging hex.", " tickling charm.", " repelling charm." };

	private static String getWeapon(String[] weapons) {
		String printout = "";
		int random = r.nextInt((weapons.length - 1) + 1) + 0;
		for (int i = 0; i < weapons.length; i++) {
			if (i == random)
				printout = weapons[i];
		}
		return printout;
	}

	public static String getWizardWeapon() {
		return getWeapon(wizardWeapons);
	}

	public static String getMuggleWeapon() {
		return getWeapon(muggleWeapons);
	}
}
