package draughts.types;

public enum Error {
    BAD_INPUT("No te entiendo: <d><d>{,<d><d>}[0-2]"),
    OUT_COORDINATE("No es una coordenada del tablero"), 
    EMPTY_ORIGIN("No hay ficha que mover"), 
    OPPOSITE_PIECE("No es una de tus fichas"), 
    NOT_DIAGONAL("No vas en diagonal"), 
    BAD_DISTANCE("No está vacío el destino"),
    NOT_EMPTY_TARGET("No comes contrarias"), 
    NOT_ADVANCED("No avanzas"), 
    EATING_EMPTY("No se puede comer tantas en un salto");
    
    private final String message;
    
    private Error(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
