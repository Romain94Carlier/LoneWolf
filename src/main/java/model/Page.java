package main.java.model;

import java.util.ArrayList;
import java.util.List;

public /*abstract*/ class Page {
	
	private String description;
//	private List<PageOption> options = new ArrayList<>();
	private PageOption[] options;

	public Page(String description, PageOption... options) {
		this.description = description;
		this.options = options;
	}
	
	public String getMainDescription() {
		return this.description;
	}

	public PageOption[] getOptions() {
		return this.options;
	}
}
