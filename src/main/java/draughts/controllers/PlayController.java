package draughts.controllers;

import draughts.models.Coordinate;
import draughts.models.Game;
import draughts.models.State;
import draughts.types.Error;

public class PlayController extends Controller {

    public PlayController(Game game, State state) {
        super(game, state);
    }
    
    public Error move(Coordinate origin, Coordinate target) {
        Error error = this.game.move(origin, target);
        
        if (error == null && this.game.isFinished()) {
            this.state.next();
        }
        
        return error;
    }
    
    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }
}
