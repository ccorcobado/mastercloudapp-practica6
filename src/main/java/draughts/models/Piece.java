package draughts.models;

import draughts.types.Color;

public class Piece {

    private final Color color;

    public Piece(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    public boolean isBlack() {
        return this.color == Color.BLACK;
    }

    public boolean isAdvanced(Coordinate origin, Coordinate target) {
        int difference = origin.getRow() - target.getRow();
        if (this.color == Color.WHITE) {
            return difference > 0;
        }
        return difference < 0;
    }
}
