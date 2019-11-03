package draughts.controllers;

import draughts.models.Game;
import draughts.models.State;
import draughts.models.Turn;
import draughts.types.Color;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;

public class StartControllerTest {
    
    public StartControllerTest() {}
    
    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void givenStartControllerWhenGameStartThenWhiteTurn() {
        Game game = new Game();
        State state = new State();
        StartController startController = new StartController(game, state);
        Color color = startController.getColor();
        assertEquals(color, Color.WHITE);
    }
    
    @Test
    public void givenStartControllerWhenGameStartGameThenStateValueInPlay() {
        Game game = Mockito.mock(Game.class);
        State state = Mockito.mock(State.class);
        StartController startController = new StartController(game, state);
        startController.start();
        verify(state).next();
    }
}