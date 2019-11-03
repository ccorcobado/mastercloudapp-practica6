package draughts.controllers;

import draughts.types.Error;
import draughts.models.Coordinate;
import draughts.models.Game;
import draughts.models.State;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

public class PlayControllerTest {
    
    @Mock
    private Game game;

    @Mock
    private State state;
    
    public PlayControllerTest() {}
    
    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void givenPlayControllerWhenMovementIsCorrectThenStateNotChange() {
        Coordinate origin = mock(Coordinate.class);
        Coordinate target = mock(Coordinate.class);
        
        when(this.game.isFinished()).thenReturn(false);
        when(this.game.move(origin, target)).thenReturn(null);
        
        PlayController playController = new PlayController(this.game, this.state);
        assertNull(playController.move(origin, target));
        verifyZeroInteractions(this.state);
    }
    
    @Test
    public void givenPlayControllerWhenMovementIsIncorrectThenStateNotChange() {
        Coordinate origin = mock(Coordinate.class);
        Coordinate target = mock(Coordinate.class);
        Error returnedError = Error.OUT_COORDINATE;
        
        when(this.game.isFinished()).thenReturn(false);
        when(this.game.move(origin, target)).thenReturn(returnedError);
        
        PlayController playController = new PlayController(this.game, this.state);
        assertEquals(returnedError, playController.move(origin, target));
        verifyZeroInteractions(this.state);
    }
    
    @Test
    public void givenPlayControllerWhenGameIsFinishedThenStateChange() {
        Coordinate origin = mock(Coordinate.class);
        Coordinate target = mock(Coordinate.class);
        
        when(this.game.isFinished()).thenReturn(true);
        when(this.game.move(origin, target)).thenReturn(null);
        
        PlayController playController = new PlayController(this.game, this.state);
        assertNull(playController.move(origin, target));
        verify(this.state).next();
    }
}
