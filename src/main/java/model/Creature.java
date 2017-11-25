package main.java.model;

public abstract class Creature {
	
	private int stamina;
	private int skill;
	
	protected Creature(int stamina, int skill) {
		this.stamina = stamina;
		this.skill = skill;
	}
	
	public int getStamina() {
		return stamina;
	}
//	public void setHealth(int health) {
//		this.health = health;
//	}
	public int getSkill() {
		return skill;
	}
//	public void setStrength(int strength) {
//		this.strength = strength;
//	}


	public void dealDamage(int i) {
		this.stamina -= i;
	}
	
	public boolean isAlive() {
		return this.stamina > 0;
	}
}
