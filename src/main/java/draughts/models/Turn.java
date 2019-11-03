package draughts.models;

import draughts.types.Color;

public class Turn {
    private Color color;

    public Turn(){
        this.color = Color.WHITE;
    }

    private Color calculateNextColor() {
        return Color.values()[(this.color.ordinal()+1)%2];
    }
    
    public void change(){
        this.color = this.calculateNextColor();
    }

    public boolean isColor(Color color) {
        return this.color == color;
    }
    
    public Color getOpposite() {
        return this.calculateNextColor();
    }
    
    public Color getColor() {
        return this.color;
    }
    
    @Override
    public String toString(){
        return this.color.toString();
    }
}