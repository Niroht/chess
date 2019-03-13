package toyapps.chess.domain.pieces;

public class Bishop extends ChessPiece {
    public Bishop(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean canMoveToLocation(int x, int y) {
        return false;
    }
}
