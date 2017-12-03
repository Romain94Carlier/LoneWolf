package main.java.model;

public /*abstract*/ class Page {
	
	private int number;
	private String description;
	private Monster[] monsters;
//	private List<PageOption> options = new ArrayList<>();
	private PageOption[] options;

	public Page(int number, String description, Monster[] monsters, PageOption... options) {
		this.number = number;
		this.description = description;
		this.monsters = monsters;
		this.options = options;
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
}
