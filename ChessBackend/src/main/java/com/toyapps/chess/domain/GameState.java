package com.toyapps.chess.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class GameState {
	@Getter
	private List<ChessSquare> squares;
	
	public GameState() {
		setupBoard();
	}
	
	private void setupBoard() {
		this.squares = new ArrayList<>();
		
		for (int y = 1; y <= 8; y++) {
			for (int x = 1; x <= 8; x++) {
				SquareColor color = (x + y) % 2 == 0 ? SquareColor.DARK : SquareColor.LIGHT;
				
				this.squares.add(new ChessSquare(x, y, color));
			}	
		}
	}
}
