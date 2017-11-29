package main.java.model;

public class Player extends Creature {

	private int luck;
	private final int skillMax;
	private final int staminaMax;
	private final int luckMax;
	
	public Player(int stamina, int skill, int luck) {
		super("Player", "You are the hero of this story", stamina, skill);
		this.luck = luck;
		this.skillMax = skill;
		this.staminaMax = stamina;
		this.luckMax = luck;
	}

}
