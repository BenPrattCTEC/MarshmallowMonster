package marshmallowMonster.controller;

import java.util.Scanner;

import marshmallowMonster.view.GuiController;
import marshmallowMonster.model.Monster;

public class Controller {
	
	public void start() {
		
		// Monster(name, eyeCount, armCount, tentacleAmount, hasBloop)
		Monster[] monsters = { new Monster("Philip", 2, 2, 2, true), new Monster("Bob", 1, 3, 0, true), new Monster() };
		
		interactiveMonsterCreation(monsters[2]);
		
		monsters[0].eat();
		
		for (int i = 0; i < monsters.length; i++) {
			System.out.println(monsters[i].toString());
		}
		System.out.println();
		System.out.println("Number of  Living Monsters: " + Monster.getNumberOfMonsters());
		
	}
	
	private void eatPart(Monster monster, String part, double amount) {
		//valid parts: arm, eye, tentacle, bloop
		
		if (amount <= 0) {
			System.out.println("Error: amount is less than 0");
		} else {
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
					} else {
						System.out.println("The monster Doesnt have a bloop to eat");
						break;
					}
			}
		}
		
	}
	
	private void interactiveMonsterCreation(Monster currentMonster) {
		Scanner inp = new Scanner(System.in);
		
		int eyeCount = 0, armCount = 0;
		double tenticleAmount = 0;
		String name = "";
		boolean hasBloop = false;
		
		boolean isComplete = false;
		
		while (!isComplete) {
			
			try {
				System.out.println("Modifying Monster with ID: " + currentMonster.getID());
				
				System.out.print("Enter Name: ");
				name = inp.nextLine();
				
				System.out.print("Number of Eyes: ");
				eyeCount = inp.nextInt();
				inp.nextLine();
				
				System.out.print("Number of Tenticles: ");
				tenticleAmount = inp.nextDouble();
				inp.nextLine();
				
				System.out.print("Number of Arms: ");
				armCount = inp.nextInt();
				inp.nextLine();
				
				System.out.print("Does it have a Bloop? (true or false): ");
				hasBloop = inp.nextBoolean();
				inp.nextLine();
				
				isComplete = true;
			} catch (Exception e) {
				System.out.println("\nField not entered correctly, Try again\n");
				inp.nextLine();
			}
			
		}
		
		currentMonster.initialize(name, eyeCount, armCount, tenticleAmount, hasBloop);
		
		System.out.println("\n");
		
		inp.close();
	}
}
