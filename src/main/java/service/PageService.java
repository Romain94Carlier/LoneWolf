package main.java.service;

import main.java.model.Page;
import main.java.model.PageOption;
import main.java.repository.PageRepository;

public class PageService {

	private Page currentPage;
	private PageRepository pageRepository;
	
	public PageService() {
//		currentPage = new WelcomePage(
//				new PageOption(2, "Take left"), 
//				new PageOption(46, "Go straight"), 
//				new PageOption(123, "Take right"));
		pageRepository = PageRepository.getInstance();
		currentPage = pageRepository.getPageByNumber(1);
	}
	
	public String getMainDescription() {
		return currentPage.getMainDescription();
	}
	
	public PageOption[] getOptions() {
		try {
			return currentPage.getOptions();
		} catch (NullPointerException npe) {
			throw new NullPointerException("Current page: "+currentPage);
		}
	}
	
	public void selectOption(PageOption pageOption) {
		this.currentPage = pageRepository.getPageByNumber(pageOption.getPage());
		if(currentPage == null)
			throw new NullPointerException("Current page: "+currentPage+". You probably tried loading a page that doesn't exist yet.");
	}

	public int getPageNumber() {
		return currentPage.getNumber();
	}
	
//	public void setPageRepository(PageRepository pageRepository) {
//		this.pageRepository = pageRepository;
//	}
}
