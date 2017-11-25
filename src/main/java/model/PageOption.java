package main.java.model;

public class PageOption {
	
	private final int page;
	private final String description;
	
	public PageOption(int page, String description) {
		this.page = page;
		this.description = description;
	}
	
	public int getPage() {
		return page;
	}

	public String getDescription() {
		return description;
	}
	
//	public String toString() {
//		return Integer.toString(page);
//	}
}
