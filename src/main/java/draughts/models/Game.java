package draughts.models;

import draughts.types.Color;
import draughts.types.Error;

public class Game {

    private Board board;
    private Turn turn;

    public Game() {
        this.clear();
    }

    public Error move(Coordinate origin, Coordinate target) {
        if (!origin.isValid() || !target.isValid()) {
            return Error.OUT_COORDINATE;
        }
        if (this.board.isEmpty(origin)) {
            return Error.EMPTY_ORIGIN;
        }
        Color color = this.board.getColor(origin);
        if (!this.turn.isColor(color)) {
            return Error.OPPOSITE_PIECE;
        }
        if (!origin.isDiagonal(target)) {
            return Error.NOT_DIAGONAL;
        }
        Piece piece = this.board.getPiece(origin);
        if (!piece.isAdvanced(origin, target)) {
            return Error.NOT_ADVANCED;
        }
        if (origin.diagonalDistance(target) >= 3) {
            return Error.BAD_DISTANCE;
        }
        if (!this.board.isEmpty(target)) {
            return Error.NOT_EMPTY_TARGET;
        }
        if (origin.diagonalDistance(target) == 2) {
            Coordinate between = origin.betweenDiagonal(target);
            if (this.board.getPiece(between) == null) {
                return Error.EATING_EMPTY;
            }
            this.board.remove(between);
        }
        this.board.move(origin, target);
        this.turn.change();
        
        return null;
    }

    public Color getColor(Coordinate coordinate) {
        return this.board.getColor(coordinate);
    }
    
    public Turn getTurn() {
        return this.turn;
    }
    
    public Board getBoard() {
        return this.board;
    }

    public boolean isFinished() {
        return this.board.isEmpty(this.turn.getColor());
    }
    
    public void clear() {
        this.board = new Board();
        this.turn = new Turn();
    }
    
    @Override
    public String toString() {
        return this.board + "\n" + this.turn;
    }
}