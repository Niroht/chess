package com.toyapps.chess.domain;

import com.toyapps.chess.domain.pieces.ChessPiece;
import lombok.Getter;

public class ChessSquare {
    private static int ASCII_CODE_A = 65;

    @Getter
	private String location;

    @Getter
	private SquareColor color;

    @Getter
	private ChessPiece piece;

    public ChessSquare(int x, int y, SquareColor color, ChessPiece piece) {
        this.location = convertXYCoordinatesToChessCoordinateNotation(x, y);

        this.color = color;
        this.piece = piece;
    }

    public char getRank(){
        return this.location.charAt(1);
    }

    public char getFile(){
        return this.location.charAt(0);
    }

    private String convertXYCoordinatesToChessCoordinateNotation(int x, int y) {
        return Character.toString((char)(x + ASCII_CODE_A - 1)) + y;
    }
}
