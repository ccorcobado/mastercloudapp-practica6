package draughts.views.console;

import draughts.models.Board;
import draughts.utils.Console;

public class BoardView {
  
    private Console console;
    
    public BoardView() { 
        this.console = new Console();
    }

    public void writeln(Board board) {
        this.console.writeln();
        this.console.writeln(board.toString());
    }
}
