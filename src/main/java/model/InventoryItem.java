package main.java.model;

public class InventoryItem {
	
	private String name;
	private int price;
	private String description;
	private int quantity;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int i) {
		this.quantity = i;
	}
	public String toString() {
		String result = name;
		if(quantity > 0)
			result += " ("+quantity+")";
		return result;
	}
	public String toShopString() {
		String result = name;
		if(price > 0)
			result += " ("+price+")";
		return result;
	}
}
