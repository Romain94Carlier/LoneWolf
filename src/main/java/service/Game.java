package main.java.service;

import main.java.model.InventoryItem;
import main.java.model.PageOption;
import main.java.model.Player;

public class Game {

	private static Game instance = new Game();
	private PageService pageService;
	private DiceService diceService;
	private InventoryService inventoryService;
	private final Player player;

	public static Game getInstance() {
		return instance;
	}

	public String getMainDescription() {
		return pageService.getMainDescription();
	}

	private Game() {
		pageService = new PageService();
		inventoryService = new InventoryService();
		diceService = new DiceService();
		int skill = diceService.roll1Dice6Sides() + 6;
		int stamina = diceService.roll1Dice6Sides() + diceService.roll1Dice6Sides() + 12;
		int luck = diceService.roll1Dice6Sides() + 6;
		this.player = new Player(stamina, skill, luck);
	}

	//	public int getSkill() {
	//		return this.skill;
	//	}
	//	
	//	public int getStamina() {
	//		return this.stamina;
	//	}
	//	
	//	public int getLuck() {
	//		return this.luck;
	//	}

	//	public String[] getOptionsAsStrings() {
	//		PageOption[] options = currentPage.getOptions();
	//		String[] stringOptions = new String[options.length];
	//		for(int i = 0; i<options.length; i++) 
	//			stringOptions[i] = options[i].toString();
	//		return stringOptions;
	//	}

	public PageOption[] getOptions() {
		try {
			return pageService.getOptions();
		} catch (NullPointerException npe) {
			instance = new Game();
			return pageService.getOptions();
		}

	}

	public void selectOption(PageOption pageOption) {
		pageService.selectOption(pageOption);
	}

	public int getPageNumber() {
		return pageService.getPageNumber();
	}

	public boolean hasShop() {
		return pageService.hasItemsToBuy();
	}

	public InventoryItem[] getInventoryItems() {
		return inventoryService.getItems();
	}
	
	public InventoryItem[] getItemsToBuy() {
		return pageService.getItemsToBuy();
	}

	public void buyItem(InventoryItem item) {
		inventoryService.buyItem(item);
		pageService.removeItem(item);
	}
	
	public int getCurrentGold() {
		return inventoryService.getGold();
	}

	public Player getPlayer() {
		return this.player;
	}
}
