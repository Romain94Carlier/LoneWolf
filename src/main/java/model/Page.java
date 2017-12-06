package main.java.model;

public /*abstract*/ class Page {

	private int number;
	private String description;
	private Monster[] monsters;
	//	private List<PageOption> options = new ArrayList<>();
	private PageOption[] options;
	private InventoryItem[] itemsFound;
	private InventoryItem[] itemsToBuy;

	public Page(int number, String description, Monster[] monsters, InventoryItem[] itemsFound, InventoryItem[] itemsToBuy, PageOption... options) {
		this.number = number;
		this.description = description;
		this.monsters = monsters;
		this.setItemsFound(itemsFound);
		this.setItemsToBuy(itemsToBuy);
		this.options = options;
	}

	private void setItemsToBuy(InventoryItem[] itemsToBuy2) {
		this.itemsToBuy = itemsToBuy2;
	}

	private void setItemsFound(InventoryItem[] itemsFound2) {
		this.itemsFound = itemsFound2;
	}

	public String getMainDescription() {
		return this.description;
	}

	public Monster[] getMonsters() {
		return this.monsters;
	}

	public PageOption[] getOptions() {
		return this.options;
	}

	public int getNumber() {
		return this.number;
	}

	public InventoryItem[] getItemsFound() {
		return itemsFound;
	}

	public InventoryItem[] getItemsToBuy() {
		return itemsToBuy;
	}
}
