package main.java.service;

import main.java.model.InventoryItem;

public class InventoryItemResolver {
	
	public void applyItem(InventoryItem item) {
		switch (item.getName().toLowerCase()) {
		case "potion d'endurance":
			Game.getInstance().getPlayer().recoverStamina(999);
		}
	}
}
