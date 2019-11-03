package draughts.types;

public enum Color {
    
    WHITE("blancas"), 
    BLACK("negras");
    
    private final String message;
    
    private Color(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
