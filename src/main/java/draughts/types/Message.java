package draughts.types;

public enum Message {
    
    TITLE("----- Las Damas -----"), 
    RESUME("¿Queréis jugar otra?"),
    WINNER("Has ganado!!! ;-)"), 
    LOOSER("Has perdido!!! :-("),
    END("Fin de la partida!!! :) "),
    NEW_LINE("\n");

    private final String message;

    private Message(String message) {
        this.message = message;
    }
    
    @Override
    public String toString() {
        return this.message;
    }
}