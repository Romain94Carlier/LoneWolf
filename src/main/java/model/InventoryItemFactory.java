package main.java.model;

public class InventoryItemFactory {
	
	public InventoryItem createInventoryItem(String type) {
		return new PotionOfSkill();
	}
}
