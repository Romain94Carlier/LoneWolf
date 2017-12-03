package main.java.controller;
import javax.faces.bean.ManagedBean;

import main.java.model.PageOption;
import main.java.service.Game;

@ManagedBean
public class Director {
	
	private Game game = Game.getInstance();
	
	public String direct() {
		return "a";
	}

	public String getMainDescription() {
		return Game.getInstance().getMainDescription();
	}
	
	public PageOption[] getOptions() {
		return Game.getInstance().getOptions();
	}
	
	public String selectOption(PageOption option) {
		Game.getInstance().selectOption(option);
		return "welcome"; // refresh
	}
	
}