package service;

import model.Monster;
import model.Player;

public class FightService {
	
	private DiceService dice = new DiceService();
	
	public FightService() {
//		currentPage = new WelcomePage(
//				new PageOption(2, "Take left"), 
//				new PageOption(46, "Go straight"), 
//				new PageOption(123, "Take right"));
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
}
