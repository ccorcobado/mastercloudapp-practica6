package draughts.controllers;

import draughts.models.Board;
import draughts.models.Game;
import draughts.models.State;
import draughts.types.Color;

public abstract class Controller {
    
    protected final Game game;
    protected final State state;
    
    protected Controller(Game game, State state) {
        this.game = game;
        this.state = state;
    }
    
    public Color getColor() {
        return this.game.getTurn().getColor();
    }
    
    public Color getOppositeColor() {
        return this.game.getTurn().getOpposite();
    }

    public Board getBoard() {
        return this.game.getBoard();
    }
    
    public boolean isEndGame() {
        return this.game.isFinished();
    }
    
    public abstract void accept(ControllerVisitor controllerVisitor);
}
