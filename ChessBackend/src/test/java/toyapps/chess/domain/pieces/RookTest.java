package toyapps.chess.domain.pieces;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class RookTest {
    @Test
    public void canMoveToLocation_horizontal(){
        // arrange
        Rook systemUnderTest = new Rook(1, 1);

        // act
        boolean result = systemUnderTest.canMoveToLocation(8, 1);

        // assert
        assertTrue(result);
    }

    @Test
    public void canMoveToLocation_vertical(){
        // arrange
        Rook systemUnderTest = new Rook(1, 1);

        // act
        boolean result = systemUnderTest.canMoveToLocation(1, 4);

        // assert
        assertTrue(result);
    }

    @Test
    public void canMoveToLocation_cannotMoveDiagonally(){
        // arrange
        Rook systemUnderTest = new Rook(1, 1);

        // act
        boolean result = systemUnderTest.canMoveToLocation(2, 2);

        // assert
        assertFalse(result);
    }

    @Test
    public void canMoveToLocation_cannotMoveInLShape(){
        // arrange
        Rook systemUnderTest = new Rook(1,1);

        // act
        boolean result = systemUnderTest.canMoveToLocation(2, 3);

        // assert
        assertFalse(result);
    }
}
