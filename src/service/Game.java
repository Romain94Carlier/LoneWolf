package service;

import javax.faces.bean.ManagedProperty;

import model.Page;
import model.PageOption;
import model.WelcomePage;
import repository.PageRepository;

public class Game {

	private static Game instance = new Game();
	private PageService pageService = new PageService();

	public static Game getInstance() {
		return instance;
	}

	public String getMainDescription() {
		return pageService.getMainDescription();
	}
	
	private Game() {
		
	}

//	public String[] getOptionsAsStrings() {
//		PageOption[] options = currentPage.getOptions();
//		String[] stringOptions = new String[options.length];
//		for(int i = 0; i<options.length; i++) 
//			stringOptions[i] = options[i].toString();
//		return stringOptions;
//	}
	
	public PageOption[] getOptions() {
		return pageService.getOptions();
	}

	public void selectOption(PageOption pageOption) {
		pageService.selectOption(pageOption);
	}
	
}
