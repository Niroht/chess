package com.toyapps.chess.service.impl;

import com.toyapps.chess.domain.GameState;
import com.toyapps.chess.service.GameStateService;

public class GameStateServiceImpl implements GameStateService {

	@Override
	public GameState newGame() {
		return new GameState();
	}

}
