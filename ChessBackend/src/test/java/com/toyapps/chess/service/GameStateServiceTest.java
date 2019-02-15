package com.toyapps.chess.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.toyapps.chess.domain.GameState;
import com.toyapps.chess.service.impl.GameStateServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class GameStateServiceTest {
	@InjectMocks
	private GameStateServiceImpl sut;
	
	@Test
	public void newGame_returnsGameState() {
		// arrange
		
		// act
		GameState result = sut.newGame();
		
		// assert
		assertNotNull(result);
	}
}
