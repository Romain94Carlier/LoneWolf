package service;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import model.Page;
import model.PageOption;
import model.WelcomePage;
import repository.PageRepository;

@ManagedBean
public class PageService {

	private Page currentPage;
	@ManagedProperty(value="#{pageRepository}")
	private PageRepository pageRepository;
	
	public PageService() {
		currentPage = new WelcomePage(
				new PageOption(2, "Take left"), 
				new PageOption(46, "Go straight"), 
				new PageOption(123, "Take right"));
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
