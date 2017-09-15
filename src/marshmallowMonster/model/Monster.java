package marshmallowMonster.model;

public class Monster {
	
	private int eyeCount, armCount;
	private double tenticleAmount;
	private String name;
	private boolean hasBloop;
	
	public Monster(String name, int eyeCount, int armCount, int tenticleAmount, boolean hasBloop) {
		
		this.armCount = armCount;
		this.eyeCount = eyeCount;
		this.tenticleAmount = tenticleAmount;
		this.name = name;
		this.hasBloop = hasBloop;
		
	}
	
	public int getArmCount() {
		return armCount;
	}
	
	public int getEyeCount() {
		return eyeCount;
	}
	
	public double getTenticleAmount() {
		return tenticleAmount;
	}
	
	public String getName() {
		return name;
	}
	
	public Boolean gethasBloop() {
		return hasBloop;
	}
	
	public String toString() {
		return "Name: " + name + "\n" + "Number of eyes: " + eyeCount + "\n" + "Number of tenticles: " + tenticleAmount
				+ "\n" + "Number of Arms: " + armCount + "\n" + "Bloop state: " + hasBloop + "\n";
	}
	
}
