package controller;
import javax.faces.bean.ManagedBean;

import model.PageOption;
import service.Game;

@ManagedBean
public class Director {
	
	private Game game = Game.getInstance();
	
	public String direct() {
		return "a";
	}

	public String getMainDescription() {
		return game.getMainDescription();
	}
	
	public PageOption[] getOptions() {
		return game.getOptions();
	}
	
	public String selectOption(PageOption option) {
		game.selectOption(option);
		return "welcome"; // refresh
	}
	
}
