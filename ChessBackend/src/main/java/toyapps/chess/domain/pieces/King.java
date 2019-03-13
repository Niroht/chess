package toyapps.chess.domain.pieces;

public class King extends ChessPiece {
    public King(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean canMoveToLocation(int x, int y) {
        return false;
    }
}
