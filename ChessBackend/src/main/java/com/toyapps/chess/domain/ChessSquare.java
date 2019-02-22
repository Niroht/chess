package com.toyapps.chess.domain;

import com.toyapps.chess.domain.pieces.ChessPiece;
import lombok.Getter;

import java.awt.*;

public class ChessSquare {
    @Getter
	private Point location;

    @Getter
	private SquareColor color;

    @Getter
	private ChessPiece piece;

    public ChessSquare(int x, int y, SquareColor color, ChessPiece piece) {
        this.location = new Point(x, y);
        this.color = color;
        this.piece = piece;
    }
}
