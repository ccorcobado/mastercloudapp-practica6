package draughts.views.console;

import draughts.controllers.ResumeController;
import draughts.utils.YesNoDialog;
import draughts.types.Message;
import draughts.utils.Console;

public class ResumeView {
    
    private BoardView boardView;
    private YesNoDialog dialog;
    private Console console;
    private ResumeController resumeController;
    
    public ResumeView(ResumeController resumeController) {
        this.resumeController = resumeController;
        this.console = new Console();
        this.dialog = new YesNoDialog();
        this.boardView = new BoardView();
    }
    
    public void interact() {
        this.boardView.writeln(this.resumeController.getBoard());
        
        this.console.writeln(Message.END.toString() + 
            " Ganan las fichas " + this.resumeController.getOppositeColor().toString());
        
        boolean continuePlaying = this.continuePlaying();
        this.resumeController.resume(continuePlaying);
    }
    
    private boolean continuePlaying() {
        this.console.writeln(Message.RESUME.toString());
        return this.dialog.read();
    }
}
