package main.java.model;

public abstract class Creature {
	
	private int stamina;
	private int skill;
	private String name;
	private String description;
	
	protected Creature(String name, String description, int stamina, int skill) {
		this.setName(name);
		this.setDescription(description);
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

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	private void setDescription(String description) {
		this.description = description;
	}
}
