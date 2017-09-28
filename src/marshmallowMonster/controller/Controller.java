package marshmallowMonster.controller;

import java.util.ArrayList;
import java.util.List;
import java.lang.NumberFormatException;

import marshmallowMonster.view.GuiController;
import marshmallowMonster.model.Monster;

public class Controller {
	
	GuiController gui = new GuiController();
	
	public void start() {
		
		ArrayList<Monster> monsters = new ArrayList<Monster>();
		
		monsters.add(new Monster("Philip", 2, 2, 2, true));
		monsters.add(new Monster("Bob", 1, 3, 0, true));
		monsters.add(new Monster());
		
		// eats the first monster
		monsters.get(0).eat();
		
		// create monster #3 from blank declared earlier
//		interactiveMonsterCreation(monsters.get(2));
		
		
		// eats eyes of monster #2
//		boolean correctInput = false;
//		String tempString;
//		while (!correctInput) {
//			tempString = gui.displayQuestion(monsters.get(1).toString() + "\nHow many eyes would you like to eat?");
//			if (isValidInt(tempString)) {
//				eatPartNoFeedback(monsters.get(1), "eye", Math.abs(Integer.parseInt(tempString)));
//				correctInput = true;
//			}
//			else if (tempString == null) {
//				correctInput = true;
//			}
//			else {
//				gui.displayText("Entered value was not an positive integer, try again");
//			}
//		}
		
		// prints all monsters
		printMonsterArrayListToPopup(monsters);
	}
	
	private void printMonsterArrayListToPopup(List<Monster> monsters) {
		String tempString = "";
//		for (int i = 0; i < monsters.size(); i++) {
//			tempString += monsters.get(i).toString() + "\n";
//		}
		for(Monster current : monsters){
			tempString+=current.toString() + "\n";
		}
		gui.displayText(tempString);
	}
	
	private void eatPart(Monster monster, String part, double amount) {
		
		// valid parts: arm, eye, tentacle, bloop
		
		if (amount < 0) {
			System.out.println("Error: amount is less than 0");
		}
		else if (amount == 0) {
			System.out.println("Error: amount is 0");
		}
		else {
			switch (part.toLowerCase()) {
				case "arm":
					monster.setArmCount(monster.getArmCount() - (int) amount);
					System.out.println("you ate " + amount + " arm(s)");
					if (monster.getArmCount() < 0) {
						monster.setArmCount(0);
					}
					System.out.println("the monster now has " + monster.getArmCount());
					break;
				case "eye":
					monster.setEyeCount(monster.getEyeCount() - (int) amount);
					System.out.println("you ate " + amount + " eye(s)");
					if (monster.getEyeCount() < 0) {
						monster.setEyeCount(0);
					}
					System.out.println("the monster now has " + monster.getEyeCount());
					break;
				case "tentacle":
					monster.setTentacleAmount(monster.getTentacleAmount() - amount);
					System.out.println("you ate " + amount + " tentacle(s)");
					if (monster.getTentacleAmount() < 0) {
						monster.setTentacleAmount(0);
					}
					System.out.println("the monster now has " + monster.getTentacleAmount());
					break;
				case "bloop":
					if (monster.gethasBloop()) {
						monster.setHasBloop(false);
						System.out.println("The monster now no longer has a bloop");
					}
					else {
						System.out.println("The monster Doesn't have a bloop to eat");
					}
					break;
			}
		}
	}
	
	private void eatPartNoFeedback(Monster monster, String part, double amount) {
		// valid parts: arm, eye, tentacle, bloop
		
		switch (part.toLowerCase()) {
			case "arm":
				monster.setArmCount(monster.getArmCount() - (int) amount);
				if (monster.getArmCount() < 0) {
					monster.setArmCount(0);
				}
				break;
			case "eye":
				monster.setEyeCount(monster.getEyeCount() - (int) amount);
				if (monster.getEyeCount() < 0) {
					monster.setEyeCount(0);
				}
				break;
			case "tentacle":
				monster.setTentacleAmount(monster.getTentacleAmount() - amount);
				if (monster.getTentacleAmount() < 0) {
					monster.setTentacleAmount(0);
				}
				break;
			case "bloop":
				if (monster.gethasBloop()) {
					monster.setHasBloop(false);
				}
				break;
		}
	}
	
	private void interactiveMonsterCreation(Monster monster) {
		
		int eyeCount = 0, armCount = 0;
		double tenticleAmount = 0;
		String name = "";
		boolean hasBloop = false;
		
		boolean isComplete = false;
		
		while (!isComplete) {
			
			try {
				name = gui.displayQuestion("ID: " + monster.getID() + "\nEnter Name");
				eyeCount = Integer
						.parseInt(gui.displayQuestion("ID: " + monster.getID() + "\n(Integer) Enter number of eyes"));
				tenticleAmount = Double.parseDouble(
						gui.displayQuestion("ID: " + monster.getID() + "\n(Double) Enter number of Tenticles"));
				armCount = Integer
						.parseInt(gui.displayQuestion("ID: " + monster.getID() + "\n(Integer) Enter number of Arms"));
				hasBloop = Boolean.parseBoolean(
						gui.displayQuestion("ID: " + monster.getID() + "\n(Boolean) Does it hava a Bloop?"));
				
				isComplete = true;
			}
			catch (Exception e) {
				gui.displayText("\nField not entered correctly, Make sure it was the correct data type\n");
			}
			
		}
		
		monster.initialize(name, eyeCount, armCount, tenticleAmount, hasBloop);
	}
	
	// helpers-----------------------------------------------------------------------------------------------
	
	private boolean isValidInt(String sample) {
		try {
			Integer.parseInt(sample);
		}
		catch (NumberFormatException e) {
			return false;
		}
		
		return true;
	}
	
	private boolean isValidDouble(String sample) {
		try {
			Double.parseDouble(sample);
		}
		catch (NumberFormatException e) {
			return false;
		}
		
		return true;
	}
	
	private boolean isValidBoolean(String sample) {
		switch (sample.toLowerCase()) {
			case "true":
				return true;
			case "false":
				return true;
		}
		return false;
	}
	
}
