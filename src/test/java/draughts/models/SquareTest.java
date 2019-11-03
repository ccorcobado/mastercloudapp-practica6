package draughts.models;

import draughts.types.Color;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class SquareTest {
    
    private Square square;
    
    @Before
    public void before() {
        this.square = new Square();
        this.square.put(new Piece(Color.BLACK));
    }
    
    @Test
    public void givenSquareWhenIsEmptyThenTrue() {
        Square emptySquare = new Square();
        assertTrue(emptySquare.isEmpty());
    }

    @Test
    public void givenSquareWhenIsEmpltyThenGetColorNull() {
        Square emptySquare = new Square();
        assertNull(emptySquare.getColor());
    }
    
    @Test
    public void givenSquareWithPieceWhenIsEmptyThenFalse() {
        assertFalse(this.square.isEmpty());
    }

    @Test
    public void givenSquareWithPieceWhenGetColorThenColorReturned() {
        assertEquals(Color.BLACK, this.square.getColor());
    }

    @Test
    public void givenSquareWithPieceWhenRemoveThenIsEmpty() {
        this.square.remove();
        assertTrue(this.square.isEmpty());
    }

    @Test
    public void givenSquareWithPieceWhenPutNullThenIsEmpty() {
        this.square.put(null);
        assertTrue(this.square.isEmpty());
    }
}
