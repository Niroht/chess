package com.toyapps.chess.domain;

import java.awt.Point;

import lombok.Data;

@Data
public class ChessSquare {
	private Point location;
	
	private SquareColor color;
	
	public ChessSquare(int x, int y, SquareColor color) {
		this.location = new Point(x, y);
		this.color = color;
	}
}
