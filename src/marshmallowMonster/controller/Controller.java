package marshmallowMonster.controller;

import marshmallowMonster.model.Monster;

public class Controller {
	
	public void start() {
		
		//Monster(name, eyeCount, armCount, tenticleAmount, hasBloop)
		Monster[] monsters = {
			new Monster("Philip", 2, 2, 2, true),
			new Monster("Bob", 1, 3, 0, true),
		};
		
		monsters[0].eat();
		
		for (int i = 0; i < monsters.length; i++) {
			System.out.println(monsters[i].toString());
		}
		System.out.println();
		System.out.println("Number of  Living Monsters: " + Monster.getNumberOfMonsters());
	}
}
