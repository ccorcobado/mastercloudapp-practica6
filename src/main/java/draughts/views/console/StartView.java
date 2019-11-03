package draughts.views.console;

import draughts.controllers.StartController;
import draughts.types.Message;
import draughts.utils.Console;

public class StartView {
    
    private Console console;
    private StartController startController;
    
    public StartView(StartController startController) { 
        this.startController = startController;
        this.console = new Console();
    }

    public void interact() {
        this.startController.start();
        this.console.writeln(Message.TITLE.toString());
    }
}