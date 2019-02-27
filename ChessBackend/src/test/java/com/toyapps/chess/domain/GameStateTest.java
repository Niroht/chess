package com.toyapps.chess.domain;

import com.toyapps.chess.domain.pieces.*;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class GameStateTest {
	@Test
	public void defaultConstructor_eightRanks() {
		// arrange
		
		// act
		GameState gameState = new GameState();

		// assert
		assertEquals(8, gameState.getSquares().entrySet().stream().filter(x -> x.getValue().getRank() == '1').count());
	}

	@Test
	public void defaultConstructor_eightFiles() {
		// arrange
		
		// act
		GameState gameState = new GameState();
		
		// assert
		assertEquals(8, gameState.getSquares().entrySet().stream().filter(x -> x.getValue().getFile() == 'A').count());
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
                .entrySet()
				.stream()
                .map(x -> x.getValue())
				.noneMatch(x -> x.getFile() > 'H' ||
                        x.getFile() < 'A' ||
                        x.getRank() > '8' ||
                        x.getRank() < '1'));
	}
	
	@Test
	@Parameters({
		"H1, LIGHT",
		"H8, DARK",
		"B8, DARK",
		"D3, LIGHT"
	})
	public void defaultConstructor_squaresColoredCorrectly(String location, SquareColor expected) {
		// arrange
        GameState systemUnderTest = new GameState();
		
		// act
		ChessSquare result = systemUnderTest.getSquare(location);
		
		// assert
		assertEquals(expected, result.getColor());
	}

	@Test
    public void defaultConstructor_startsWith32Pieces(){
	    // arrange

        // act
        GameState gameState = new GameState();

        // assert
        assertEquals(32, gameState.getPieces().size());
    }

    @Test
    public void defaultConstructor_secondRowIsOnlyPawns(){
	    // arrange

        // act
        GameState gameState = new GameState();

        // assert
        assertTrue(gameState.getPieces().stream().filter(x -> x.getLocation().y == 2).allMatch(x -> x instanceof Pawn));
    }

    @Test
    public void defaultConstructor_seventhRowIsOnlyPawns(){
        // arrange

        // act
        GameState gameState = new GameState();

        // assert
        assertTrue(gameState.getPieces().stream().filter(x -> x.getLocation().y == 7).allMatch(x -> x instanceof Pawn));
    }

    @Test
    public void defaultConstructor_fourRooks(){
        // arrange

        // act
        GameState gameState = new GameState();

        // assert
        assertEquals(4, gameState.getPieces().stream().filter(x -> x instanceof Rook).count());
    }

    @Test
    public void defaultConstructor_rooksInFourCorners(){
	    // arrange
        List<Point> rookLocations = Arrays.asList(
                new Point(1, 1),
                new Point(8, 1),
                new Point(1, 8),
                new Point(8, 8)
        );

        // act
        GameState gameState = new GameState();
        Stream<ChessPiece> cornerPieces = gameState
                .getPieces()
                .stream()
                .filter(x -> rookLocations.stream().anyMatch(location -> location.equals(x.getLocation())));

        // assert
        assertTrue(cornerPieces.allMatch(x -> x instanceof Rook));
    }

    @Test
    public void defaultConstructor_fourKnights(){
        // arrange

        // act
        GameState gameState = new GameState();

        // assert
        assertEquals(4, gameState.getPieces().stream().filter(x -> x instanceof Rook).count());
    }

    @Test
    public void defaultConstructor_knightsInCorrectLocations(){
        // arrange
        List<Point> knightLocations = Arrays.asList(
                new Point(2, 1),
                new Point(7, 1),
                new Point(2, 8),
                new Point(7, 8)
        );

        // act
        GameState gameState = new GameState();
        Stream<ChessPiece> cornerPieces = gameState
                .getPieces()
                .stream()
                .filter(x -> knightLocations.stream().anyMatch(location -> location.equals(x.getLocation())));

        // assert
        assertTrue(cornerPieces.allMatch(x -> x instanceof Knight));
    }

    @Test
    public void defaultConstructor_fourBishops(){
        // arrange

        // act
        GameState gameState = new GameState();

        // assert
        assertEquals(4, gameState.getPieces().stream().filter(x -> x instanceof Bishop).count());
    }

    @Test
    public void defaultConstructor_bishopsInCorrectLocations(){
        // arrange
        List<Point> bishopLocations = Arrays.asList(
                new Point(3, 1),
                new Point(6, 1),
                new Point(3, 8),
                new Point(6, 8)
        );

        // act
        GameState gameState = new GameState();
        Stream<ChessPiece> cornerPieces = gameState
                .getPieces()
                .stream()
                .filter(x -> bishopLocations.stream().anyMatch(location -> location.equals(x.getLocation())));

        // assert
        assertTrue(cornerPieces.allMatch(x -> x instanceof Bishop));
    }

    @Test
    public void defaultConstructor_twoQueens(){
        // arrange

        // act
        GameState gameState = new GameState();

        // assert
        assertEquals(2, gameState.getPieces().stream().filter(x -> x instanceof Queen).count());
    }

    @Test
    public void defaultConstructor_queensInCorrectLocations(){
        // arrange
        List<Point> queenLocations = Arrays.asList(
                new Point(4, 1),
                new Point(4, 8)
        );

        // act
        GameState gameState = new GameState();
        Stream<ChessPiece> cornerPieces = gameState
                .getPieces()
                .stream()
                .filter(x -> queenLocations.stream().anyMatch(location -> location.equals(x.getLocation())));

        // assert
        assertTrue(cornerPieces.allMatch(x -> x instanceof Queen));
    }

    @Test
    public void defaultConstructor_twoKings(){
        // arrange

        // act
        GameState gameState = new GameState();

        // assert
        assertEquals(2, gameState.getPieces().stream().filter(x -> x instanceof King).count());
    }

    @Test
    public void defaultConstructor_kingsInCorrectLocations(){
        // arrange
        List<Point> kingLocations = Arrays.asList(
                new Point(5, 1),
                new Point(5, 8)
        );

        // act
        GameState gameState = new GameState();
        Stream<ChessPiece> cornerPieces = gameState
                .getPieces()
                .stream()
                .filter(x -> kingLocations.stream().anyMatch(location -> location.equals(x.getLocation())));

        // assert
        assertTrue(cornerPieces.allMatch(x -> x instanceof King));
    }

    @Test
    public void getSquare_returnsExistingSquare(){
	    // arrange
        GameState systemUnderTest = new GameState();

        // act
        ChessSquare result = systemUnderTest.getSquare("A1");

        // assert
        assertNotNull(result);
    }
}
