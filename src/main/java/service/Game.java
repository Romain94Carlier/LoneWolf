package main.java.service;

import main.java.model.PageOption;
import main.java.model.Player;

public class Game {

	private static Game instance = new Game();
	private PageService pageService;
	private DiceService diceService;
	private final Player player;

	public static Game getInstance() {
		return instance;
	}

	public String getMainDescription() {
		return pageService.getMainDescription();
	}

	private Game() {
		pageService = new PageService();
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

}
