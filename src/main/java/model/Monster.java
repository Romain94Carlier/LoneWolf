package main.java.model;

public class Monster extends Creature {
	
	private boolean flee;
	
	public Monster(String name, String description, int health, int strength, boolean flee) {
		super(name, description, health, strength);
		this.flee = flee;
	}
	
	public boolean isFlee() {
		return flee;
	}
//	public void setFlee(boolean flee) {
//		this.flee = flee;
//	}
}
