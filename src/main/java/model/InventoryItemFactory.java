package main.java.model;

import main.java.model.InventoryItemFactory.InventoryItemBuilder;

public class InventoryItemFactory {
	
	public static InventoryItemBuilder createInventoryItemBuilder() {
		return new InventoryItemBuilder();
	}
	
	public static class InventoryItemBuilder {
		private String name;
		private int price;
		private String description;
		private int quantity;
		public InventoryItemBuilder name(String name) {
			this.name = name;
			return this;
		}
		public InventoryItemBuilder description(String description) {
			this.description = description;
			return this;
		}
		public InventoryItemBuilder price(int price) {
			this.price = price;
			return this;
		}
		public InventoryItemBuilder quantity(int quantity) {
			this.quantity = quantity;
			return null;
		}
		public InventoryItem build() {
			InventoryItem item = new InventoryItem();
			item.setDescription(description);
			item.setName(name);
			item.setPrice(price);
			item.setQuantity(quantity);
			return item;
		}
		
	}
}
