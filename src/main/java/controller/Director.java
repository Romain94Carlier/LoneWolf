package main.java.controller;
import javax.faces.bean.ManagedBean;

import main.java.model.InventoryItem;
import main.java.model.PageOption;
import main.java.service.Game;

@ManagedBean
public class Director {
	
	private Game game = Game.getInstance();
	
	public String direct() {
		return "a";
	}

	public int getPageNumber() {
		return Game.getInstance().getPageNumber();
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
	
	public boolean pageHasAShop() {
		return Game.getInstance().hasShop();
	}
	
	public InventoryItem[] getInventoryItems() {
		return Game.getInstance().getInventoryItems();
	}
	
	public InventoryItem[] getItemsToBuy() {
		return Game.getInstance().getItemsToBuy();
	}
	
	public String buyItem(InventoryItem item) {
		Game.getInstance().buyItem(item);
		return "welcome"; // refresh
	}
	
	public int getCurrentGold() {
		return Game.getInstance().getCurrentGold();
	}
	
	public boolean pageHasMonster() {
		return Game.getInstance().hasMonsterToFight();
	}
	
	public void selectFight() {
		
	}
	
	public boolean isFleeingAllowed() {
		if(!pageHasMonster())
			return false;
		return Game.getInstance().isFleeingAllowed();
	}
}
