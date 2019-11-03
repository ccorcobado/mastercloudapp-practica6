package draughts.views;

import draughts.controllers.StartController;
import draughts.types.Message;
import draughts.utils.Console;
import draughts.views.console.StartView;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

 @RunWith(MockitoJUnitRunner.class)
public class StartViewTest {
    
    @Mock
    StartController startController;

    @Mock
    Console console;

    @InjectMocks
    StartView startView;
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void givenStartViewWhenInteractThenStartGame() {
        this.startView.interact();
        verify(this.startController).start();
        verify(this.console).writeln(Message.TITLE.toString());
    }
}
