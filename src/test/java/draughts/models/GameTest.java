package draughts.models;

import draughts.types.Color;
import draughts.types.Error;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

public class GameTest {

    private Game game;

    public GameTest() { }
    
    @Before
    public void before() {
        game = new Game();
    }

    @Test()
    public void givenGameWhenMoveWithOuterCoordinateThenOutCoordinateError() {
        Coordinate[][] coordinates = new Coordinate[][] {
            {new Coordinate(5, 6), new Coordinate(4, 7)},
            {new Coordinate(2, 7), new Coordinate(3, 6)},
            {new Coordinate(4, 7), new Coordinate(3, 8)},
        };
        Error error = null;
        for (int i = 0; i < coordinates.length; i++) {
            assertNull(error);
            error = this.game.move(coordinates[i][0], coordinates[i][1]);
        }
        assertEquals(Error.OUT_COORDINATE, error);
    }

    @Test
    public void givenGameWhenMoveEmptySquaerThenEmptySquareError() {
        Error error = this.game.move(new Coordinate(4, 3), new Coordinate(3, 4));
        assertEquals(Error.EMPTY_ORIGIN, error);
    }

    @Test
    public void givenGameWhenMoveOppositePieceThenError() {
        Coordinate[][] coordinates = new Coordinate[][] {
            {new Coordinate(5, 6), new Coordinate(4, 7)},
            {new Coordinate(2, 7), new Coordinate(3, 6)}, 
            {new Coordinate(3, 6), new Coordinate(2, 7)}
        };
        Error error = null;
        for (int i = 0; i < coordinates.length; i++) {
            assertNull(error);
            error = this.game.move(coordinates[i][0], coordinates[i][1]);
        }
        assertEquals(Error.OPPOSITE_PIECE, error);
    }

    @Test
    public void givenGameWhenNotDiagonalMovementThenError() {
        Error error = this.game.move(new Coordinate(5, 2), new Coordinate(4, 2));
        assertEquals(Error.NOT_DIAGONAL, error);
    }

    @Test
    public void givenGameWhenMoveWithNotAdvancedThenError() {
        Coordinate[][] coordinates = new Coordinate[][] { 
            {new Coordinate(5, 6), new Coordinate(4, 7)},
            {new Coordinate(2, 7), new Coordinate(3, 6)}, 
            {new Coordinate(5, 4), new Coordinate(4, 3)},
            {new Coordinate(1, 6), new Coordinate(2, 7)}, 
            {new Coordinate(4, 3), new Coordinate(3, 4)},
            {new Coordinate(0, 7), new Coordinate(1, 6)}, 
            {new Coordinate(3, 4), new Coordinate(4, 5)},
        };
        Error error = null;
        for (int i = 0; i < coordinates.length; i++) {
            assertNull(error);
            error = this.game.move(coordinates[i][0], coordinates[i][1]);
        }
        assertEquals(Error.NOT_ADVANCED, error);
    }

    @Test
    public void givenGameWhenNotEmptyTargeThenError() {
        Coordinate[][] coordinates = new Coordinate[][] { 
            {new Coordinate(5, 6), new Coordinate(4, 7)},
            {new Coordinate(2, 7), new Coordinate(3, 6)}, 
            {new Coordinate(4, 7), new Coordinate(3, 6)},
        };
        Error error = null;
        for (int i = 0; i < coordinates.length; i++) {
            assertNull(error);
            error = this.game.move(coordinates[i][0], coordinates[i][1]);
        }
        assertEquals(Error.NOT_EMPTY_TARGET, error);
    }

    @Test
    public void givenGameWhenCorrectMovementThenOk() {
        Coordinate origin = new Coordinate(5, 0);
        Coordinate target = new Coordinate(4, 1);
        this.game.move(origin, target);
        assertNull(this.game.getColor(origin));
        assertEquals(Color.WHITE, this.game.getColor(target));
        origin = new Coordinate(2, 3);
        target = new Coordinate(3, 4);
        this.game.move(origin, target);
        assertNull(this.game.getColor(origin));
        assertEquals(Color.BLACK, this.game.getColor(target));
    }

    @Test
    public void givenGameWhenMovementThenEatPiece() {
        Coordinate[][] coordinates = new Coordinate[][]{
            {new Coordinate(5, 0), new Coordinate(4, 1)},
            {new Coordinate(2, 1), new Coordinate(3, 0)}, 
            {new Coordinate(5, 2), new Coordinate(4, 3)},
            {new Coordinate(3, 0), new Coordinate(5, 2)},
        };
        Error error = null;
        for (int i = 0; i < coordinates.length; i++) {
            assertNull(error);
            error = this.game.move(coordinates[i][0], coordinates[i][1]);
        }
        assertNull(error);
        assertNull(this.game.getColor(new Coordinate(3, 0)));
        assertNull(this.game.getColor(new Coordinate(4, 1)));
        assertEquals(Color.BLACK, this.game.getColor(new Coordinate(5, 2)));
    }

    @Test
    public void givenGameWhenEatEmptyPieceThenError() {
        Error error = this.game.move(new Coordinate(5, 4), new Coordinate(3, 2));
        assertEquals(Error.EATING_EMPTY, error);
    }

    @Test
    public void givenGameWhenMoveBadDistanceThenError() {
        Error error = this.game.move(new Coordinate(5, 0), new Coordinate(2, 3));
        assertEquals(Error.BAD_DISTANCE, error);
    }
}
