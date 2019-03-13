package toyapps.chess.domain.pieces;

public class Pawn extends ChessPiece {
    public Pawn(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean canMoveToLocation(int x, int y) {
        return false;
    }
}
