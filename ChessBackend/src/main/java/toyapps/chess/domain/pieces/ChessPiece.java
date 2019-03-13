package toyapps.chess.domain.pieces;

import lombok.Getter;

import java.awt.*;

public abstract class ChessPiece {
    @Getter
    private Point location;

    protected ChessPiece(int x, int y){
        this.location = new Point(x, y);
    }

    public abstract boolean canMoveToLocation(int x, int y);
}
