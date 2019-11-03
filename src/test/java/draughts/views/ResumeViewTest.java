package draughts.views;

import draughts.controllers.ResumeController;
import draughts.models.Board;
import draughts.models.Turn;
import draughts.types.Color;
import draughts.types.Message;
import draughts.utils.Console;
import draughts.utils.YesNoDialog;
import draughts.views.console.BoardView;
import draughts.views.console.ResumeView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ResumeViewTest {
    
    @Mock
    ResumeController resumeController;

    @Mock
    Console console;

    @Mock
    YesNoDialog yesNoDialog;

    @Mock
    BoardView BoardView;

    @InjectMocks
    ResumeView resumeView;
    
    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void givenResumeViewWhenInteractWithUserThenResumeGame() {
        Board board = new Board();
        boolean resume = true;
        when(this.resumeController.getBoard()).thenReturn(board);
        when(this.resumeController.getOppositeColor()).thenReturn(Color.WHITE);
        when(this.yesNoDialog.read()).thenReturn(resume);
        
        this.resumeView.interact();
        verify(this.console).writeln(Message.RESUME.toString());
        verify(this.resumeController).resume(resume);
    }
}
