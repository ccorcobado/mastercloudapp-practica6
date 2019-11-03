package draughts.models;

import draughts.types.Color;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class BoardTest {
    
    private Board board;
    
    public BoardTest() {}
    
    @Before
    public void before() {
        this.board = new Board();
    }
    
    private void assertPiecesAreInCorrectPosition(int init, int end, Color colorToCheck) {
        for (int i = init; i < end; i++) {
            for (int j = 0; j < Board.DIMENSION; j++) {
                Coordinate coordinate = new Coordinate(i,j);
                Color color = this.board.getColor(coordinate);
                if (coordinate.isBlack()){
                    assertEquals(colorToCheck, color);
                } else {
                    assertNull(color);
                }
            }
        }
    }
    
    @Test
    public void givenBoardWhenNewBoardThenAllPiecesAreInCorrectPosition() {
        this.assertPiecesAreInCorrectPosition(
                topPointBlackPieces(0), downPointBlackPieces(3), Color.BLACK);
        this.assertPiecesAreInCorrectPosition(
                topPointWhitePieces(5), Board.DIMENSION, Color.WHITE);
    }
    
    @Test
    public void givenBoardWhenMoveFromNonEmptyToEmptyThenOk() {
        Coordinate origin = new Coordinate(2, 1);
        Coordinate target = new Coordinate(4, 1);
        Piece piece = this.board.getPiece(origin);
        this.board.move(origin, target);
        assertTrue(this.board.isEmpty(origin));
        assertEquals(piece, this.board.getPiece(target));
    }

    @Test
    public void givenBoardWhenMoveFromNonEmptyToNonEmptyThenOk() {
        Coordinate origin = new Coordinate(2, 1);
        Coordinate target = new Coordinate(0, 1);
        Piece piece = this.board.getPiece(origin);
        this.board.move(origin, target);
        assertTrue(this.board.isEmpty(origin));
        assertEquals(piece, this.board.getPiece(target));
    }

    @Test(expected = NullPointerException.class)
    public void givenBoardWhenMoveFromNullPositionToNotNullPositionThenException() {
        Coordinate origin = null;
        Coordinate target = new Coordinate(7, 0);
        this.board.move(origin, target);
    }

    @Test(expected = NullPointerException.class)
    public void givenBoardWhenMoveFromNotNullPositionToNullPositionThenException() {
        Coordinate origin = new Coordinate(7, 0);
        Coordinate target = null;
        this.board.move(origin, target);
    }
    
    @Test
    public void givenBoardWhenRemoveNonEmptyThenIsEmpty() {
        Coordinate coordinate = new Coordinate(5, 0);
        this.board.remove(coordinate);
        assertTrue(this.board.isEmpty(coordinate));
    }

    @Test(expected = AssertionError.class)
    public void givenBoardWhenRemoveNullThenException() {
        this.board.remove(null);
    }
    
    private static int topPointBlackPieces(int topPoint) {
        return topPoint;
    }
    
    private static int downPointBlackPieces(int downPoint) {
        return downPoint;
    }
    
    private static int topPointWhitePieces(int topPoint) {
        return topPoint;
    }
}