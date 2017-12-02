package main.java.model;

public class InventoryItemFactory {
	
	public static InventoryItemBuilder createInventoryItemBuilder() {
		return new InventoryItemBuilder();
	}
	
	public static class InventoryItemBuilder {
		private String name;
		private int price;
		private String description;
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
		public InventoryItem build() {
			InventoryItem item = new InventoryItem();
			item.setDescription(description);
			item.setName(name);
			item.setPrice(price);
			return item;
		}
	}
}
