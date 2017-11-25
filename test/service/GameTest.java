package service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.java.service.Game;

public class GameTest {
	
	private static Game game = Game.getInstance();
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetInstance() {
		Game other = Game.getInstance();
		assertEquals(game, other);
		assertNotNull(other);
	}

	@Test
	public void testGetMainDescription() {
//		assertEquals(game.getMainDescription(), "Welcome Lone Wolf. This is the main description of the game. Make a choice.");
		game.selectOption(game.getOptions()[0]);
//		assertEquals(game.getMainDescription(), "Welcome to page 2.");
	}

	@Test
	public void testGetOptions() {
//		fail("Not yet implemented");
	}

}
