package draughts.views;

import draughts.controllers.PlayController;
import draughts.models.Board;
import draughts.models.Coordinate;
import draughts.types.Color;
import draughts.types.Error;
import draughts.utils.Console;
import draughts.views.console.BoardView;
import draughts.views.console.PlayView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PlayViewTest {
    
    Board board;
    
    @Mock
    PlayController playController;

    @Mock
    Console console;

    @Mock
    BoardView boardView;
    
    @InjectMocks
    PlayView playView;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
        this.board = new Board();
        when(this.playController.getBoard()).thenReturn(this.board);
    }
    
    @Test
    public void givenPlayViewWhenBlackTurnThenInteract2130() {
        when(this.playController.getColor()).thenReturn(Color.BLACK);
        when(this.console.readString("Mueven las negras: ")).thenReturn("21.30\n");
        this.playView.interact();
        verify(this.playController).move(new Coordinate(2,1), new Coordinate(3, 0));
    }

    @Test
    public void givenPlayViewWhenInteractNotDiagonalThenError() {
        when(this.playController.getColor()).thenReturn(Color.BLACK);
        when(this.console.readString(anyString())).thenReturn("31.41").thenReturn("21.30");
        when(this.playController.move((Coordinate) any(), (Coordinate) any())).thenReturn(Error.NOT_DIAGONAL).thenReturn(null);
        this.playView.interact();
        verify(this.playController).move(new Coordinate(3, 1), new Coordinate(4, 1));
        verify(this.playController).move(new Coordinate(2, 1), new Coordinate(3, 0));
        verify(this.console, times(2)).readString(anyString());
        verify(this.console).writeln("Error!!! " + Error.NOT_DIAGONAL);
    }
    
    @Test
    public void givenPlayViewWhenInteractWithInvalidInputThenError() {
        when(this.playController.getColor()).thenReturn(Color.BLACK);
        when(this.console.readString(anyString())).thenReturn("2130.4312").thenReturn("21.30");
        this.playView.interact();
        verify(this.playController).move(new Coordinate(2, 1), new Coordinate(3, 0));
        verify(this.console, times(2)).readString(anyString());
        verify(this.console).writeln("Error!!! " + Error.BAD_INPUT);
    }

    @Test
    public void givenPlayViewWhenCorrectInputThenOk() {
        when(this.playController.getColor()).thenReturn(Color.WHITE);
        when(this.console.readString((String) any())).thenReturn("21.30");
        this.playView.interact();
        verify(this.playController).move(new Coordinate(2, 1), new Coordinate(3, 0));
        verify(this.console).readString("Mueven las blancas: ");
        verify(this.console, times(0)).writeln(anyString());
    }
}
