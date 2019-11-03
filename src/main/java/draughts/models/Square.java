package draughts.models;

import draughts.types.Color;

public class Square {

    private Piece piece;

    public Square() { }

    public void put(Piece piece) {
        this.piece = piece;
    }

    public Piece remove() {
        Piece pieceAux = this.piece;
        this.piece = null;
        return pieceAux;
    }

    public Piece getPiece() {
        return this.piece;
    }

    public boolean isEmpty() {
        return this.piece == null;
    }

    public Color getColor() {
        if (this.piece == null) {
            return null;
        }
        return this.piece.getColor();
    }
}
