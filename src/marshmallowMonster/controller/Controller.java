package marshmallowMonster.controller;

import marshmallowMonster.model.Monster;

public class Controller {
	
	public void start() {
	
		Monster monsterPhilip = new Monster("Philip", 2, 2, 4, true);
		
		System.out.println(monsterPhilip.toString());
		
	}
	
}
