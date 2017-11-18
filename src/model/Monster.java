package model;

public class Monster {
	
	private int stamina;
	private int skill;
	private boolean flee;
	
	public Monster(int health, int strength, boolean flee) {
		this.stamina = health;
		this.skill = strength;
		this.flee = flee;
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
	public boolean isFlee() {
		return flee;
	}
//	public void setFlee(boolean flee) {
//		this.flee = flee;
//	}

	public void dealDamage(int i) {
		this.stamina -= i;
	}
	
	public boolean isAlive() {
		return this.stamina > 0;
	}
}
