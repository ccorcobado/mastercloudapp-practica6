package draughts.models;

import draughts.types.Color;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class PieceTest {
    
    @Test
    public void givenPieceWhenIsAdvancedThenTrue() {
        assertTrue(new Piece(Color.WHITE).isAdvanced(new Coordinate(5,0), new Coordinate(4,1)));
        assertTrue(new Piece(Color.BLACK).isAdvanced(new Coordinate(2,1), new Coordinate(3,2)));
    }

    @Test
    public void givenPieceWhenNotIsAdvancedThenFalse() {
        assertFalse(new Piece(Color.WHITE).isAdvanced(new Coordinate(5,0), new Coordinate(6,1)));
        assertFalse(new Piece(Color.BLACK).isAdvanced(new Coordinate(2,1), new Coordinate(1,2)));
    }
}