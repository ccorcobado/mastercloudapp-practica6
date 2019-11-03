package draughts.controllers;

import draughts.models.Game;
import draughts.models.State;
import org.junit.Test;
import org.junit.Before;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import org.mockito.MockitoAnnotations;

public class ResumeControllerTest {

    @Mock
    private Game game;
    
    @Mock
    private State state;
    
    private ResumeController resumeController;
    
    public ResumeControllerTest() { }
    
    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
        
        this.resumeController = new ResumeController(this.game, this.state);
    }
    
    @Test
    public void givenResumeControllerWhenContinueThenInitialState() {
        this.resumeController.resume(true);
        verify(this.game).clear();
        verify(this.state).reset();
        verify(this.state, times(0)).next();
    }
    
    @Test
    public void givenResumeControllerWhenExitThenExitState() {
        this.resumeController.resume(false);
        verifyZeroInteractions(this.game);
        verify(this.state).next();
    }
}