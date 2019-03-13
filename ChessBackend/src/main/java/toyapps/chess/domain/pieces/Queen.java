package toyapps.chess.domain.pieces;

public class Queen extends ChessPiece {
    public Queen(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean canMoveToLocation(int x, int y) {
        return false;
    }
}
