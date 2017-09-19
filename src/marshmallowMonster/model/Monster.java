package marshmallowMonster.model;

public class Monster {
	
	private int eyeCount, armCount;
	private double tentacleAmount;
	private String name;
	private boolean hasBloop;
	
	private boolean isInitialized;
	private boolean isEaten = false;
	
	private int monsterID;
	
	private static int numberOfMonsters = 0;
	private static int IDAccumulator = 0;
	
	public Monster() {
		isInitialized = false;
		monsterID = numberOfMonsters;
		numberOfMonsters++;
		IDAccumulator++;
	}
	
	public Monster(String name, int eyeCount, int armCount, int tentacleAmount, boolean hasBloop) {
		
		this.armCount = armCount;
		this.eyeCount = eyeCount;
		this.tentacleAmount = tentacleAmount;
		this.name = name;
		this.hasBloop = hasBloop;
		monsterID = IDAccumulator;
		numberOfMonsters++;
		IDAccumulator++;
		isInitialized = true;
		
	}
	
	public void initialize(String name, int eyeCount, int armCount, double tentacleAmount, boolean hasBloop) {
		
		this.armCount = armCount;
		this.eyeCount = eyeCount;
		this.tentacleAmount = tentacleAmount;
		this.name = name;
		this.hasBloop = hasBloop;
		isInitialized = true;
		
	}
	
	public void setArmCount(int count) {
		this.armCount = count;
	}
	
	public void setEyeCount(int count) {
		this.eyeCount = count;
	}
	
	public void setTentacleAmount(double amount) {
		this.tentacleAmount = amount;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setHasBloop(boolean hasBloop) {
		this.hasBloop = hasBloop;
	}
	
	public int getArmCount() {
		return armCount;
	}
	
	public int getEyeCount() {
		return eyeCount;
	}
	
	public double getTentacleAmount() {
		return tentacleAmount;
	}
	
	public String getName() {
		return name;
	}
	
	public Boolean gethasBloop() {
		return hasBloop;
	}
	
	public int getID() {
		return monsterID;
	}
	
	static public int getNumberOfMonsters() {
		return numberOfMonsters;
	}
	
	public void eat() {
		isEaten = true;
		numberOfMonsters--;
	}
	
	public String toString() {
		if (isInitialized) {
			if (!isEaten)
				return "ID: " + monsterID + "\n" + "Name: " + name + "\n" + "Number of eyes: " + eyeCount + "\n"
						+ "Number of tentacles: " + tentacleAmount + "\n" + "Number of Arms: " + armCount + "\n"
						+ "Bloop state: " + hasBloop + "\n";
			else
				return "ID: " + monsterID + "\n" + name + " Has been Eaten" + "\n";
			
		}
		return "ID: " + monsterID + "\n" + "Monster not properly initialized" + "\n";
		
	}
	
}
