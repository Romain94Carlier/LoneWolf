package main.java.service;

import java.util.Random;

public class DiceService {
	
	private Random random = new Random();
	
	public int roll1Dice6Sides() {
		return random.nextInt(6) + 1;
	}
	
	public int roll() {
		return roll1Dice6Sides();
	}
}
