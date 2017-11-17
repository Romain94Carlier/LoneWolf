package model;

public class Monster {
	
	private int health;
	private int strength;
	private boolean flee;
	
	public Monster(int health, int strength, boolean flee) {
		this.health = health;
		this.strength = strength;
		this.flee = flee;
	}
	
	public int getHealth() {
		return health;
	}
//	public void setHealth(int health) {
//		this.health = health;
//	}
	public int getStrength() {
		return strength;
	}
//	public void setStrength(int strength) {
//		this.strength = strength;
//	}
	public boolean isFlee() {
		return flee;
	}
//	public void setFlee(boolean flee) {
//		this.flee = flee;
//	}
	
	
}
