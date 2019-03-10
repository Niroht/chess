package toyapps.chess.service.impl;

import toyapps.chess.domain.GameState;
import toyapps.chess.service.GameStateService;

public class GameStateServiceImpl implements GameStateService {

	@Override
	public GameState newGame() {
		return new GameState();
	}

}
