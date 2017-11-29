package main.java.model;

public /*abstract*/ class Page {
	
	private String description;
	private Monster[] monsters;
//	private List<PageOption> options = new ArrayList<>();
	private PageOption[] options;

	public Page(String description, Monster[] monsters, PageOption... options) {
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
}
