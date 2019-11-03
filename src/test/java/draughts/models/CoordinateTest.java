package draughts.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class CoordinateTest {
    
    @Test
    public void givenTwoCoordinatesWhenBetweenDiagonalThenOk() {
        assertEquals(new Coordinate(1, 1), new Coordinate(2, 2).betweenDiagonal(new Coordinate(0, 0)));
        assertEquals(new Coordinate(3, 1), new Coordinate(2, 2).betweenDiagonal(new Coordinate(4, 0)));
        assertEquals(new Coordinate(3, 3), new Coordinate(2, 2).betweenDiagonal(new Coordinate(4, 4)));
        assertEquals(new Coordinate(1, 3), new Coordinate(2, 2).betweenDiagonal(new Coordinate(0, 4)));
    }

    @Test
    public void givenTwoCoordinateThenCalculateDiagonalDistance(){
        assertEquals(3, new Coordinate(3, 4).diagonalDistance(new Coordinate(0, 7)));
    }
    
    @Test
    public void givenCoordinateWhenIsDiagonalUpRightThenTrue() {
        assertTrue(new Coordinate(4, 5).isDiagonal(new Coordinate(3, 6)));
    }

    @Test
    public void givenCoordinateWhenIsDiagonalUpLeftThenTrue() {
        assertTrue(new Coordinate(4, 5).isDiagonal(new Coordinate(3, 4)));
    }

    @Test
    public void givenCoordinateWhenIsDiagonalDownRightThenTrue() {
        assertTrue(new Coordinate(4, 5).isDiagonal(new Coordinate(5, 6)));
    }

    @Test
    public void givenCoordinateWhenIsDiagonalDownLeftThenTrue() {
        assertTrue(new Coordinate(4, 5).isDiagonal(new Coordinate(5, 4)));
    }
    
    @Test
    public void givenCoordinateWhenIsDiagonalUpThenFalse() {
        assertFalse(new Coordinate(4, 5).isDiagonal(new Coordinate(3, 5)));
    }

    @Test
    public void givenCoordinateWhenIsDiagonalDownThenFalse() {
        assertFalse(new Coordinate(4, 5).isDiagonal(new Coordinate(5, 5)));
    }

    @Test
    public void givenCoordinateWhenIsDiagonalLeftThenFalse() {
        assertFalse(new Coordinate(4, 5).isDiagonal(new Coordinate(4, 4)));
    }

    @Test
    public void givenCoordinateWhenIsDiagonalRightThenFalse() {
        assertFalse(new Coordinate(4, 5).isDiagonal(new Coordinate(4, 6)));
    }
    
    @Test(expected = AssertionError.class)
    public void givenCoordinateWhenIsDiagonalNullThenException() {
        new Coordinate(4, 5).isDiagonal(null);
    }
    
    @Test(expected = AssertionError.class)
    public void givenCoordinateWhenNullBetweenDiagonalThenException() {
        new Coordinate(2, 2).betweenDiagonal(null);
    }
}
