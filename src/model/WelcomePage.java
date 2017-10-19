package model;

public class WelcomePage extends Page {
	
	private final String mainDescription = "Welcome Lone Wolf. This is the main description of the game. Make a choice.";
	private final PageOption[] options;
	
	public String getMainDescription() {
		return mainDescription;
	}
	
	public WelcomePage(PageOption... pages) {
//		this.options = new PageOption[pages.length];
//		for(int i = 0; i<pages.length; i++) 
//			this.options[i] = new PageOption(pages[i]);
		this.options = pages;
	}
	
	public PageOption[] getOptions() {
		return this.options;
	}
//	public void setMainDescription(String mainDescription) {
//		this.mainDescription = mainDescription;
//	}
	
}
