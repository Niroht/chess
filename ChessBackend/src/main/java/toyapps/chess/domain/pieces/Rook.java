package toyapps.chess.domain.pieces;

public class Rook extends ChessPiece{
    public Rook(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean canMoveToLocation(int x, int y) {
        boolean movedVertically = Math.abs(x - getLocation().x) > 0;
        boolean movedHorizontally = Math.abs(y - getLocation().y) > 0;

        return movedHorizontallyOrVerticallyButNotBoth(movedVertically, movedHorizontally);
    }

    private boolean movedHorizontallyOrVerticallyButNotBoth(boolean movedVertically, boolean movedHorizontally) {
        return (movedVertically && !movedHorizontally) || (movedHorizontally && !movedVertically);
    }
}
