package com.toyapps.chess.domain;

import com.toyapps.chess.domain.pieces.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameState {
	@Getter
	private List<ChessSquare> squares;

	public GameState() {
	    setupBoard();
	}

	public List<ChessPiece> getPieces(){
	    return this.squares.stream().filter(x -> x.getPiece() != null).map(x -> x.getPiece()).collect(Collectors.toList());
    }
	
	private void setupBoard() {
		this.squares = new ArrayList<>();
		
		for (int y = 1; y <= 8; y++) {
			for (int x = 1; x <= 8; x++) {
                addSquare(y, x);
            }
		}
	}

    private ChessPiece addPiece(int x, int y) {
        /** TJ - Not sure I'm totally happy with this implementation (vs maybe a map), but it does the trick
         * I've also considered using a Location <--> Piece map but that doesn't feel great either
         */

	    if (y > 2 && y < 7){
	        return null;
        }

	    if (isPawnFile(y)){
            return new Pawn(x ,y);
        } else if (isRookRank(x)){
	        return new Rook(x, y);
        } else if (isKnightRank(x)){
	        return new Knight(x, y);
        } else if (isBishopRank(x)){
	        return new Bishop(x, y);
        } else if (isQueenRank(x)){
	        return new Queen(x, y);
        } else if (isKingRank(x)){
	        return new King(x, y);
        }

        return null;
    }

    private boolean isKnightRank(int rank){
	    return rank == 2 || rank == 7;
    }

    private boolean isRookRank(int rank) {
        return rank == 1 || rank == 8;
    }

    private boolean isBishopRank(int rank){
	    return rank == 3 || rank == 6;
    }

    private boolean isQueenRank(int rank){
	    return rank == 4;
    }

    private boolean isKingRank(int rank){
	    return rank == 5;
    }

    private boolean isPawnFile(int file) {
        return file == 2 || file == 7;
    }

    private void addSquare(int y, int x) {
        SquareColor color = (x + y) % 2 == 0 ? SquareColor.DARK : SquareColor.LIGHT;
        ChessPiece piece = addPiece(x, y);

        this.squares.add(new ChessSquare(x, y, color, piece));
    }
}
