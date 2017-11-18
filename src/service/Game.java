package service;

import model.PageOption;

public class Game {

	private static Game instance = new Game();
	private PageService pageService = new PageService();
	private DiceService diceService = new DiceService();
	private int skill;
	private int stamina;
	private int luck;
	private final int skillMax;
	private final int staminaMax;
	private final int luckMax;

	public static Game getInstance() {
		return instance;
	}

	public String getMainDescription() {
		return pageService.getMainDescription();
	}
	
	private Game() {
		this.skill = diceService.roll1Dice6Sides() + 6;
		this.stamina = diceService.roll1Dice6Sides() + diceService.roll1Dice6Sides() + 12;
		this.luck = diceService.roll1Dice6Sides() + 6;
		this.skillMax = skill;
		this.staminaMax = stamina;
		this.luckMax = luck;
	}
	
	public int getSkill() {
		return this.skill;
	}
	
	public int getStamina() {
		return this.stamina;
	}
	
	public int getLuck() {
		return this.luck;
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
