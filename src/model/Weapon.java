package model;

public abstract class Weapon extends InventoryItem {
	
	private int damage;
	
	protected Weapon(int damage) {
		this.damage = damage;
	}

	public int getDamage() {
		return damage;
	}

}
