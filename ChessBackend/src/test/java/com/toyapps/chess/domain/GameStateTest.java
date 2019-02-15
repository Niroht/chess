package com.toyapps.chess.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class GameStateTest {
	@Test
	public void defaultConstructor_eightRanks() {
		// arrange
		
		// act
		GameState gameState = new GameState();
		
		// assert
		assertEquals(8, gameState.getSquares().stream().filter(x -> x.getLocation().y == 1).count());
	}
	
	@Test
	public void defaultConstructor_eightFiles() {
		// arrange
		
		// act
		GameState gameState = new GameState();
		
		// assert
		assertEquals(8, gameState.getSquares().stream().filter(x -> x.getLocation().x == 1).count());
	}
	
	@Test
	public void defaultConstructor_exactlySixtyFourSquares() {
		// arrange
		
		// act
		GameState gameState = new GameState();
		
		// assert
		assertEquals(64, gameState.getSquares().size());
	}
	
	@Test
	public void defaultConstructor_noSquaresOutsideBounds() {
		// arrange
		
		// act
		GameState gameState = new GameState();
		
		// assert
		assertTrue(gameState
				.getSquares()
				.stream()
				.noneMatch(x -> x.getLocation().x > 8 || x.getLocation().x < 1 || x.getLocation().y > 8 || x.getLocation().y < 1));
	}
	
	@Test
	@Parameters({
		"8, 1, LIGHT",
		"8, 8, DARK",
		"2, 8, DARK",
		"4, 3, LIGHT"
	})
	public void defaultConstructor_squaresColoredCorrectly(int squareX, int squareY, SquareColor expected) {
		// arrange
		
		// act
		GameState gameState = new GameState();
		ChessSquare bottomRightSquare = gameState.getSquares().stream().filter(x -> x.getLocation().x == squareX && x.getLocation().y == squareY).findFirst().get();
		
		// assert
		assertEquals(expected, bottomRightSquare.getColor());
	}
}
