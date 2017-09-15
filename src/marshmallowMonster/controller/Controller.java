package marshmallowMonster.controller;

import marshmallowMonster.model.Monster;

public class Controller {
	
	public void start() {
		
		//Monster(name, eyeCount, armCount, tenticleAmount, hasBloop)
		Monster[] monsters = {
			new Monster("Philip", 2, 2, 4, true),
			new Monster("Bob", 1, 3, 0, true)
		};
		
		for (int i = 0; i < monsters.length; i++) {
			System.out.println(monsters[i].toString());
		}
		System.out.println("Number of Monsters: " + Monster.getNumberOfMonsters());
	}
}
