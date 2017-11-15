package model;

public class Weapon extends InventoryItem {
	
	private int damage;
	
	public Weapon(String name, int damage) { //protected if abstract
		this.damage = damage;
	}

	public int getDamage() {
		return damage;
	}

}
