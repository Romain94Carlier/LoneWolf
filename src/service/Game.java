package service;

import javax.faces.bean.ManagedProperty;

import model.Page;
import model.PageOption;
import model.WelcomePage;
import repository.PageRepository;

public class Game {

	private static Game instance = new Game();
	private Page currentPage;
	@ManagedProperty(value="#{pageRepository}")
	private PageRepository pageRepo;
	
	public static Game getInstance() {
		return instance;
	}

	public String getMainDescription() {
		return currentPage.getMainDescription();
	}
	
	private Game() {
		currentPage = new WelcomePage(
				new PageOption(2, "Take left"), 
				new PageOption(46, "Go straight"), 
				new PageOption(123, "Take right"));
	}

//	public String[] getOptionsAsStrings() {
//		PageOption[] options = currentPage.getOptions();
//		String[] stringOptions = new String[options.length];
//		for(int i = 0; i<options.length; i++) 
//			stringOptions[i] = options[i].toString();
//		return stringOptions;
//	}
	
	public PageOption[] getOptions() {
		return currentPage.getOptions();
	}

	public void selectOption(PageOption pageOption) {
		this.currentPage = pageRepo.getPageByNumber(pageOption.getPage());
	}
	
}
