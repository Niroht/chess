package toyapps.chess.domain.pieces;

public class Knight extends ChessPiece {
    public Knight(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean canMoveToLocation(int x, int y) {
        return false;
    }
}
