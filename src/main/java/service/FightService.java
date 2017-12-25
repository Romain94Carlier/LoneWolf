package main.java.service;

import main.java.model.Monster;
import main.java.model.Player;

public class FightService {
	
	private DiceService dice = new DiceService();
	private Monster[] monsters;
	private Player player;
	private boolean hasFled = false;
	private boolean hasStarted = true;
	
	public FightService(Monster[] monsters, Player player) {
//		currentPage = new WelcomePage(
//				new PageOption(2, "Take left"), 
//				new PageOption(46, "Go straight"), 
//				new PageOption(123, "Take right"));
		this.monsters = monsters;
		this.player = player;
	}
	
	public void playFight(Player player, Monster monster) {
		playRound(player, monster);
	}
	
	private void playRound(Player player, Monster monster) {
		int monsterAttackStrength = dice.roll() + dice.roll() + monster.getSkill();
		int playerAttackStrength = dice.roll() + dice.roll() + player.getSkill();
		if(playerAttackStrength > monsterAttackStrength)
			monster.dealDamage(2); // chance?
		if(playerAttackStrength < monsterAttackStrength)
			player.dealDamage(2); // chance?
	}
	
	public void flee(Player player, Monster monster) {
		player.dealDamage(2);
	}
	
	public boolean tryYourLuck(Player player) {
		int roll = dice.roll() + dice.roll();
		boolean result = roll >= player.getSkill(); 	//TODO
		//player.useLuck();
		return result;
	}

	public boolean isMonsterAlive() {
		for(Monster monster : monsters) {
			if(monster.isAlive())
				return true;
		}
		return false;
	}
	
	public boolean isFightOver() {
		return hasFled || isFleeingAllowed();
	}

	public boolean isFleeingAllowed() {
		for(Monster monster : monsters) {
			if(!monster.isFlee())
				return false;
		}
		return true;
	}

	public void playRound() {
		playRound(player, monsters[0]);	// TODO: many monsters?
	}

	public void flee() throws IllegalAccessException {
		if(!isFleeingAllowed())
			throw new IllegalAccessException("Fleeing isn't allowed on this page!");
		player.dealDamage(2);
		this.hasFled  = true;
	}

	public boolean fightIsOngoing() {
		if(isFightOver())
			return false;
		return this.hasStarted ;
	}
}
