package service;

import model.Page;
import model.PageOption;
import repository.PageRepository;

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
		return currentPage.getOptions();
	}
	
	public void selectOption(PageOption pageOption) {
		this.currentPage = pageRepository.getPageByNumber(pageOption.getPage());
	}
	
	public void setPageRepository(PageRepository pageRepository) {
		this.pageRepository = pageRepository;
	}
}
