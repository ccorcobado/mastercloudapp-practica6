package draughts.views.console;

import draughts.controllers.PlayController;
import draughts.models.Coordinate;
import draughts.types.Error;
import draughts.utils.Console;

public class PlayView {

    private BoardView boardView;
    private Console console;
    private PlayController playController;
    
    public PlayView(PlayController playController) {
        this.playController = playController;
        this.console = new Console();
        this.boardView = new BoardView();
    }
    
    public void interact() {
        this.boardView.writeln(this.playController.getBoard());
        
        String colorTurn = this.playController.getColor().toString();
        this.console.writeln();

        Error error;
        do {
            try {
                String command = this.console.readString("Mueven las " + colorTurn + ": ");
                int origin = Integer.parseInt(command.substring(0, 2));
                int target = Integer.parseInt(command.substring(3, 5));
                error = this.playController
                        .move(new Coordinate(origin/10, origin%10), 
                              new Coordinate(target/10, target%10));

            } catch (NumberFormatException fne) {
                error = Error.BAD_INPUT;
            }

            if (error != null){
                this.console.writeln("Error!!! " + error.toString());
            }
        } while (error != null);
    }
}