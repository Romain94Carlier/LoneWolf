package model;


public /*abstract*/ class Page {
	
	private String description;

	public Page(String description) {
		this.description = description;
	}
	
	public String getMainDescription() {
		return this.description;
	}

	public PageOption[] getOptions() {
		return null;
	}
}
